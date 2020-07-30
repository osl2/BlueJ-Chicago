package osl2.evanston.view.ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import osl2.evanston.view.datastructures.DatastructureVisualization;
import osl2.evanston.view.datastructures.GUINode;
import osl2.evanston.view.ui.draggable.Floormat;
import osl2.evanston.view.ui.mirror.Mirror;

public class EvanstonWindow extends Application {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static Object WAITER = new Object();

    private static EvanstonWindow singletonInstance = null;
    public static EvanstonWindow getInstance() { return singletonInstance; }

    private static Thread APP_THREAD = null;
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


    private Floormat mirrors;

    public void openVisualization(DatastructureVisualization visualization) {
        Platform.runLater(() -> {
            new Mirror(mirrors, visualization.getName(), visualization.asNode());
        });
    }


    @Override
    public void start(Stage stage) {
        stage.setTitle("Evanston Live Data Visualizer");

        this.mirrors = new Floormat();

        new GUINode(mirrors);

        Scene scene = new Scene(mirrors, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.show();

        /*
         * Notify the other threads that we are up and running
         */
        if (WAITER != null) {
            synchronized (WAITER) { WAITER.notifyAll(); WAITER = null; }
        }
    }


    public EvanstonWindow() {
        if (singletonInstance == null) {
            singletonInstance = this;
        } else {
            System.out.println("Warning: More than one EvanstonWindow instance loaded!");  // ERROR
        }
    }
}
