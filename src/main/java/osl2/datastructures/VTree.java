package osl2.datastructures;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import osl2.datastructures.interfaces.IDatastructure;
import osl2.datastructures.interfaces.ITree;
import osl2.datastructures.nodey.NodeyDatastructure;
import osl2.datastructures.nodey.VGraphNode;
import osl2.messaging.datastructures.VGraphCommunication;
import osl2.messaging.datastructures.VGraphNodeCommunication;
import osl2.messaging.errorHandling.TreeErrors.TreeNoChildError;
import osl2.messaging.errorHandling.TreeErrors.TreeNoParentError;
import osl2.messaging.errorHandling.TreeErrors.TreeNotALeafError;
import osl2.messaging.errorHandling.TreeErrors.TreeParentExistingError;
import osl2.messaging.errorHandling.UserError;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.datastructures.GUITree;

/**
 * Represents an Tree.
 *
 * @param <T>
 *         - The type of the tree
 */
public class VTree<T> extends NodeyDatastructure<T, VGraphCommunication<T>, VGraphNodeCommunication<T>, VGraphNode<T>> implements ITree<T>, IDatastructure {
    private Map<VGraphNode<T>, LinkedList<VGraphNode<T>>> mapChildrenToNode;
    private Map<VGraphNode<T>, VGraphNode<T>> mapParentToNode;
    private Map<VGraphNode<T>, Integer> heightMap;

    private int height;

    private VGraphNode<T> rootNode;

    /**
     * Creates a new VTree.
     */
    public VTree() {
        init();
    }

    /**
     * Creates a new {@link VTree} with a specified name.
     *
     * @param name
     *         - the name of the VTree
     */
    public VTree(String name) {
        init();
        super.setName(name);
    }

    /**
     * Initiates the needed places for the data.
     */
    private void init() {
        mapChildrenToNode = new HashMap<>();
        mapParentToNode = new HashMap<>();
        heightMap = new HashMap<>();
        height = 0;
    }

    @Override
    public VGraphNode<T> addTreeNode(VGraphNode<T> parent) {
        if (!mapChildrenToNode.containsKey(parent)) {
            UserError userError = new TreeParentExistingError<>(parent);
            getBroadcaster().sendWithPauseBlock(b -> b.handleError(userError));
            return null;
        }
        VGraphNode<T> node = super.addNode();
        setRootNodeIfNotSet(node);
        mapChildrenToNode.put(node, new LinkedList<>());
        this.addChild(node, parent);
        return node;
    }

    @Override
    public VGraphNode<T> addTreeNode(VGraphNode<T> parent, T value) {
        if (!mapChildrenToNode.containsKey(parent)) {
            UserError userError = new TreeParentExistingError<>(parent);
            getBroadcaster().sendWithPauseBlock(b -> b.handleError(userError));
            return null;
        }
        VGraphNode<T> node = super.addNode();
        node.setValue(value);
        setRootNodeIfNotSet(node);
        mapChildrenToNode.put(node, new LinkedList<>());
        this.addChild(node, parent);
        return node;
    }

    private void setRootNodeIfNotSet(VGraphNode<T> node) {
        if (rootNode == null) {
            rootNode = node;
        }
    }

    @Override
    protected VGraphNode<T> createNode() {
        return new VGraphNode<>(this);
    }

    @Override
    public DatastructureVisualization createVisualization() {
        return new GUITree<T>();
    }

    @Override
    public String getDatastructureType() {
        return "Tree";
    }

    @Override
    public void setRootNode() {
        if (rootNode == null) {
            rootNode = this.createNode();
            mapChildrenToNode.put(rootNode, new LinkedList<>());
        }
    }

    @Override
    public VGraphNode<T> getRootNode() {
        if (rootNode == null) {
            rootNode = this.createNode();
            mapChildrenToNode.put(rootNode, new LinkedList<>());
        }
        return rootNode;
    }

    @Override
    public void setRootNode(T value) {
        if (rootNode == null) {
            rootNode = this.createNode();
            mapChildrenToNode.put(rootNode, new LinkedList<>());
        }
        rootNode.setValue(value);
    }

    /**
     * Adds a child to a parent.
     *
     * @param child
     *         - the child
     * @param parent
     *         - the parent
     * @return true if the child as added successfully, else false
     */
    private boolean addChild(VGraphNode<T> child, VGraphNode<T> parent) {
        mapChildrenToNode.get(parent).add(child);
        mapParentToNode.put(child, parent);
        parent.connect(child);
        updateHeight(child, parent);
        return true;
    }

    /**
     * Updates the height
     *
     * @param child
     *         The child.
     * @param parent
     *         The parent.
     */
    private void updateHeight(VGraphNode<T> child, VGraphNode<T> parent) {
        int childHeight;
        if (heightMap.containsKey(parent)) {
            childHeight = heightMap.get(parent) + 1;
        } else {
            childHeight = 0;
        }
        heightMap.put(child, childHeight + 1);
        if (childHeight > height) {
            height = childHeight;
        }
    }

