package osl2.datastructures.interfaces;

import java.util.Collection;
import osl2.datastructures.nodey.VEdge;
import osl2.datastructures.nodey.VGraphNode;

/**
 * Is the interface for a graph object.
 *
 * @param <T>
 *         the type of objects which can be added as nodes to the graph.
 */
public interface IGraph<T> {
    /**
     * Adds an edge to the graph.
     *
     * @param start
     *         - the node at which the edge starts
     * @param end
     *         - the node at which the edge starts
     * @return true if the edge was added successfully, else false
     */
    boolean addEdge(VGraphNode<T> start, VGraphNode<T> end);

    /**
     * Removes a node from the graph.
     *
     * @param node
     *         - the node
     * @return true if the node was removed successfully, else false
     */
    boolean removeNode(VGraphNode<T> node);

    /**
     * Removes an node from the graph.
     *
     * @param start
     *         - the node at which the edge starts
     * @param end
     *         - the node at which the edge starts
     * @return true if the edge was removed successfully, else false
     */
    boolean removeEdge(VGraphNode<T> start, VGraphNode<T> end);

    /**
     * Returns all the edges which go from a node.
     *
     * @param node
     *         - the node to which the edges want to be known
     * @return the collection of the Edges
     */
    Collection<VEdge> getEdges(VGraphNode<T> node);

    /**
     * Returns all the adjacent nodes of a node.
     *
     * @param node
     *         - the node of which the adjacent nodes want to be known
     * @return the collection of nodes which are adjacent
     */
    Collection<VGraphNode<T>> getAdjacents(VGraphNode<T> node);

    /**
     * Returns all the nodes in a graph.
     *
     * @return all the nodes
     */
    Collection<VGraphNode<T>> getNodes();

    /**
     * Indicates if a node is in the graph.
     *
     * @param node
     *         - the node which wants to be tested
     * @return true if the node is in the graph, else false
     */
    boolean containsNode(VGraphNode<T> node);

    /**
     * Indicates if a collection of nodes is in the graph.
     *
     * @param nodes
     *         - the collection of nodes which wants to be tested
     * @return true if the nodes are in the graph, else false
     */
    boolean containsNodes(Collection<VGraphNode<T>> nodes);

    /**
     * Indicates if an edge is in the graph.
     *
     * @param start
     *         - the node at which the edge starts
     * @param end
     *         - the node at which the edge ends
     * @return true if the edge is in the graph, else false
     */
    boolean containsEdge(VGraphNode<T> start, VGraphNode<T> end);

    /**
     * Indicates if a collection of edges is in the graph.
     *
     * @param edges
     *         - the collection of edges
     * @return true if the edges are in the graph, else false
     */
    boolean containsEdges(Collection<VEdge> edges);

    /**
     * Returns the amount of nodes in the graph, which is the size of the graph.
     *
     * @return the size of the graph
     */
    int size();

    /**
     * Indicates if there are no nodes in the graph.
     *
     * @return true if there are no nodes, else false
     */
    boolean isEmpty();
}
