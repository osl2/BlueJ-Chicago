import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class VTree implements ITree {

	private Map<VNode, LinkedList> map;

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
		for (VNode node : map.keySet()) {
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
	public boolean swap(VNode child, VNode parent) {
		return false;
	}

	@Override
	public boolean contains(VNode node) {
		return map.containsKey(node);
	}

	@Override
	public boolean contains(Collection<VNode> nodes) {
		for (VNode node : nodes) {
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
		map = new HashMap<VNode, LinkedList>();
		return true;
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}
import java.util .*

	public class VTree implements ITree {

		private Map<VNode, LinkedList> map;

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
			for (VNode node : map.keySet()) {
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
		public boolean swap(VNode child, VNode parent) {
			return false;
		}

		@Override
		public boolean contains(VNode node) {
			return map.containsKey(node);
		}

		@Override
		public boolean contains(Collection<VNode> nodes) {
			for (VNode node : nodes) {
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
			map = new HashMap<VNode, LinkedList>();
			return true;
		}

		@Override
		public boolean isEmpty() {
			return map.isEmpty();
		}
	}
}
