package osl2.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import osl2.datastructures.nodey.VEdge;
import osl2.datastructures.nodey.VGraphNode;
import osl2.view.ui.EvanstonWindow;

import java.util.ArrayList;
import java.util.Collection;

public class VGraphTest {
    private VGraph<Integer> graph;

    private VGraphNode nodeA;
    private VGraphNode nodeB;
    private VGraphNode nodeC;
    private VGraphNode nodeD;

    @BeforeAll
    static void setupAll() {
        EvanstonWindow.open();
    }

    @BeforeEach
    void setup() {
        graph = new VDirectedGraph<Integer>("Test");

        nodeA = graph.addNode();
        nodeB = graph.addNode();
        nodeC = graph.addNode();
        nodeD = graph.addNode();

        graph.addEdge(nodeA, nodeB);
        graph.addEdge(nodeC, nodeD);
        graph.addEdge(nodeA, nodeC);
    }

    @Test
    public void size() {
        Assertions.assertEquals(4, graph.size());
    }

    @Test
    void addEdge() {
        VGraphNode nodeE = graph.addNode();
        VGraphNode nodeF = graph.addNode();
        graph.addEdge(nodeE, nodeF);
        Assertions.assertTrue(graph.containsEdge(nodeE, nodeF));
    }

    @Test
    void addEdgeSameEdgeTwice() {
        VGraphNode nodeE = graph.addNode();
        VGraphNode nodeF = graph.addNode();
        graph.addEdge(nodeE, nodeF);
        Assertions.assertTrue(graph.containsEdge(nodeE, nodeF));
        Assertions.assertNull(graph.addEdge(nodeF, nodeE));
    }

    @Test
    void removeNode() {
        graph.removeNode(nodeA);
        Assertions.assertFalse(graph.containsNode(nodeA));
    }

    @Test
    void removeEdge() {
        VGraphNode nodeE = graph.addNode();
        VGraphNode nodeF = graph.addNode();

        graph.addEdge(nodeE, nodeF);
        Assertions.assertTrue(graph.containsEdge(nodeE, nodeF));

        graph.removeNode(nodeE);
        Assertions.assertFalse(graph.containsNode(nodeE));
    }

    @Test
    void getEdges() {
        Collection list = new ArrayList();
        VEdge v1 = new VEdge(nodeA, nodeB);
        VEdge v2 = new VEdge(nodeA, nodeC);
        list.add(v1);
        list.add(v2);

        Assertions.assertTrue(list.containsAll(graph.getEdges(nodeA)));
    }

    @Test
    void containsEdges() {
        Collection list = new ArrayList();
        VEdge v1 = new VEdge(nodeA, nodeB);
        VEdge v2 = new VEdge(nodeA, nodeC);
        list.add(v1);
        list.add(v2);

        Assertions.assertTrue(graph.containsEdges(list));
    }

    @Test
    void getAdjacents() {
        Collection list = new ArrayList();
        list.add(nodeB);
        list.add(nodeC);
        Assertions.assertTrue(list.containsAll(graph.getAdjacents(nodeA)));
    }

    @Test
    void getNodes() {
        Collection list = new ArrayList();
        list.add(nodeA);
        list.add(nodeB);
        list.add(nodeC);
        list.add(nodeD);

        Assertions.assertTrue(list.containsAll(graph.getNodes()));
    }

    @Test
    void containsNode() {
        Assertions.assertTrue(graph.containsNode(nodeA));
    }

    @Test
    void containsNodes() {
        Collection list = new ArrayList();
        list.add(nodeA);
        list.add(nodeB);

        Assertions.assertTrue(graph.containsNodes(list));
    }

    @Test
    void containsEdge() {
        Assertions.assertTrue(graph.containsEdge(nodeA, nodeB));
        Assertions.assertFalse(graph.containsEdge(nodeA, nodeD));
    }

    @Test
    void isEmpty() {
        Assertions.assertFalse(graph.isEmpty());
    }

    @Test
    void removeAll() {
        Assertions.assertFalse(graph.isEmpty());
        graph.removeAll();
        Assertions.assertTrue(graph.isEmpty());
    }
}
