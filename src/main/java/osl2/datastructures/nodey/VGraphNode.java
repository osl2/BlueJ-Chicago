package osl2.datastructures.nodey;

import osl2.messaging.datastructures.VGraphNodeCommunication;
import osl2.view.datastructures.nodey.GUIGraphNode;

import java.util.HashSet;
import java.util.Set;

/**
 * The class for a Node inside a graph.
 *
 * @param <T> The datatype of the node.
 */
public class VGraphNode<T> extends VNode<VGraphNodeCommunication<T>, T> {
    private Set<VGraphNode<T>> edges = new HashSet<>();

    /**
     * Creates a new GraphNode.
     *
     * @param parentDS The parent of the graphnode.
     */
    public VGraphNode(NodeyDatastructure parentDS) {
        super(parentDS);
    }

    public void connect(VGraphNode<T> node) {
        // TODO add checks!
        edges.add(node);
        getBroadcaster().sendWithDelay(b -> b.connect(node.getCommunication()));
    }

    public void disconnect(VGraphNode<T> node) {
        edges.remove(node);
        getBroadcaster().sendWithDelay(b -> b.disconnect(node.getCommunication()));
    }

    public void disconnectAll() {
        getBroadcaster().send(b -> b.disconnectAll());
        edges.clear();
    }

    public boolean contains(VGraphNode<T> node) {
        return edges.contains(node);
    }

    /**
     * Returns all the adjacents of a node.
     *
     * @return
     */
    public VGraphNode<T>[] getAdjacents() {
        return edges.toArray(new VGraphNode[]{});
    }

    @Override
    protected VGraphNodeCommunication<T> createVisualization() {
        return new GUIGraphNode<T>();
    }
}
