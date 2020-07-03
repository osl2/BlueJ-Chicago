package osl2.Chicago;

public interface IGraph {
    /**
     * Adds a node to the graph.
     * @param node the node
     * @return boolean true if the node was added successfully, else false
     */
    public boolean addNode(VNode node);

    /**
     * Adds an edge to the graph.
     * @param start the node at which the edge starts
     * @param end the node at which the edge starts
     * @return boolean true if the edge was added successfully, else false
     */
    public boolean addEdge(VNode start, VNode end);

    /**
     * Removes a node from the graph.
     * @param node the node
     * @return boolean true if the node was removed successfully, else false
     */
    public boolean removeNode(VNode node);

    /**
     * Removes an node from the graph.
     * @param start the node at which the edge starts
     * @param end the node at which the edge starts
     * @return boolean true if the edge was removed successfully, else false
     */
    public boolean removeEdge(VNode start, VNode end);

    /**
     * Returns all the edges which go from a node.
     * @param node the node to which the edges want to be known
     * @return Collection<VNode, VNode> the collection of the Edges.
     */
    public Collection<VNode, VNode> getEdges(VNode node);

    /**
     * Returns all the adjacents to a node.
     * @param node the node to which the adjacents want to be known
     * @return Collection<VNode> the collction of nodes which are the adjacents
     */
    public Collection<VNode> getAdjacents(VNode node);

    /**
     * Returns all the nodes in a graph.
     * @return Collection<VNode> all the nodes as a collection
     */
    public Collection<VNode> getNodes();

    /**
     * Indicates if an node is in the graph.
     * @param node the node wich wants to be tested
     * @return boolean true if the node is in the graph, else false
     */
    public boolean containsNode(VNode node);

    /**
     * Indicates if a collection of nodes is in the graph.
     * @param nodes the collection of nodes which wants to be tested
     * @return boolean true if the nodes are in the graph, else false
     */
    public boolean containsNodes(Collection<VNode> nodes);

    /**
     * Indicates if an edge is in the graph.
     * @param start the node at which the edge starts
     * @param end the node at which the edge ends
     * @return boolean true if the edge is in the graph, else false
     */
    public boolean containsEdge(VNode start, VNode end);

    /**
     * Indicates if an collection of edges is in the graph.
     * @param edges the collection of edges
     * @return boolean true if the edges are in the graph, else false
     */
    public boolean containsEdges(Collection<VNode, VNode> edges);

    /**
     * Returns the amount of nodes in the graph, which is the size of the graph.
     * @return int the size of the graph
     */
    public int size();

    /**
     * Indicates if there are no nodes in the graph.
     * @return boolean true if there are no nodes, else false
     */
    public boolean isEmpty();
}
