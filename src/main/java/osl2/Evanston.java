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

    public static void main(String[] args) {
        EvanstonWindow.open();

        List<String> lil = new VDoublyLinkedList<>("lilList");
        lil.add("Hello");
        lil.add("World");
        lil.add("by");
        lil.add("Evanston");
        lil.clear();

        VGraph<Integer> graph = new VGraph("GraphTest");
        VGraphNode<Integer> node = null;
        VGraphNode<Integer> oldNode = null;
        for (int x = 0; x < 32; x++) {
            node = graph.addNode();
            node.setValue(x + 1);
            if (oldNode != null) oldNode.connect(node);
            oldNode = node;
        }

        VArray<Integer> errorArray = new VArray<>(5);

        VArray<Integer> array = new VArray<Integer>(8);
        Map<Integer, Character> amap = new VMap<>("Map");

        VArray<VArray> arrays = new VArray<>(1);
        arrays.setValue(0, array);


        for (int i = 0; i < 6; i++) {
            errorArray.setValue(i % 5, i);
        }
        errorArray.setName("SetNameTest");
        // IndexOutOfBounds error
        errorArray.setValue(10, 1);

        for (int x = 64; x < 69; x++) amap.put(x, (char) x);
        for (int x = 64; x < 70; x++) amap.put(x, (char) (x + 5));
        amap.remove(66);

        int i = 0;

        loop:
        for (; ; ) {
            for (int x = 0; x < array.size(); x++) {
                if (i == 50) {
                    Breakpoint.block();
                }
                array.setValue(x, i++);
            }
        }
    }
}
