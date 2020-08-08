import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import osl2.datastructures.VGraph;
import osl2.datastructures.nodey.VEdge;
import osl2.datastructures.nodey.VGraphNode;
import osl2.view.ui.EvanstonWindow;

import java.util.ArrayList;
import java.util.Collection;

public class VGraphTest {
    private VGraph graph;

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
        graph = new VGraph("Test");

        nodeA = new VGraphNode(graph);
        nodeB = new VGraphNode(graph);
        nodeC = new VGraphNode(graph);
        nodeD = new VGraphNode(graph);

        graph.addEdge(nodeA, nodeB);
        graph.addEdge(nodeC, nodeD);
        graph.addEdge(nodeA, nodeC);
    }

    @Test
    public void size() {
        Assertions.assertEquals(4, graph.size());
    }

    @Test
    void addNode() {
        VGraphNode nodeE = new VGraphNode(graph);
        graph.addNode(nodeE);
        Assertions.assertTrue(graph.containsNode(nodeE));
    }

    @Test
    void addEdge() {
        VGraphNode nodeE = new VGraphNode(graph);
        VGraphNode nodeF = new VGraphNode(graph);
        graph.addEdge(nodeE, nodeF);
        Assertions.assertTrue(graph.containsEdge(nodeE, nodeF));
    }

    @Test
    void removeNode() {
        VGraphNode nodeE = new VGraphNode(graph);

        graph.addNode(nodeE);
        Assertions.assertTrue(graph.containsNode(nodeE));

        graph.removeNode(nodeE);
        Assertions.assertFalse(graph.containsNode(nodeE));
    }

    @Test
    void removeEdge() {
        VGraphNode nodeE = new VGraphNode(graph);
        VGraphNode nodeF = new VGraphNode(graph);

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
