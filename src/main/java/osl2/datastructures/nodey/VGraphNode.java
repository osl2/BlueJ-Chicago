package osl2.datastructures.nodey;

import java.util.HashSet;
import java.util.Set;
import osl2.messaging.datastructures.VGraphNodeCommunication;
import osl2.messaging.errorHandling.GraphErrors.GraphRecursionError;
import osl2.messaging.errorHandling.UserError;
import osl2.view.datastructures.nodey.GUIGraphNode;

/**
 * The class for a Node inside a graph.
 *
 * @param <T>
 *         The datatype of the node.
 */
public class VGraphNode<T> extends VNode<VGraphNodeCommunication<T>, T> {
    private final Set<VGraphNode<T>> edges = new HashSet<>();
    private final NodeyDatastructure parentDS;

    /**
     * Creates a new GraphNode.
     *
     * @param parentDS
     *         The parent of the graphnode.
     */
    public VGraphNode(NodeyDatastructure parentDS) {
        super(parentDS);
        this.parentDS = parentDS;
    }

    @Override
    public void setValue(T newValue) {
        if (newValue.equals(parentDS)) {
            UserError userError = new GraphRecursionError();
            getBroadcaster().sendWithPauseBlock((b) -> b.handleError(userError));
        }
        super.setValue(newValue);
    }

    /**
     * adds a node to the edges of this node
     *
     * @param node
     *         the node to add to the edge list
     */
    public void connect(VGraphNode<T> node) {
        edges.add(node);
        getBroadcaster().sendWithDelay(b -> b.connect(node.getCommunication()));
    }

    /**
     * removes a node from the edge list
     *
     * @param node
     *         the node to be removed from the edge list
     */
    public void disconnect(VGraphNode<T> node) {
        edges.remove(node);
        getBroadcaster().sendWithDelay(b -> b.disconnect(node.getCommunication()));
    }

    /**
     * clears all edges of the node
     */
    public void disconnectAll() {
        getBroadcaster().send(b -> b.disconnectAll());
        edges.clear();
    }

    /**
     * checks if the node is contained in the edges list
     *
     * @param node
     *         the node to be checked
     * @return true if it is included in the edge list. Else false.
     */
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
