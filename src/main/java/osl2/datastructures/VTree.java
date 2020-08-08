package osl2.datastructures;

import osl2.datastructures.interfaces.IDatastructure;
import osl2.datastructures.interfaces.ITree;
import osl2.datastructures.nodey.NodeyDatastructure;
import osl2.datastructures.nodey.VGraphNode;
import osl2.messaging.datastructures.VGraphNodeCommunication;
import osl2.messaging.datastructures.VTreeCommunication;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.datastructures.GUIGraph;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class VTree<T> extends NodeyDatastructure<T, VTreeCommunication<T>, VGraphNodeCommunication<T>, VGraphNode<T>> implements ITree, IDatastructure {
    private Map<VGraphNode, LinkedList> map;

    private int height;

    private VGraphNode root;

    public VTree(String name) {
        this.root = new VGraphNode(this);;
        map.put(root, new LinkedList());
        super.setName(name);
    }

    @Override
    protected VGraphNode<T> createNode() {
        return new VGraphNode<T>(this);
    }

    @Override
    public DatastructureVisualization createVisualization() {
        return new GUIGraph(); // TODO change to GUITree
    }

    @Override
    public String getDatastructureType() {
        return "Tree";
    }

    @Override
    public VGraphNode getRootNode() {
        return root;
    }

    @Override
    public boolean addChild(VGraphNode child, VGraphNode parent) {
        map.get(parent).add(child);
        height++;
        return true;
    }

    @Override
    public boolean removeLeave(VGraphNode node) {
        map.remove(node);
        height--;
        return true;
    }

    @Override
    public Collection<VGraphNode> getChildren(VGraphNode parent) {
        return map.get(parent);
    }

    @Override
    public VGraphNode getParent(VGraphNode child) {
        for (VGraphNode node : map.keySet()) {
            if (map.get(node).contains(child)) {
                return node;
            }
        }
        return null; // TODO Evaluate usage of an exception here.
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public boolean swap(VGraphNode child, VGraphNode parent) {
        LinkedList childData = map.get(child);
        LinkedList parentData = map.get(parent);
        parentData.remove(child);
        parentData.add(parent);
        map.put(child, parentData); // TODO add conversion
        map.put(parent, childData);
        return false;
    }

    @Override
    public boolean addTree(VGraphNode parent, ITree child) {
        addChild(child.getRootNode(), parent);
        height += child.getHeight();
        return false;
    }

    @Override
    public boolean contains(VGraphNode node) {
        return map.containsKey(node);
    }

    @Override
    public boolean contains(Collection nodes) {
        for (Object node : nodes) {
            if (!contains((VGraphNode) node))
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
        map = new HashMap<VGraphNode, LinkedList>();
        return true;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }
}
