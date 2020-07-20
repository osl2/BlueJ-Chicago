import java.util.Collection;

public interface ITree {
	boolean addChild(VisualNode child, VisualNode parent);

	boolean removeLeave(VisualNode node);

	Collection<VisualNode> getChilds(VisualNode parent);

	VisualNode getParent(VisualNode child);

	int getHeight();

	boolean swap(VisualNode child, VisualNode parent);

	// public boolean addTree(VNode parent, ITree<VNode> child);
	boolean contains(VisualNode node);

	boolean contains(Collection<VisualNode> nodes);

	int size();

	boolean removeAll();

	boolean isEmpty();
}
