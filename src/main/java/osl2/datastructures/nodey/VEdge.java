package osl2.datastructures.nodey;

import osl2.messaging.datastructures.nodey.VNodeCommunication;

/**
 * Represents an Edge.
 */
public class VEdge<S, E> {
    private final VNode<VNodeCommunication<S>, S> start;
    private final VNode<VNodeCommunication<E>, E> end;

    /**
     * Creates a new {@link VEdge}.
     *
     * @param start
     *         the start node of the edge
     * @param end
     *         the end node of the edge
     */
    public VEdge(VNode<VNodeCommunication<S>, S> start, VNode<VNodeCommunication<E>, E> end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Creates a new {@link VEdge}.
     *
     * @param start
     *         the start node of the edge
     * @param end
     *         the end node of the edge
     */
    public VEdge(VGraphNode<S> start, VGraphNode<E> end) {
        this.start = (VNode) start;
        this.end = (VNode) end;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        final VEdge other = (VEdge) obj;

        return start.equals(other.start) && end.equals(other.end);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (start == null ? 0 : start.hashCode());
        hash = 31 * hash + (end == null ? 0 : end.hashCode());
        return hash;
    }

    /**
     * Gets the start node.
     *
     * @return the start node
     */
    public VNode<VNodeCommunication<S>, S> getStart() {
        return start;
    }

    /**
     * Gets the end node.
     *
     * @return the end node
     */
    public VNode<VNodeCommunication<E>, E> getEnd() {
        return end;
    }
}
