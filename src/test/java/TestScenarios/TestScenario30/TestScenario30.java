package TestScenarios.TestScenario30;

import osl2.Evanston;
import osl2.datastructures.VDirectedGraph;
import osl2.datastructures.nodey.VGraphNode;

public class TestScenario30 {
    VGraphNode<String> nodeA;
    VGraphNode<String> nodeB;
    VGraphNode<String> nodeC;
    VGraphNode<String> nodeD;
    VGraphNode<String> nodeE;
    private VDirectedGraph<String> graph;

    public TestScenario30() {
        Evanston.start();
        this.init();
    }

    private void init() {
        graph = new VDirectedGraph<>("Test Graph");

        nodeA = graph.addNode("A");
        nodeB = graph.addNode("B");
        nodeC = graph.addNode("C");
        nodeD = graph.addNode("D");
        nodeE = graph.addNode("E");

        graph.addEdge(nodeA, nodeB);
        graph.addEdge(nodeA, nodeC);
        graph.addEdge(nodeB, nodeD);
        graph.addEdge(nodeC, nodeD);
        graph.addEdge(nodeD, nodeE);
    }

    public void replace(VGraphNode<String> node, String newValue) {
        node.setValue(newValue);
    }

    public void newEdge(VGraphNode<String> node1, VGraphNode<String> node2) {
        graph.addEdge(node1, node2);
    }
}
