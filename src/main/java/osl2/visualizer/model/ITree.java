import java.util.Collection;

public interface ITree {
    public boolean addChild(VNode child, VNode parent);
    public boolean removeLeave(VNode node);
    public Collection<VNode> getChilds(VNode parent);
    public VNode getParent(VNode child);
    public int getHeight();
    public boolean swap(VNode child, VNode parent);
    // public boolean addTree(VNode parent, ITree<VNode> child);
    public boolean contains(VNode node);
    public boolean contains(Collection<VNode> nodes);
    public int size();
    public boolean removeAll();
    public boolean isEmpty();
}
