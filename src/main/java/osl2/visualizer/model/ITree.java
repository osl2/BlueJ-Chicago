import java.util.Collection;

public interface ITree {
	boolean addChild(VNode child, VNode parent);

	boolean removeLeave(VNode node);

	Collection<VNode> getChilds(VNode parent);

	VNode getParent(VNode child);

	int getHeight();

	boolean swap(VNode child, VNode parent);

	// public boolean addTree(VNode parent, ITree<VNode> child);
	boolean contains(VNode node);

	boolean contains(Collection<VNode> nodes);

	int size();

	boolean removeAll();

	boolean isEmpty();
}
