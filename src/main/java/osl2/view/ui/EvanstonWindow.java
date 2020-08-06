package osl2.view.ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import osl2.Evanston;
import osl2.datastructures.EvanstonDatastructure;
import osl2.messaging.Broadcaster;
import osl2.messaging.PlayController;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.datastructures.nodey.ArrowOverlay;
import osl2.view.inlinerepresentation.InlineRepresentation;
import osl2.view.ui.mirror.MirrorController;
import osl2.view.ui.settings.SettingsController;

/**
 * The MainWindow in which the MainRegion, PlaySpace and Sidebar will be in.
 */
public class EvanstonWindow extends Application {
    private static final int WIDTH = 1200;
    private static final int HEIGHT = 900;
    private static Object WAITER = new Object();

    private static EvanstonWindow singletonInstance = null;
    private static Thread APP_THREAD = null;
    private final SettingsController settingsController;
    private final PlayController playController;
    private Scene scene;
    private ArrowOverlay arrowOverlay;
    private MainRegion mainRegion;
    private PlaySpace playSpace;
    private SideBar sideBar;
    private SplitPane verticalSplitter;
    private SplitPane sidePlaySplitter;
    private boolean isPlaying = false;

    public EvanstonWindow() {
        if (singletonInstance == null) {
            singletonInstance = this;
        } else {
            System.out.println("Warning: More than one EvanstonWindow instance loaded!");  // ERROR
        }
        this.playController = new PlayController();
        this.settingsController = new SettingsController(this);
    }

    public static EvanstonWindow getInstance() {
        return singletonInstance;
    }

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

    public ArrowOverlay getArrowOverlay() {
        return arrowOverlay;
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

        this.arrowOverlay = new ArrowOverlay();
        StackPane root = new StackPane();
        root.getChildren().add(verticalSplitter);
        root.getChildren().add(arrowOverlay);
        arrowOverlay.toFront();

        scene = new Scene(root, WIDTH, HEIGHT);
        scene.getStylesheets().add("Stylesheets/dark_style.css");
        setFontSize(FontSize.MEDIUM);
        stage.setScene(scene);
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
        verticalSplitter = new SplitPane(sidePlaySplitter, mainRegion);
        verticalSplitter.setOrientation(Orientation.HORIZONTAL);
        verticalSplitter.setDividerPosition(0, 0.25);
    }

    /**
     * This method sets up the  splitter between Sidebar and Playspaces.
     */
    private void setUpSidePlaySplitter() {
        sidePlaySplitter = new SplitPane(sideBar, playSpace);
        sidePlaySplitter.setOrientation(Orientation.VERTICAL);
    }

    public void playStepButtonClicked() {
        Evanston.getPlayController().step();
    }

    public void playAutoButtonClicked() {
        Evanston.getPlayController().toggle();
        if (isPlaying) {
            playSpace.setPlayAutoButtonSymbolToPlay();
            isPlaying = false;
        } else {
            playSpace.setPlayAutoButtonSymbolToPause();
            isPlaying = true;
        }

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

    private void removeAllFontSizes() {
        for (FontSize fontSize : FontSize.values()) {
            this.scene.getStylesheets().remove(fontSize.getFileName());
        }
    }

    public void openSettingsWindow() {
        settingsController.openSettingsWindow();
    }
}
