import java.util.Collection;

public interface IGraph {
    public boolean addNode(VNode node);
    public boolean addEdge(VNode start, VNode end);
    public boolean removeNode(VNode node);
    public boolean removeEdge(VNode start, VNode end);
    public Collection<VEdge> getEdges(VNode node);
    public Collection<VNode> getAdjacents(VNode node);
    public Collection<VNode> getNodes();
    public boolean containsNode(VNode node);
    public boolean containsNodes(Collection<VNode> nodes);
    public boolean containsEdge(VNode start, VNode end);
    // public boolean containsEdges(Collection<VNode, VNode> edges); TODO use VEdge instead?
    public int size();
    public boolean isEmpty();
    public boolean removeAll();

}
