package osl2.view.ui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;
import osl2.Evanston;
import osl2.datastructures.EvanstonDatastructure;
import osl2.messaging.Broadcaster;
import osl2.messaging.PlayController;
import osl2.messaging.error_handling.UserError;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.inlinerepresentation.InlineRepresentation;
import osl2.view.ui.localisation.LanguageController;
import osl2.view.ui.mirror.MirrorController;
import osl2.view.ui.settings.SettingsController;

/**
 * The MainWindow in which the MainRegion, PlaySpace and Sidebar will be in.
 */
public class EvanstonWindow extends Application implements PropertyChangeListener {
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 900;
    private static final double VERTICAL_DIVIDER_POSITION = 0;
    private static Object waiter = new Object();
    private static EvanstonWindow singletonInstance = null;
    private static Thread appThread = null;
    private final SettingsController settingsController;
    private final PlayController playController;
    private final ScrollPane mainRegionScrollContainer;
    private final MainRegion mainRegion;
    private Stage evanstonStage;
    private Scene scene;
    private PlaySpace playSpace;
    private SideBar sideBar;
    private SplitPane verticalSplitter;
    private SplitPane sidePlaySplitter;
    private boolean testModeActive = false;

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
        this.mainRegion = new MainRegion();

        setUpSpaces();
        Evanston.getPlayController().addPropertyChangeListener(this);
    }

    /**
     * Returns the EvanstonWindow singleton.
     *
     * @return The EvanstonWindow singleton.
     */
    public static EvanstonWindow getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new EvanstonWindow();
        }
        return singletonInstance;
    }

    /**
     * Opens the evanston window.
     */
    public static void open() {
        if (appThread == null) {
            appThread = new Thread(() -> Application.launch(EvanstonWindow.class));
            appThread.start();
            /*
             * Wait for the application to initialize
             */
            if (waiter != null) {
                synchronized (waiter) {
                    try {
                        waiter.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public static void openForTests() {
        openForTests(100);
    }

    public static void openForTests(long delay) {
        open();
        getInstance().activateTestMode(delay);
    }

    private void activateTestMode(long delay) {
        this.testModeActive = true;
        playController.activateTestMode(delay);
    }

    /**
     * Creates a new visualization and mirror for a Datastructure.
     *
     * @param datastructure
     *         the Datastructure wich will be visualized.
     * @return The Broadcaster for this visualizisation.
     */
    public Broadcaster openVisualization(EvanstonDatastructure datastructure) {
        DatastructureVisualization visualization = datastructure.createVisualization();
        Platform.runLater(() -> {
            MirrorController mc = new MirrorController(visualization, mainRegion, sideBar);
            visualization.setMirrorController(mc);
            InlineRepresentation.registerInlineAction(datastructure, mc::mirrorBtnClicked);
            if (testModeActive) {
                mc.mirrorBtnClicked();
            }
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
     * @param stage
     *         The Stage in wich it will be started.
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("Evanston Live Data Visualizer");


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
        if (waiter != null) {
            synchronized (waiter) {
                waiter.notifyAll();
                waiter = null;
            }
        }
    }

    /**
     * Returns the stage.
     *
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
        this.mainRegionScrollContainer.setOnMouseEntered(event -> {
            this.mainRegionScrollContainer.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            this.mainRegionScrollContainer.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        });
        this.mainRegionScrollContainer.setOnMouseExited(event -> {
            this.mainRegionScrollContainer.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            this.mainRegionScrollContainer.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        });
        this.mainRegionScrollContainer.pannableProperty().set(true);
        this.mainRegionScrollContainer.fitToWidthProperty();
        this.mainRegionScrollContainer.setContent(mainRegion);

        double windowSizeBuffer = 15;
        mainRegion.setMinWidth(WIDTH * (1 - VERTICAL_DIVIDER_POSITION) - windowSizeBuffer);
        mainRegion.setMinHeight(HEIGHT - windowSizeBuffer);
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
     * @param newFontSize
     *         - the new {@link FontSize} to be used
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
     * @param newTheme
     *         - the new {@link Theme} to be used
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

    /**
     * Getter for the Mainregion. For testing.
     *
     * @return The Mainregion.
     */
    public MainRegion getMainRegion() {
        return this.mainRegion;
    }

    /**
     * Getter for the VerticalSplitter. For testing.
     *
     * @return The VerticalSplitter.
     */
    public SplitPane getVerticalSplitter() {
        return verticalSplitter;
    }

    /**
     * Returns the Playspace. For testing.
     *
     * @return The Playspace.
     */
    public PlaySpace getPlayspace() {
        return this.playSpace;
    }

    /**
     * Returns the SideBar. For testing.
     *
     * @return The Sidebar.
     */
    public SideBar getSideBar() {
        return this.sideBar;
    }

    /**
     * Returns the SidePlaySplitter. For testing.
     *
     * @return The Sideplaysplitter.
     */
    public SplitPane getSidePlaySplitter() {
        return this.sidePlaySplitter;
    }

    /**
     * Shows the error in an errorpane.
     *
     * @param userError
     *         The error of the datastructure.
     */
    public void showErrorDialog(UserError userError) {
        if (!testModeActive) {
            final LanguageController languageController = LanguageController.getLanguageController();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(languageController.getMessage("UserError"));
            alert.setHeaderText(userError.getErrorName());
            String contentText = userError.getErrorContent() + "\n" + languageController.getMessage("ErrorSkipped");
            alert.setContentText(contentText);
            alert.showAndWait();
        } else {
            System.err.println("Evanston Error (suppressed GUI dialog due to activated test mode): "
                    + userError.getErrorName() + " / " + userError.getErrorContent());
        }
    }
}