    @Override
    public boolean removeLeaf(VGraphNode<T> node) {
        if (mapChildrenToNode.get(node).isEmpty()) {
            mapChildrenToNode.remove(node);
            mapChildrenToNode.get(mapParentToNode.get(node)).remove(node);
            mapParentToNode.remove(node);
            heightMap.remove(node);
            node.disconnectAll();
            super.removeNode(node);
            boolean heightIsSmaller = true;
            for (Integer nodeHeight : heightMap.values()) {
                if (height == nodeHeight) {
                    heightIsSmaller = false;
                    break;
                }
            }
            if (heightIsSmaller) {
                height--;
            }
            return true;
        } else {
            UserError userError = new TreeNotALeafError<>(node);
            getBroadcaster().sendWithPauseBlock(b -> b.handleError(userError));
            return false;
        }
    }

    @Override
    public Collection<VGraphNode<T>> getChildren(VGraphNode<T> parent) {
        if (mapChildrenToNode.containsKey(parent)) {
            return mapChildrenToNode.get(parent);
        } else {
            UserError userError = new TreeNoChildError<>(parent);
            getBroadcaster().sendWithPauseBlock(b -> b.handleError(userError));
            return Collections.emptyList();
        }
    }

    @Override
    public VGraphNode<T> getParent(VGraphNode<T> child) {
        if (mapParentToNode.containsKey(child)) {
            return mapParentToNode.get(child);
        } else {
            UserError userError = new TreeNoParentError<>(child);
            getBroadcaster().sendWithPauseBlock(b -> b.handleError(userError));
            return null;
        }
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public boolean swap(VGraphNode<T> child, VGraphNode<T> parent) {
        List<VGraphNode<T>> previousChildrenOfChild = (List<VGraphNode<T>>) mapChildrenToNode.get(child).clone();
        List<VGraphNode<T>> previousChildrenOfParent = (List<VGraphNode<T>>) mapChildrenToNode.get(parent).clone();

        disconnectNodesFromNode(previousChildrenOfChild, child);
        disconnectNodesFromNode(previousChildrenOfParent, parent);

        updateParentOfParent(child, parent);

        List<VGraphNode<T>> childrenOfNewChild = previousChildrenOfParent;
        childrenOfNewChild.remove(child);
        childrenOfNewChild.add(parent);
        connectNodeToNodes(child, childrenOfNewChild);
        connectNodeToNodes(parent, previousChildrenOfChild);

        swapUpdateRootNode(child, parent);
        return true;
    }

    private void swapUpdateRootNode(VGraphNode<T> child, VGraphNode<T> parent) {
        if (parent.equals(rootNode)) {
            rootNode = child;
        }
    }

    private void connectNodeToNodes(VGraphNode<T> node, List<VGraphNode<T>> nodesToConnectTo) {
        for (VGraphNode<T> curNode : nodesToConnectTo) {
            connect(node, curNode);
        }
    }

    private void updateParentOfParent(VGraphNode<T> child, VGraphNode<T> parent) {
        if (mapParentToNode.containsKey(parent)) {
            VGraphNode<T> parentParent = mapParentToNode.get(parent);
            disconnect(parentParent, parent);
            connect(parentParent, child);
        }
    }

    private void disconnectNodesFromNode(List<VGraphNode<T>> nodesToDisconnect, VGraphNode<T> node) {
        for (VGraphNode<T> curNode : nodesToDisconnect) {
            disconnect(node, curNode);
        }
    }

    private void disconnect(VGraphNode<T> fromNode, VGraphNode<T> toNode) {
        fromNode.disconnect(toNode);
        mapParentToNode.remove(toNode);
        mapChildrenToNode.get(fromNode).remove(toNode);
    }

    private void connect(VGraphNode<T> fromNode, VGraphNode<T> toNode) {
        fromNode.connect(toNode);
        mapParentToNode.put(toNode, fromNode);
        mapChildrenToNode.get(fromNode).add(toNode);
    }

    @Override
    public boolean contains(VGraphNode<T> node) {
        return mapChildrenToNode.containsKey(node);
    }

    @Override
    public boolean contains(Collection<VGraphNode<T>> nodes) {
        for (VGraphNode<T> node : nodes) {
            if (!contains(node))
                return false;
        }
        return true;
    }

    @Override
    public int size() {
        return mapChildrenToNode.size();
    }

    @Override
    public boolean removeAll() {
        for (VGraphNode<T> node : mapChildrenToNode.keySet()) {
            super.removeNode(node);
        }
        init();
        return true;
    }

    @Override
    public boolean isEmpty() {
        return mapChildrenToNode.isEmpty();
    }
}
