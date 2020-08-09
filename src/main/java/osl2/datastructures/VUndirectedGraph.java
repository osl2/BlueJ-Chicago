package osl2.datastructures;

import osl2.datastructures.nodey.VGraphNode;
import osl2.messaging.errorHandling.GraphErrors.GraphNodeNotExistingError;
import osl2.messaging.errorHandling.UserError;

/**
 * Represent an undirected graph
 */
public class VUndirectedGraph extends VGraph{
    public VUndirectedGraph(String name) {
        super(name);
    }

    @Override
    public boolean addEdge(VGraphNode start, VGraphNode end) {
        start.connect(end);
        end.connect(start);
        return true;
    }
}
