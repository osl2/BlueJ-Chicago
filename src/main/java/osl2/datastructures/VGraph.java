package osl2.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import osl2.datastructures.interfaces.IDatastructure;
import osl2.datastructures.interfaces.IGraph;
import osl2.datastructures.nodey.NodeyDatastructure;
import osl2.datastructures.nodey.VEdge;
import osl2.datastructures.nodey.VGraphNode;
import osl2.messaging.datastructures.VGraphCommunication;
import osl2.messaging.datastructures.VGraphNodeCommunication;
import osl2.messaging.error_handling.UserError;
import osl2.messaging.error_handling.graph_errors.GraphEdgeExistingError;
import osl2.messaging.error_handling.graph_errors.GraphEdgeNotExistingError;
import osl2.messaging.error_handling.graph_errors.GraphNodeNotExistingError;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.datastructures.GuiGraph;

/**
 * Represents a graph.
 *
 * @param <T>
 *         the type of data used in the graph
 */
public abstract class VGraph<T>
        extends NodeyDatastructure<T, VGraphCommunication<T>, VGraphNodeCommunication<T>, VGraphNode<T>>
        implements IGraph<T>, IDatastructure {
    private LinkedList<VGraphNode<T>> nodeList;

    private int size;

    /**
     * Creates a new {@link VGraph}.
     */
    public VGraph() {
        this.init();
    }

    /**
     * Creates a new {@link VGraph} with a name.
     *
     * @param name
     *         the name of the graph
     */
    public VGraph(String name) {
        this.init();
        super.setName(name);
    }

    private void init() {
        nodeList = new LinkedList<>();
        size = 0;
    }

    @Override
    protected VGraphNode<T> createNode() {
        VGraphNode<T> node = new VGraphNode<>(this);
        nodeList.add(node);
        size++;
        return node;
    }

    @Override
    public DatastructureVisualization createVisualization() {
        return new GuiGraph();
    }

    @Override
    public String getDatastructureType() {
        return "Graph";
    }

    @Override
    public boolean addEdge(VGraphNode<T> start, VGraphNode<T> end) {
        if (!(nodeList.contains(start))) {
            UserError userError = new GraphNodeNotExistingError<>(start);
            getBroadcaster().sendWithPauseBlock(b -> b.handleError(userError));
            return false;
        }

        if (!nodeList.contains(end)) {
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
        return true;
    }

    @Override
    public boolean containsEdges(Collection<VEdge<T, T>> edges) {
        for (VEdge<T, T> edge : edges) {
            containsEdge((VGraphNode) edge.getStart(), (VGraphNode) edge.getEnd());
        }
        return true;
    }

    @Override
    public boolean removeNode(VGraphNode<T> node) {
        super.removeNode(node);
        if (!nodeList.contains(node)) {
            UserError userError = new GraphNodeNotExistingError<>(node);
            getBroadcaster().sendWithPauseBlock(b -> b.handleError(userError));
            return false;
        }
        nodeList.remove(node);
        size--;
        return true;
    }

    @Override
    public boolean removeEdge(VGraphNode<T> start, VGraphNode<T> end) {
        if (nodeList.contains(start) && start.contains(end)) {
            start.disconnect(end);
            return true;
        }
        UserError userError = new GraphEdgeNotExistingError<>(start, end);
        getBroadcaster().sendWithPauseBlock(b -> b.handleError(userError));
        return false;
    }

    @Override
    public Collection<VEdge<T, T>> getEdges(VGraphNode<T> node) {
        if (!nodeList.contains(node)) {
            UserError userError = new GraphNodeNotExistingError<>(node);
            getBroadcaster().sendWithPauseBlock(b -> b.handleError(userError));
            return Collections.emptyList();
        }
        Collection<VEdge<T, T>> edges = new ArrayList<>();

        VGraphNode<T>[] adjacents = node.getAdjacents();

        for (VGraphNode<T> neighbour : adjacents) {
            VEdge<T, T> edge = new VEdge<>(node, neighbour);
            edges.add(edge);
        }
        return edges;
    }

    @Override
    public Collection<VGraphNode<T>> getAdjacents(VGraphNode<T> node) {
        if (!nodeList.contains(node)) {
            UserError userError = new GraphNodeNotExistingError<>(node);
            getBroadcaster().sendWithPauseBlock(b -> b.handleError(userError));
            return Collections.emptyList();
        }
        return Arrays.asList(node.getAdjacents());
    }

    @Override
    public Collection<VGraphNode<T>> getNodes() {
        // TODO changes original values too? Violation of encapsulation?
        return nodeList;
    }

    @Override
    public boolean containsNode(VGraphNode<T> node) {
        return nodeList.contains(node);
    }

    @Override
    public boolean containsNodes(Collection<VGraphNode<T>> nodes) {
        for (VGraphNode<T> node : nodes) {
            if (!containsNode(node)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean containsEdge(VGraphNode<T> start, VGraphNode<T> end) {
        if (nodeList.contains(start)) {
            return start.contains(end);
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean removeAll() {
        for (VGraphNode<T> node : nodeList) {
            super.removeNode(node);
        }
        nodeList = new LinkedList<>();
        size = 0;
        return true;
    }
}
