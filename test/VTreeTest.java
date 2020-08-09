import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import osl2.datastructures.VGraph;
import osl2.datastructures.VTree;
import osl2.datastructures.nodey.VGraphNode;
import osl2.view.ui.EvanstonWindow;

import java.util.ArrayList;
import java.util.Collection;

public class VTreeTest {
    private VTree tree;

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
        nodeA = new VGraphNode(tree);
        tree = new VTree("Test");

        nodeA = tree.getRootNode();
        nodeB = new VGraphNode(tree);
        nodeC = new VGraphNode(tree);
        nodeD = new VGraphNode(tree);

        tree.addChild(nodeA, nodeB);
        tree.addChild(nodeA, nodeC);
        tree.addChild(nodeC, nodeD);
    }

    @Test
    void getRootNode() {
        Assertions.assertTrue(tree.getRootNode().equals(nodeA)); // TODO is this really the best way?
    }

    @Test
    void addChild() {
        VGraphNode nodeE = new VGraphNode(tree);
        tree.addChild(nodeB, nodeE);

        Assertions.assertTrue(tree.contains(nodeE));
        Assertions.assertTrue(tree.getParent(nodeE).equals(nodeB));

    }

    @Test
    void removeLeave() {
        Assertions.assertTrue(tree.getChildren(nodeC).contains(nodeD));
        tree.removeLeaf(nodeD);
        Assertions.assertFalse(tree.getChildren(nodeC).contains(nodeD));
    }

    @Test
    void getChildren() {
        Collection children = new ArrayList();
        children.add(nodeB);
        children.add(nodeC);
        children.add(nodeD);
        tree.getChildren(nodeA);

        Assertions.assertTrue(children.containsAll(tree.getChildren(nodeA)));
    }

    @Test
    void getParent() {
        Assertions.assertTrue(tree.getParent(nodeD).equals(nodeC));
    }

    @Test
    void getHeight() {
        Assertions.assertEquals(2, tree.getHeight());
    }

    @Test
    void swap() {
        tree.swap(nodeD, nodeC);
        Assertions.assertTrue(tree.getParent(nodeD).equals(nodeA));
        Assertions.assertTrue(tree.getParent(nodeC).equals(nodeD));
    }

    @Test
    void contains() {
        Assertions.assertTrue(tree.contains(nodeC));
    }

    @Test
    void containsCollection() {
        Collection children = new ArrayList();
        children.add(nodeB);
        children.add(nodeC);

        Assertions.assertTrue(tree.contains(children));
    }

    @Test
    void size() {
        Assertions.assertEquals(4, tree.size());
    }

    @Test
    void removeAll() {
        tree.removeAll();
        Assertions.assertTrue(tree.isEmpty());
    }

    @Test
    void isEmpty() {
        Assertions.assertFalse(tree.isEmpty());
    }
}
