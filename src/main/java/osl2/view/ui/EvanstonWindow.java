package osl2.view.ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;
import osl2.Evanston;
import osl2.datastructures.EvanstonDatastructure;
import osl2.messaging.Broadcaster;
import osl2.messaging.PlayController;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.inlinerepresentation.InlineRepresentation;
import osl2.view.ui.mirror.MirrorController;
import osl2.view.ui.settings.SettingsController;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The MainWindow in which the MainRegion, PlaySpace and Sidebar will be in.
 */
public class EvanstonWindow extends Application implements PropertyChangeListener {
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 900;
    private static Object WAITER = new Object();

    private static EvanstonWindow singletonInstance = null;
    private static Thread APP_THREAD = null;
    private final SettingsController settingsController;
    private final PlayController playController;
    private final ScrollPane mainRegionScrollContainer;
    private final double WINDOW_SIZE_BUFFER = 15;
    private Stage evanstonStage;
    private Scene scene;
    private MainRegion mainRegion;
    private PlaySpace playSpace;
    private SideBar sideBar;
    private SplitPane verticalSplitter;
    private SplitPane sidePlaySplitter;
    private final double VERTICAL_DIVIDER_POSITION = 0;

    /**
     * Creates a new evanston window.
     */
    public EvanstonWindow() {
        if (singletonInstance == null) {
            singletonInstance = this;
        } else {
            System.out.println("Warning: More than one EvanstonWindow instance loaded!");  // ERROR
        }
        this.playController = new PlayController();
        this.settingsController = new SettingsController(this);
        this.mainRegionScrollContainer = new ScrollPane();
        this.mainRegionScrollContainer.getStyleClass().add("main-region-container");
    }

    /**
     * Returns the EvanstonWindow singleton.
     * @return The EvanstonWindow singleton.
     */
    public static EvanstonWindow getInstance() {
        return singletonInstance;
    }

    /**
     * Opens the evanston window.
     */
    public static void open() {
        if (APP_THREAD == null) {
            APP_THREAD = new Thread(() -> Application.launch(EvanstonWindow.class));
            APP_THREAD.start();
            /*
             * Wait for the application to initialize
             */
            if (WAITER != null) {
                synchronized (WAITER) {
                    try {
                        WAITER.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * Creates a new visualization and mirror for a Datastructure.
     *
     * @param datastructure the Datastructure wich will be visualized.
     * @return The Broadcaster for this visualizisation.
     */
    public Broadcaster openVisualization(EvanstonDatastructure datastructure) {
        DatastructureVisualization visualization = datastructure.createVisualization();
        Platform.runLater(() -> {
            MirrorController mc = new MirrorController(visualization, mainRegion, sideBar);
            visualization.setMirrorController(mc);
            InlineRepresentation.registerInlineAction(datastructure, () -> mc.mirrorBtnClicked());
        });
        return new Broadcaster(visualization);
    }

    /**
     * Returns the Playcontroller for the window.
     *
     * @return The Playcontroller.
     */
    public PlayController getPlayController() {
        return playController;
    }

    /**
     * Starts the JavaFX Visualisation.
     *
     * @param stage The Stage in wich it will be started.
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("Evanston Live Data Visualizer");

        this.mainRegion = new MainRegion();

        setUpSpaces();
        Evanston.getPlayController().addPropertyChangeListener(this);

        scene = new Scene(verticalSplitter, WIDTH, HEIGHT);
        setFontSize(FontSize.MEDIUM);
        setTheme(Theme.DARK);
        stage.setScene(scene);
        this.evanstonStage = stage;
        stage.setMaximized(true);
        stage.show();



        /*
         * Notify the other threads that we are up and running
         */
        if (WAITER != null) {
            synchronized (WAITER) {
                WAITER.notifyAll();
                WAITER = null;
            }
        }
    }

    /**
     * Returns the stage.
     * @return The stage.
     */
    public Stage getStage() {
        return this.evanstonStage;
    }

    /**
     * This method sets up the splitter between the Sidebar, Playspace and Mainregion.
     */
    private void setUpSpaces() {
        sideBar = new SideBar();
        playSpace = new PlaySpace(this);

        setUpSidePlaySplitter();
        setUpVerticalSplitter();
    }

    /**
     * This method sets up the splitter between the Mainregion and the space with the Sidebar and Playspace.
     */
    private void setUpVerticalSplitter() {
        setUpMainRegion();

        verticalSplitter = new SplitPane(sidePlaySplitter, this.mainRegionScrollContainer);
        verticalSplitter.setOrientation(Orientation.HORIZONTAL);
        verticalSplitter.setDividerPosition(0, VERTICAL_DIVIDER_POSITION);
    }

    private void setUpMainRegion() {
        this.mainRegionScrollContainer.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        this.mainRegionScrollContainer.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.mainRegionScrollContainer.setOnMouseEntered((event) -> {
            this.mainRegionScrollContainer.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            this.mainRegionScrollContainer.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        });
        this.mainRegionScrollContainer.setOnMouseExited((event) -> {
            this.mainRegionScrollContainer.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            this.mainRegionScrollContainer.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        });
        this.mainRegionScrollContainer.pannableProperty().set(true);
        this.mainRegionScrollContainer.fitToWidthProperty();
        this.mainRegionScrollContainer.setContent(mainRegion);

        mainRegion.setMinWidth(WIDTH * (1 - VERTICAL_DIVIDER_POSITION) - WINDOW_SIZE_BUFFER);
        mainRegion.setMinHeight(HEIGHT - WINDOW_SIZE_BUFFER);
    }

    /**
     * This method sets up the  splitter between Sidebar and Playspaces.
     */
    private void setUpSidePlaySplitter() {
        sidePlaySplitter = new SplitPane(sideBar, playSpace);
        sidePlaySplitter.setOrientation(Orientation.VERTICAL);
    }

    /**
     * Makes one step in the visualization.
     */
    public void playStepButtonClicked() {
        Evanston.getPlayController().step();
    }

    /**
     * Starts or stops the playing.
     */
    public void playAutoButtonClicked() {
        Evanston.getPlayController().toggle();
    }

    /**
     * Sets the font size used in the application.
     *
     * @param newFontSize - the new {@link FontSize} to be used
     */
    public void setFontSize(FontSize newFontSize) {
        removeAllFontSizes();
        this.scene.getStylesheets().add(newFontSize.getFileName());
    }

    /**
     * Removes all font sizes.
     */
    private void removeAllFontSizes() {
        for (FontSize fontSize : FontSize.values()) {
            this.scene.getStylesheets().remove(fontSize.getFileName());
        }
    }

    /**
     * Sets the theme used in the window.
     *
     * @param newTheme - the new {@link Theme} to be used
     */
    public void setTheme(Theme newTheme) {
        removeAllThemes();
        this.scene.getStylesheets().add(newTheme.getFileName());

    }

    /**
     * Removes all themes.
     */
    private void removeAllThemes() {
        for (Theme theme : Theme.values()) {
            this.scene.getStylesheets().remove(theme.getFileName());
        }
    }

    /**
     * Opens the settings window.
     */
    public void openSettingsWindow() {
        settingsController.openSettingsWindow();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("isProgramRunning")) {
            if (evt.getNewValue().equals(true)) {
                playSpace.setPlayAutoButtonSymbolToPause();
            } else {
                playSpace.setPlayAutoButtonSymbolToPlay();
            }
        }
    }


}
