package TestScenarios.TestScenario40;

import osl2.Evanston;
import osl2.datastructures.VArray;
import osl2.datastructures.VDirectedGraph;
import osl2.datastructures.nodey.VGraphNode;

public class TestScenario40 {
    private final int sizeA = 10;
    private final int sizeT = 9;
    private final int sizeB = 1;
    private VArray<Integer> arrayA;
    private VDirectedGraph<VArray<Integer>> graphG;
    private VArray<Integer> arrayT;
    private VArray<Integer> arrayB;

    public TestScenario40() {
        Evanston.start();
    }

    public void executeScenario() {
        setUpArrayA();
        errorCallsOnArrayA();

        setUpGraphG();
        VGraphNode<VArray<Integer>> nodeA = graphG.addNode(arrayA);

        setUpArrayT();
        VGraphNode<VArray<Integer>> nodeT = graphG.addNode(arrayT);

        graphG.addEdge(nodeA, nodeT);

        setUpArrayB();
        VGraphNode<VArray<Integer>> nodeB = graphG.addNode(arrayB);
    }

    private void setUpArrayA() {
        arrayA = new VArray<>(sizeA, "A");
        for (int i = 0; i < sizeA; i++) {
            arrayA.setValue(i, i * 72 % 8);
        }
    }

    private void errorCallsOnArrayA() {
        arrayA.setValue(-1, 3);
    }

    private void setUpGraphG() {
        graphG = new VDirectedGraph<>("G");
    }

    private void setUpArrayT() {
        arrayT = new VArray<>(sizeT, "T");
        for (int i = 0; i < sizeT; i++) {
            arrayT.setValue(i, i);
        }
    }

    private void setUpArrayB() {
        arrayB = new VArray<>(sizeB, "B");
    }
}
