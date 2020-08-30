package osl2.datastructures.nodey;

import java.util.HashSet;
import java.util.Set;
import osl2.messaging.datastructures.VGraphNodeCommunication;
import osl2.messaging.error_handling.UserError;
import osl2.messaging.error_handling.graph_errors.GraphRecursionError;
import osl2.view.datastructures.nodey.GuiGraphNode;

/**
 * Represents a node in a {@link osl2.datastructures.interfaces.IGraph}.
 *
 * @param <T>
 *         the datatype of the node
 */
public class VGraphNode<T> extends VNode<VGraphNodeCommunication<T>, T> {
    private final Set<VGraphNode<T>> edges = new HashSet<>();
    private final NodeyDatastructure parentDS;

    /**
     * Creates a new GraphNode.
     *
     * @param parentDS
     *         The parent of the graph node
     */
    public VGraphNode(NodeyDatastructure parentDS) {
        super(parentDS);
        this.parentDS = parentDS;
    }

    @Override
    public void setValue(T newValue) {
        if (newValue.equals(parentDS)) {
            UserError userError = new GraphRecursionError();
            getBroadcaster().sendWithPauseBlock(b -> b.handleError(userError));
        }
        super.setValue(newValue);
    }

    /**
     * Adds a node to the edges of this node.
     *
     * @param node
     *         the node to add to the edge list
     */
    public void connect(VGraphNode<T> node) {
        edges.add(node);
        getBroadcaster().sendWithDelay(b -> b.connect(node.getCommunication()));
    }

    /**
     * Removes a node from the edge list.
     *
     * @param node
     *         the node to be removed from the edge list
     */
    public void disconnect(VGraphNode<T> node) {
        edges.remove(node);
        getBroadcaster().sendWithDelay(b -> b.disconnect(node.getCommunication()));
    }

    /**
     * Clears all edges of the node.
     */
    public void disconnectAll() {
        getBroadcaster().send(VGraphNodeCommunication::disconnectAll);
        edges.clear();
    }

    /**
     * Checks if the node is contained in the edges list.
     *
     * @param node
     *         the node to be checked
     * @return true if it is included in the edge list. Else false.
     */
    public boolean contains(VGraphNode<T> node) {
        return edges.contains(node);
    }

    /**
     * Gets all the adjacents of a node.
     *
     * @return all nodes which are adjacent to this one
     */
    public VGraphNode<T>[] getAdjacents() {
        return edges.toArray(new VGraphNode[]{});
    }

    @Override
    protected VGraphNodeCommunication<T> createVisualization() {
        return new GuiGraphNode<>();
    }
}
