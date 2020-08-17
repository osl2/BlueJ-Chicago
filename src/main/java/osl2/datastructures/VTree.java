package osl2.datastructures;

import osl2.datastructures.interfaces.IDatastructure;
import osl2.datastructures.interfaces.ITree;
import osl2.datastructures.nodey.NodeyDatastructure;
import osl2.datastructures.nodey.VGraphNode;
import osl2.messaging.datastructures.VGraphCommunication;
import osl2.messaging.datastructures.VGraphNodeCommunication;
import osl2.messaging.errorHandling.TreeErrors.TreeNoChildError;
import osl2.messaging.errorHandling.TreeErrors.TreeNoParentError;
import osl2.messaging.errorHandling.TreeErrors.TreeNotALeafError;
import osl2.messaging.errorHandling.UserError;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.datastructures.GUITree;

import java.util.*;

/**
 * Represents an Tree.
 *
 * @param <T> - The type of the tree
 */
public class VTree<T> extends NodeyDatastructure<T, VGraphCommunication<T>, VGraphNodeCommunication<T>, VGraphNode<T>> implements ITree<T>, IDatastructure {
    private Map<VGraphNode<T>, LinkedList<VGraphNode<T>>> map;
    private Map<VGraphNode<T>, VGraphNode<T>> parentMap;
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
     * @param name - the name of the VTree
     */
    public VTree(String name) {
        init();
        super.setName(name);
    }

    private void init() {
        map = new HashMap<>();
        parentMap = new HashMap<>();
        heightMap = new HashMap<>();
        height = 0;
    }

    @Override
    public VGraphNode<T> addTreeNode() {
        VGraphNode<T> node = super.addNode();
        setRootNodeIfNotSet(node);
        map.put(node, new LinkedList<>());
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
    public VGraphNode<T> getRootNode() {
        if (rootNode == null) {
            this.addTreeNode();
        }
        return rootNode;
    }

    @Override
    public boolean addChild(VGraphNode<T> child, VGraphNode<T> parent) {
        map.get(parent).add(child);
        parentMap.put(child, parent);
        parent.connect(child);
        updateHeight(child, parent);
        return true;
    }

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
        if (map.get(node).isEmpty()) {
            map.remove(node);
            map.get(parentMap.get(node)).remove(node);
            parentMap.remove(node);
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
        if (map.containsKey(parent)) {
            return map.get(parent);
        } else {
            UserError userError = new TreeNoChildError<>(parent);
            getBroadcaster().sendWithPauseBlock(b -> b.handleError(userError));
            return Collections.emptyList();
        }
    }

    @Override
    public VGraphNode<T> getParent(VGraphNode<T> child) {
        if (parentMap.containsKey(child)) {
            return parentMap.get(child);
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
        LinkedList<VGraphNode<T>> childData = map.get(child);
        LinkedList<VGraphNode<T>> parentData = map.get(parent);
        for (VGraphNode<T> node : map.get(parent)) {
            parent.disconnect(node);
        }
        for (VGraphNode<T> node : map.get(child)) {
            child.disconnect(node);
        }
        parentData.remove(child);
        parentData.add(parent);
        map.remove(child);
        map.remove(parent);
        map.put(child, parentData);
        map.put(parent, childData);
        for (VGraphNode<T> node : map.get(parent)) {
            parent.connect(node);
        }
        for (VGraphNode<T> node : map.get(child)) {
            child.connect(node);
        }
        VGraphNode<T> parentParent = parentMap.get(parent);
        parentParent.disconnect(parent);
        parentParent.connect(child);
        parentMap.remove(child);
        parentMap.remove(parent);
        parentMap.put(child, parentParent);
        parentMap.put(parent, child);
        map.get(parentParent).remove(parent);
        map.get(parentParent).add(child);
        return false;
    }

    @Override
    public boolean contains(VGraphNode<T> node) {
        return map.containsKey(node);
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
        return map.size();
    }

    @Override
    public boolean removeAll() {
        for (VGraphNode<T> node : map.keySet()) {
            super.removeNode(node);
        }
        init();
        return true;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }
}
