package osl2.datastructures;

import osl2.datastructures.nodey.VGraphNode;
import osl2.messaging.errorHandling.GraphErrors.GraphEdgeExistingError;
import osl2.messaging.errorHandling.GraphErrors.GraphEdgeNotExistingError;
import osl2.messaging.errorHandling.GraphErrors.GraphNodeNotExistingError;
import osl2.messaging.errorHandling.UserError;

/**
 * Represent an undirected graph
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
     *         - the name of the graph
     */
    public VUndirectedGraph(String name) {
        super(name);
    }

    @Override
    public boolean addEdge(VGraphNode start, VGraphNode end) {
        if (!containsNode(start)) {
            UserError userError = new GraphNodeNotExistingError<VGraphNode>(start);
            getBroadcaster().sendWithPauseBlock((b) -> b.handleError(userError));
            return false;
        }

        if (!containsNode(end)) {
            UserError userError = new GraphNodeNotExistingError<VGraphNode>(end);
            getBroadcaster().sendWithPauseBlock((b) -> b.handleError(userError));
            return false;
        }

        if (containsEdge(start, end)) {
            UserError userError = new GraphEdgeExistingError<VGraphNode>(start, end);
            getBroadcaster().sendWithPauseBlock((b) -> b.handleError(userError));
            return false;
        }
        start.connect(end);
        end.connect(start);
        return true;
    }

    @Override
    public boolean removeEdge(VGraphNode start, VGraphNode end) {
        if (containsNode(start)) {
            if (start.contains(end)) {
                start.disconnect(end);
                end.disconnect(start);
                return true;
            }
        }
        UserError userError = new GraphEdgeNotExistingError<VGraphNode>(start, end);
        getBroadcaster().sendWithPauseBlock((b) -> b.handleError(userError));
        return false;
    }

}
