package osl2;

import osl2.datastructures.EvanstonDatastructure;
import osl2.datastructures.VArray;
import osl2.datastructures.VTree;
import osl2.datastructures.nodey.VGraphNode;
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
        VTree<Integer> tree = new VTree<Integer>();
        tree.addTreeNode(tree.getRootNode(), 5);
        VTree<Integer> tree2 = new VTree<Integer>();
        VGraphNode<Integer> node = tree2.getRootNode();
        tree.addTreeNode(node, 6);
        //Democlass democlass = new Democlass();
    }
}
