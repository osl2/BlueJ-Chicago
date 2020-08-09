package osl2;

import osl2.datastructures.EvanstonDatastructure;
import osl2.messaging.Broadcaster;
import osl2.messaging.PlayController;
import osl2.view.ui.EvanstonWindow;

public class Evanston {

    /**
     * Opens the visualization.
     *
     * @param datastructure The datastructure.
     * @return The Broadcaster.
     */
    public static Broadcaster openVisualization(EvanstonDatastructure datastructure) {
        EvanstonWindow window = EvanstonWindow.getInstance();
        return window.openVisualization(datastructure);
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

    /**
     * Main method.
     *
     * @param args Args parameter.
     */
    public static void main(String[] args) {
        start();
        Democlass democlass = new Democlass();
    }
}
