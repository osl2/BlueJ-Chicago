package osl2.Chicago;

import java.util.Collection;

/**
 * Is the interface for a graph object.
 *
 * @param <T> the type of objects which can be added as nodes to the graph.
 */
public interface IGraph<T> {
	/**
	 * Adds a node to the graph.
	 *
	 * @param node the node
	 * @return boolean true if the node was added successfully, else false
	 */
	boolean addNode(VNode<T> node);

	/**
	 * Adds an edge to the graph.
	 *
	 * @param start the node at which the edge starts
	 * @param end   the node at which the edge starts
	 * @return boolean true if the edge was added successfully, else false
	 */
	boolean addEdge(VNode<T> start, VNode<T> end);

	/**
	 * Removes a node from the graph.
	 *
	 * @param node the node
	 * @return boolean true if the node was removed successfully, else false
	 */
	boolean removeNode(VNode<T> node);

	/**
	 * Removes an node from the graph.
	 *
	 * @param start the node at which the edge starts
	 * @param end   the node at which the edge starts
	 * @return boolean true if the edge was removed successfully, else false
	 */
	boolean removeEdge(VNode<T> start, VNode<T> end);

	/**
	 * Returns all the edges which go from a node.
	 *
	 * @param node the node to which the edges want to be known
	 * @return Collection<VNode, VNode> the collection of the Edges.
	 */
	// TODO Fix
	// Collection<VNode<T>, VNode<T>> getEdges(VNode<T> node);

	/**
	 * Returns all the adjacents to a node.
	 *
	 * @param node the node to which the adjacents want to be known
	 * @return Collection<VNode> the collction of nodes which are the adjacents
	 */
	Collection<VNode<T>> getAdjacents(VNode<T> node);

	/**
	 * Returns all the nodes in a graph.
	 *
	 * @return Collection<VNode> all the nodes as a collection
	 */
	Collection<VNode<T>> getNodes();

	/**
	 * Indicates if an node is in the graph.
	 *
	 * @param node the node wich wants to be tested
	 * @return boolean true if the node is in the graph, else false
	 */
	boolean containsNode(VNode<T> node);

	/**
	 * Indicates if a collection of nodes is in the graph.
	 *
	 * @param nodes the collection of nodes which wants to be tested
	 * @return boolean true if the nodes are in the graph, else false
	 */
	boolean containsNodes(Collection<VNode<T>> nodes);

	/**
	 * Indicates if an edge is in the graph.
	 *
	 * @param start the node at which the edge starts
	 * @param end   the node at which the edge ends
	 * @return boolean true if the edge is in the graph, else false
	 */
	boolean containsEdge(VNode<T> start, VNode<T> end);

	/**
	 * Indicates if an collection of edges is in the graph.
	 *
	 * @param edges the collection of edges
	 * @return boolean true if the edges are in the graph, else false
	 */
	// TODO Fix
//	boolean containsEdges(Collection<VNode<T>, VNode<T>> edges);

	/**
	 * Returns the amount of nodes in the graph, which is the size of the graph.
	 *
	 * @return int the size of the graph
	 */
	int size();

	/**
	 * Indicates if there are no nodes in the graph.
	 *
	 * @return boolean true if there are no nodes, else false
	 */
	boolean isEmpty();
}
