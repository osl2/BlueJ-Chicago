package osl2;

import javafx.application.Platform;
import osl2.datastructures.EvanstonDatastructure;
import osl2.datastructures.VDirectedGraph;
import osl2.datastructures.VTree;
import osl2.datastructures.nodey.VGraphNode;
import osl2.messaging.Broadcaster;
import osl2.messaging.PlayController;
import osl2.view.ui.EvanstonWindow;

public class Evanston {

    /**
     * Opens the visualization.
     *
     * @param datastructure
     *         The datastructure.
     * @return The Broadcaster.
     */
    public static Broadcaster openVisualization(EvanstonDatastructure datastructure) {
        EvanstonWindow window = EvanstonWindow.getInstance();
        return window.openVisualization(datastructure);
    }

    public static void closeVisualization() {
        Platform.exit();
    }

    /**
     * Returns the Playcontroller.
     *
     * @return The playcontroller.
     */
    public static PlayController getPlayController() {
        return EvanstonWindow.getInstance().getPlayController();
    }

    /**
     * Starts the visualizer.
     */
    public static void start() {
        EvanstonWindow.open();
    }

    public static void startForTest(int delay) {
        EvanstonWindow.openForTests(delay);
    }

    /**
     * Main method.
     *
     * @param args
     *         Args parameter.
     */
    public static void main(String[] args) {
        start();
        Democlass democlass = new Democlass();
    }
}
