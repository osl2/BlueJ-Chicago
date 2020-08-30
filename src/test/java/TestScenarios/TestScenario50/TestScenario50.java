package TestScenarios.TestScenario50;

import osl2.Evanston;
import osl2.datastructures.VArray;
import osl2.datastructures.VTree;
import osl2.datastructures.nodey.VGraphNode;

public class TestScenario50 {

    public TestScenario50() {
        Evanston.start();
        executeScenario();
    }

    public void executeScenario() {
        VTree<Integer> treeB = new VTree<>("B");

        treeB.removeLeaf(treeB.getRootNode());

        VArray<VGraphNode<Integer>> nodes = new VArray<VGraphNode<Integer>>(7);
        for (int i = 0; i < nodes.size(); i++) {
            if (i < nodes.size() / 2) {
                VGraphNode<Integer> node = treeB.addTreeNode(treeB.getRootNode(), i);
                nodes.setValue(i, node);
            } else {
                VGraphNode<Integer> node = treeB.addTreeNode(nodes.getValue(1), i);
                nodes.setValue(i, node);
            }
        }

        treeB.getParent(treeB.getRootNode());

        treeB.swap(nodes.getValue(1), treeB.getRootNode());


        VTree<Integer> treeB2 = new VTree<>("B2");
        VGraphNode<Integer> nodeN2 = treeB2.addTreeNode(treeB2.getRootNode());

        VGraphNode<Integer> nodeN = treeB.addTreeNode(nodeN2);
    }
}
