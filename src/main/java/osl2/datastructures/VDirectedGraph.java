package osl2.datastructures;

/**
 * Represents a directed graph.
 */
public class VDirectedGraph<T> extends VGraph<T> {

    /**
     * Creates a new {@link VDirectedGraph}.
     */
    public VDirectedGraph() {
        super();
    }

    /**
     * Creates a new {@link VDirectedGraph} with a name.
     *
     * @param name
     *         the name of the graph
     */
    public VDirectedGraph(String name) {
        super(name);
    }
}
