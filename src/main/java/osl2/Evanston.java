package osl2;

import osl2.datastructures.*;
import osl2.datastructures.nodey.VGraphNode;
import osl2.datastructures.nodey.VLinkedList;
import osl2.datastructures.nodey.VLinkedListNode;
import osl2.messaging.Broadcaster;
import osl2.messaging.PlayController;
import osl2.messaging.datastructures.nodey.VLinkedListCommunication;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.ui.EvanstonWindow;

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

        VSinglyLinkedList<Integer> lil = new VSinglyLinkedList<>();
        VLinkedListNode<Integer> node1 = lil.addNode();
        VLinkedListNode<Integer> node2 = lil.addNode();
        node1.setValue(1);
        node2.setValue(2);
        node1.setForward(node2);
        node2.setBackward(node1);

        VGraph<Integer> graph = new VGraph();
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
        Map<Integer, Character> amap = new VMap<>();
        VArray<VArray> arrays = new VArray<>(1);
        arrays.setValue(0, array);

        for (int i = 0; i < 6; i++) {
            errorArray.setValue(i % 5, i);
        }
        errorArray.setName("blub");
        // IndexOutOfBounds error
        // errorArray.setValue(10, 1);

        for (int x = 64; x < 69; x++) amap.put(x, (char) x);
        for (int x = 64; x < 70; x++) amap.put(x, (char) (x + 5));
        amap.remove(66);

        int i = 0;

        loop:
        for (; ; ) {
            for (int x = 0; x < array.size(); x++) {
                array.setValue(x, i++);
            }
        }
    }
}
