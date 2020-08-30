package integration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import osl2.datastructures.*;
import osl2.datastructures.nodey.VGraphNode;
import osl2.view.ui.EvanstonWindow;

public class IntegrationTest {
    @BeforeAll
    static void setupAll() {
        EvanstonWindow.openForTests();
    }

    @Test
    public void testInputtingWrongType() {
        VMap map = new VMap<String, Integer>();
        Assertions.assertEquals(0, map.size());

        VDirectedGraph directedGraph = new VDirectedGraph<Integer>("directed graph");
        map.put(10, directedGraph);
        Assertions.assertEquals(directedGraph, map.get(10));
    }

    @Test
    public void testLinkedListOfMapWithGraphAsKeys() {
        VMap map = new VMap<String, Integer>();
        Assertions.assertEquals(0, map.size());

        VDirectedGraph directedGraph = new VDirectedGraph<Integer>("directed graph");

        for(int i = 0; i < 10; i++) {
            map.put(i, directedGraph);
            Assertions.assertEquals(map.get(i), directedGraph);
        }
        Assertions.assertEquals(10, map.size());
    }

    @Test
    public void testLinkedListOfGraphs() {
        VSinglyLinkedList list = new VSinglyLinkedList<VGraph>("singly");
        Assertions.assertEquals(0, list.size());

        for(int i = 0; i < 10; i++) {
            VDirectedGraph<Integer> graph = new VDirectedGraph<>();
            VGraphNode node = graph.addNode(i);
            VGraphNode node2 = graph.addNode(i + 1);
            node.connect(node2);
            node.connect(node);
            node2.connect(node);

            list.add(graph);
            Assertions.assertEquals(list.get(i), graph);
        }
        Assertions.assertEquals(10, list.size());
    }

    public void testArrayOfGraph() {
        VArray array = new VArray<VGraph>(10);

        for(int i = 0; i < array.size(); i++) {
            VDirectedGraph<Integer> graph = new VDirectedGraph<>();
            VGraphNode node = graph.addNode(i);
            VGraphNode node2 = graph.addNode(i + 1);
            node.connect(node2);
            node.connect(node);
            node2.connect(node);

            array.setValue(i, graph);
            Assertions.assertEquals(array.getValue(i), graph);
        }

        Assertions.assertEquals(10, array.size());
    }
}
