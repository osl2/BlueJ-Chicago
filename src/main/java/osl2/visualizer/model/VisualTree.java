package osl2.visualizer.model;

import osl2.Chicago.IDatastructure;
import osl2.Chicago.ITree;
import osl2.Chicago.VNode;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class VisualTree implements ITree, IDatastructure {

	private Map<VisualNode, LinkedList> map;

	private int height;

	private VisualNode root;

	public VisualTree(VisualNode root) {
		this.root = root;
		map.put(root, new LinkedList());
	}

	public VisualNode getRootNode() {
		return root;
	}

	@Override
	public boolean addChild(VNode child, VNode parent) {
		map.get(parent).add(child);
		getBroadcaster().send((b) -> b.addChild(child, parent));
		height++;
		return true;
	}

	@Override
	public boolean removeLeave(VNode node) {
		map.remove(node);
		getBroadcaster().send((b) -> b.removeLeave(node));
		height--;
		return true;
	}

	@Override
	public Collection<VNode> getChilds(VNode parent) {
		return map.get(parent);
	}

	@Override
	public VNode getParent(VNode child) {
		for (VisualNode node : map.keySet()) {
			if (map.get(node).contains(child)) {
				return new VNode(node.getValue());
			}
		}
		return null; // TODO Evaluate usage of an exception here.
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public boolean swap(VNode child, VNode parent) {
		LinkedList childData = map.get(child);
		LinkedList parentData = map.get(parent);
		parentData.remove(child);
		parentData.add(parent);
		map.put(child, parentData); // TODO add conversion
		map.put(parent, childData);

		getBroadcaster().send((b) -> b.swap(child, parent));
		return false;
	}

    @Override
    public boolean addTree(VNode parent, ITree child) {
		addChild(child.getRootNode(), parent);
		height += child.getHeight();
		getBroadcaster().send((b) -> b.addTree(parent, child));
        return false;
    }

    @Override
	public boolean contains(VNode node) {
        return map.containsKey(node);
    }

    @Override
    public boolean contains(Collection nodes) {
        for (Object node : nodes) {
            if (!contains((VNode) node))
                return false;
        }
        return true;
    }

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public boolean removeAll() {
		map = new HashMap<VisualNode, LinkedList>();
		getBroadcaster().send((b) -> b.removeAll());
		return true;
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}
}
