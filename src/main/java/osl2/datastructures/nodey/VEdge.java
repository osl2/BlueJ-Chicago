package osl2.datastructures.nodey;

/**
 * represents an Edge
 */
public class VEdge {
    private final VNode start;
    private final VNode end;

    /**
     * The constructor for the VEdge
     *
     * @param start
     *         the start node of the edge
     * @param end
     *         the end node of the edge
     */
    public VEdge(VNode start, VNode end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!VEdge.class.isAssignableFrom(obj.getClass())) {
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

    public VNode getStart() {
        return start;
    }

    public VNode getEnd() {
        return end;
    }
}
