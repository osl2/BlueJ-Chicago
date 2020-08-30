package TestScenarios.TestScenario20;

import java.util.LinkedList;
import java.util.List;
import osl2.Evanston;
import osl2.datastructures.VTree;
import osl2.datastructures.nodey.VGraphNode;

public class TestScenario20 {
    VTree<Integer> tree;
    private boolean swapped;

    public TestScenario20() {
        Evanston.start();
        tree = new VTree<>();
    }

    public void auffüllen() {
        tree.setRootNode(6);
        VGraphNode<Integer> node5 = tree.addTreeNode(tree.getRootNode(), 5);
        VGraphNode<Integer> node4 = tree.addTreeNode(tree.getRootNode(), 4);
        VGraphNode<Integer> node3 = tree.addTreeNode(node5, 3);
        VGraphNode<Integer> node2 = tree.addTreeNode(node5, 2);
        VGraphNode<Integer> node1 = tree.addTreeNode(node4, 1);
        VGraphNode<Integer> node0 = tree.addTreeNode(node4, 0);
    }

    /**
     * Sorts the tree with an algorithm similar to bubble sort.
     */
    public void sortieren() {
        VGraphNode<Integer> startNode;
        do {
            swapped = false;
            startNode = tree.getRootNode();
            bubbleTree(startNode);
        } while (swapped);
    }

    /**
     * Call sortNode() on every node on the subtree of curNode recursively.
     *
     * @param curNode
     *         the current node
     */
    private void bubbleTree(VGraphNode<Integer> curNode) {
        curNode = sortNode(curNode);

        List<VGraphNode<Integer>> childrenOfCurNode = new LinkedList<>(tree.getChildren(curNode));
        for (VGraphNode<Integer> childNode : childrenOfCurNode) {
            bubbleTree(childNode);
        }
    }

    /**
     * Exchanges the child inputNode with the smallest value with the parent.
     * Exchange nothing if the parent has the smallest value.
     *
     * @param inputNode
     *         the inputNode to be sorted
     * @return the node that is now were the inputNode was in the graph
     */
    private VGraphNode<Integer> sortNode(VGraphNode<Integer> inputNode) {
        VGraphNode<Integer> smallestNode = inputNode;
        for (VGraphNode<Integer> childNode : tree.getChildren(inputNode)) {
            if (childNode.getValue() < smallestNode.getValue()) {
                smallestNode = childNode;
            }
        }
        if (!smallestNode.equals(inputNode)) {
            tree.swap(smallestNode, inputNode);
            inputNode = smallestNode;
            swapped = true;
        }
        return inputNode;
    }
}
