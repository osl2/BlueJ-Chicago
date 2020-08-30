package osl2.datastructures;

import osl2.datastructures.nodey.VGraphNode;
import osl2.messaging.error_handling.UserError;
import osl2.messaging.error_handling.graph_errors.GraphEdgeExistingError;
import osl2.messaging.error_handling.graph_errors.GraphEdgeNotExistingError;
import osl2.messaging.error_handling.graph_errors.GraphNodeNotExistingError;

/**
 * Represent an undirected graph.
 */
public class VUndirectedGraph<T> extends VGraph<T> {

    /**
     * Creates a new {@link VUndirectedGraph}.
     */
    public VUndirectedGraph() {
        super();
    }

    /**
     * Creates a new {@link VUndirectedGraph} with a name.
     *
     * @param name
     *         the name of the graph
     */
    public VUndirectedGraph(String name) {
        super(name);
    }

    @Override
    public boolean addEdge(VGraphNode<T> start, VGraphNode<T> end) {
        if (!containsNode(start)) {
            UserError userError = new GraphNodeNotExistingError<>(start);
            getBroadcaster().sendWithPauseBlock(b -> b.handleError(userError));
            return false;
        }

        if (!containsNode(end)) {
            UserError userError = new GraphNodeNotExistingError<>(end);
            getBroadcaster().sendWithPauseBlock(b -> b.handleError(userError));
            return false;
        }

        if (containsEdge(start, end)) {
            UserError userError = new GraphEdgeExistingError<>(start, end);
            getBroadcaster().sendWithPauseBlock(b -> b.handleError(userError));
            return false;
        }
        start.connect(end);
        end.connect(start);
        return true;
    }

    @Override
    public boolean removeEdge(VGraphNode<T> start, VGraphNode<T> end) {
        if (containsNode(start) && start.contains(end)) {
            start.disconnect(end);
            end.disconnect(start);
            return true;
        }
        UserError userError = new GraphEdgeNotExistingError<>(start, end);
        getBroadcaster().sendWithPauseBlock(b -> b.handleError(userError));
        return false;
    }
}
