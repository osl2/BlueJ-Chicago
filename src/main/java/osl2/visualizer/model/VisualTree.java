package osl2.visualizer.model;

import osl2.Chicago.IDatastructure;
import osl2.Chicago.ITree;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class VisualTree implements ITree, IDatastructure {

	private Map<VisualNode, LinkedList> map;

	private int height;

	@Override
	public boolean addChild(VisualNode child, VisualNode parent) {
		map.get(parent).add(child);
		height++;
		return true;
	}

	@Override
	public boolean removeLeave(VisualNode node) {
		map.remove(node);
		height--;
		return true;
	}

	@Override
	public Collection<VisualNode> getChilds(VisualNode parent) {
		return map.get(parent);
	}

	@Override
	public VisualNode getParent(VisualNode child) {
		for (VisualNode node : map.keySet()) {
			if (map.get(node).contains(child)) {
				return node;
			}
		}
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public boolean swap(VisualNode child, VisualNode parent) {
		return false;
	}

	@Override
	public boolean contains(VisualNode node) {
		return map.containsKey(node);
	}

	@Override
	public boolean contains(Collection<VisualNode> nodes) {
		for (VisualNode node : nodes) {
			if (!contains(node))
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
import java.util .*

	public class VTree implements ITree {

		private Map<VisualNode, LinkedList> map;

		private int height;

		@Override
		public boolean addChild(VisualNode child, VisualNode parent) {
			map.get(parent).add(child);
			height++;
			return true;
		}

		@Override
		public boolean removeLeave(VisualNode node) {
			map.remove(node);
			height--;
			return true;
		}

		@Override
		public Collection<VisualNode> getChilds(VisualNode parent) {
			return map.get(parent);
		}

		@Override
		public VisualNode getParent(VisualNode child) {
			for (VisualNode node : map.keySet()) {
				if (map.get(node).contains(child)) {
					return node;
				}
			}
		}

		@Override
		public int getHeight() {
			return height;
		}

		@Override
		public boolean swap(VisualNode child, VisualNode parent) {
			return false;
		}

		@Override
		public boolean contains(VisualNode node) {
			return map.containsKey(node);
		}

		@Override
		public boolean contains(Collection<VisualNode> nodes) {
			for (VisualNode node : nodes) {
				if (!contains(node))
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
}
