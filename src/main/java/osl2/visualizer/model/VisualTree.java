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

	@Override
	public boolean addChild(VNode child, VNode parent) {
		map.get(parent).add(child);
		height++;
		return true;
	}

	@Override
	public boolean removeLeave(VNode node) {
		map.remove(node);
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
		return false;
	}

    @Override
    public boolean addTree(VNode parent, ITree child) {
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
		return 0; // TODO difference to height?
	}

	@Override
	public boolean removeAll() {
		map = new HashMap<VisualNode, LinkedList>();
		return true;
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}
}
