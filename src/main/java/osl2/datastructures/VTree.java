package osl2.datastructures;

import osl2.datastructures.interfaces.IDatastructure;
import osl2.datastructures.interfaces.ITree;
import osl2.datastructures.nodey.NodeyDatastructure;
import osl2.datastructures.nodey.VGraphNode;
import osl2.messaging.datastructures.VGraphCommunication;
import osl2.messaging.datastructures.VGraphNodeCommunication;
import osl2.messaging.datastructures.VTreeCommunication;
import osl2.messaging.errorHandling.TreeErrors.TreeChildNotExistingError;
import osl2.messaging.errorHandling.TreeErrors.TreeNoChildError;
import osl2.messaging.errorHandling.TreeErrors.TreeNoParentError;
import osl2.messaging.errorHandling.TreeErrors.TreeNotALeafError;
import osl2.messaging.errorHandling.UserError;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.datastructures.GUIGraph;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class VTree<T> extends NodeyDatastructure<T, VGraphCommunication<T>, VGraphNodeCommunication<T>, VGraphNode<T>> implements ITree, IDatastructure {
    private Map<VGraphNode, LinkedList<VGraphNode>> map;
    private Map<VGraphNode, VGraphNode> parentMap;
    private Map<VGraphNode, Integer> heightMap;

    private int height;

    private VGraphNode root;

    public VTree(String name) {
        map = new HashMap<>();
        parentMap = new HashMap<>();
        heightMap = new HashMap<>();
        this.root = new VGraphNode<String>(this);
        root.setValue("HEAD");
        map.put(root, new LinkedList<VGraphNode>());
        heightMap.put(root, 0);
        height = 0;
        super.setName(name);
    }

    public VGraphNode addTreeNode(){
        VGraphNode node = super.addNode();
        map.put(node, new LinkedList<VGraphNode>());
        return node;
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
        parentMap.put(child, parent);
        parent.connect(child);
        heightMap.put(child, heightMap.get(parent) + 1);
        if(heightMap.get(parent) + 1 > height){
            height = heightMap.get(parent) + 1;
        }
        return true;
    }

    @Override
    public boolean removeLeave(VGraphNode node) {
        if(map.get(node).isEmpty()){
            map.remove(node);
            parentMap.remove(node);
            heightMap.remove(node);
            node.disconnectAll();
            super.removeNode(node);
            boolean heightIsSmaller = true;
            for(Integer nodeHeight: heightMap.values()){
                if(height == nodeHeight){
                 heightIsSmaller = false;
                }
            }
            if(heightIsSmaller){
                height--;
            }
            return true;
        } else {
            UserError userError = new TreeNotALeafError<>(node);
            getBroadcaster().send((b) -> b.handleError(userError));
            return false;
        }
    }

    @Override
    public Collection<VGraphNode> getChildren(VGraphNode parent) {
        if(map.containsKey(parent)) {
            return map.get(parent);
        } else {
            UserError userError = new TreeNoChildError<>(parent);
            getBroadcaster().send((b) -> b.handleError(userError));
            return null;
        }
    }

    @Override
    public VGraphNode getParent(VGraphNode child) {
        if(parentMap.containsKey(child)){
            return parentMap.get(child);
        } else {
            UserError userError = new TreeNoParentError<>(child);
            getBroadcaster().send((b) -> b.handleError(userError));
            return null;
        }
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public boolean swap(VGraphNode child, VGraphNode parent) {
        LinkedList<VGraphNode> childData = map.get(child);
        LinkedList<VGraphNode> parentData = map.get(parent);
        for(VGraphNode node: map.get(parent)){
            parent.disconnect(node);
        }
        for(VGraphNode node: map.get(child)){
            child.disconnect(node);
        }
        parentData.remove(child);
        parentData.add(parent);
        map.remove(child);
        map.remove(parent);
        map.put(child, parentData);
        map.put(parent, childData);
        for(VGraphNode node: map.get(parent)){
            parent.connect(node);
        }
        for(VGraphNode node: map.get(child)){
            child.connect(node);
        }
        VGraphNode parentParent = parentMap.get(parent);
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
        for(VGraphNode node: map.keySet()){
            super.removeNode(node);
        }
        map = new HashMap<>();
        parentMap = new HashMap<>();
        heightMap = new HashMap<>();
        height = 0;
        this.root = new VGraphNode<String>(this);
        root.setValue("HEAD");
        map.put(root, new LinkedList<VGraphNode>());
        heightMap.put(root, 0);
        return true;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }
}
