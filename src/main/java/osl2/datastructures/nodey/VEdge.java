package osl2.datastructures.nodey;

public class VEdge {
    private VNode start;
    private VNode end;

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

        if(start.equals(other.start) && end.equals(other.end))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + (start == null ? 0 : start.hashCode());
        hash = 31 * hash + (end == null ? 0 : end.hashCode());
        return hash;
    }
}
