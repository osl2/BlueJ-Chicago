import osl2.Chicago.IDatastructure;
import osl2.Chicago.IGraph;
import osl2.Chicago.VNode;

import java.security.InvalidParameterException;
import java.util.*;

public class VisualGraph<T> implements IGraph, IDatastructure {
	private VisualGraph fassadeGraph;
	private VisualGraph currentGraph;

	private Map<T, List<T>> nodeSet;

	private int size;

	public VisualGraph() {
		nodeSet = new HashMap<>();
		// TODO init global variables
	}

	@Override
	public boolean addNode(VNode node) {
		if (nodeSet.containsKey(node)) {
			throw new InvalidParameterException("The node already exists in the graph.");
		}

		nodeSet.put((T) node.getValue(), new LinkedList<T>()); // that is not so elegant
		size++;
		return true;
	}

	@Override
	public boolean addEdge(VNode start, VNode end) {
		if (!nodeSet.containsKey(start))
			addNode(start);

		if (!nodeSet.containsKey(end))
			addNode(end);

		nodeSet.get(start).add((T) end.getValue());
		return true;
	}

	@Override
	public boolean removeNode(VNode node) {
		if (!nodeSet.containsKey(node)) {
			throw new InvalidParameterException("The node does not exist in the graph.");
		}

		nodeSet.remove(node);
		size--;
		return true;
	}

	@Override
	public boolean removeEdge(VNode start, VNode end) {
		if (nodeSet.containsKey(start)) {
			if (nodeSet.get(start).contains(end)) {
				nodeSet.get(start).remove(end);
				return true;
			}
		}
		return false;
	}

	// TODO Fix
//	@Override
//	public Collection<VEdge> getEdges(VNode node) {
//		Collection<VEdge> edges = new ArrayList<VEdge>();
//
//		for (T end : nodeSet.get(node.getValue())) {
//			VEdge edge = new VEdge(node, new VNode(end));
//			edges.add(edge);
//		}
//
//		return edges;
//	}

	@Override
	public Collection<VNode> getAdjacents(VNode node) {
		return (Collection<VNode>) nodeSet.get(node.getValue());
	}

	@Override
	public Collection<VNode> getNodes() {
		return (Collection<VNode>) nodeSet.keySet();
	}

	@Override
	public boolean containsNode(VNode node) {
		return nodeSet.containsKey(node.getValue());
	}

	@Override
	public boolean containsNodes(Collection nodes) {
			for (VNode node : nodes) {
				if (!containsNode(node))
					return false;
			}
			return true;
	}

	@Override
	public boolean containsEdge(VNode start, VNode end) {
		return nodeSet.get(start).contains(end);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	// TODO add this to the other IGraph interface!
	public boolean removeAll() {
		nodeSet = new HashMap<>();
		return true;
	}
}
