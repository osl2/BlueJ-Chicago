package osl2.view.ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.stage.Stage;
import osl2.messaging.PlayController;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.datastructures.GUINode;
import osl2.view.ui.mirror.MirrorController;

public class EvanstonWindow extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static Object WAITER = new Object();

    private static EvanstonWindow singletonInstance = null;
    private static Thread APP_THREAD = null;

    private final PlayController playController;

    private MainRegion mainRegion;

    private PlaySpace playSpace;
    private SideBar sideBar;
    private SplitPane verticalSplitter;
    private SplitPane sidePlaySplitter;

    public EvanstonWindow() {
        if (singletonInstance == null) {
            singletonInstance = this;
        } else {
            System.out.println("Warning: More than one EvanstonWindow instance loaded!");  // ERROR
        }
        this.playController = new PlayController();
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

    public void openVisualization(DatastructureVisualization visualization) {
        Platform.runLater(() -> {
            new MirrorController(visualization, mainRegion, sideBar);
        });
    }

    public PlayController getPlayController() {
        return playController;
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Evanston Live Data Visualizer");

        this.mainRegion = new MainRegion();

        new GUINode(mainRegion);

        setUpSpaces();

        Scene scene = new Scene(verticalSplitter, WIDTH, HEIGHT);
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

    private void setUpSpaces() {
        sideBar = new SideBar();
        playSpace = new PlaySpace();

        setUpSidePlaySplitter();
        setUpVerticalSplitter();
    }

    private void setUpVerticalSplitter() {
        verticalSplitter = new SplitPane(sidePlaySplitter, mainRegion);
        verticalSplitter.setOrientation(Orientation.HORIZONTAL);
        verticalSplitter.setDividerPosition(0, 0.25);
    }

    private void setUpSidePlaySplitter() {
        playSpace = new PlaySpace();
        sidePlaySplitter = new SplitPane(sideBar, playSpace);
        sidePlaySplitter.setOrientation(Orientation.VERTICAL);
    }
}
