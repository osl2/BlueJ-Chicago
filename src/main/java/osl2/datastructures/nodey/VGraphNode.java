package osl2.datastructures.nodey;

import osl2.messaging.datastructures.VGraphNodeCommunication;
import osl2.view.datastructures.nodey.GUIGraphNode;

import java.util.HashSet;
import java.util.Set;

public class VGraphNode<T> extends VNode<VGraphNodeCommunication<T>, T> {
    private Set<VGraphNode<T>> edges = new HashSet<>();


    public void connect(VGraphNode<T> node) {
        edges.add(node);
        getBroadcaster().sendWithDelay(b -> b.connect(node.getCorrespondent()));
    }

    public void disconnect(VGraphNode<T> node) {
        edges.remove(node);
        getBroadcaster().sendWithDelay(b -> b.disconnect(node.getCommunication()));
    }

    public void disconnectAll() {
        getBroadcaster().send(b -> b.disconnectAll());
        edges.clear();
    }

    public VGraphNode<T>[] getAdjacents() {
        return edges.toArray(new VGraphNode[]{});
    }


    public VGraphNode(NodeyDatastructure parentDS) {
        super(parentDS);
    }

    @Override
    protected VGraphNodeCommunication<T> createVisualization() {
        return new GUIGraphNode<T>();
    }
}
