package osl2;

import osl2.datastructures.*;
import osl2.datastructures.nodey.VGraphNode;
import osl2.datastructures.nodey.VLinkedListNode;
import osl2.messaging.Broadcaster;
import osl2.messaging.PlayController;
import osl2.view.ui.EvanstonWindow;

import java.util.List;
import java.util.Map;

public class Evanston {

    public static Broadcaster openVisualization(EvanstonDatastructure datastructure) {
        EvanstonWindow window = EvanstonWindow.getInstance();
        return window.openVisualization(datastructure);
    }

    public static PlayController getPlayController() {
        return EvanstonWindow.getInstance().getPlayController();
    }

    public static void start() {
        EvanstonWindow.open();
    }

    public static void main(String[] args) {
        start();
    }
}
