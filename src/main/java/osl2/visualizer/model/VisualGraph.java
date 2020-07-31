package osl2.visualizer.model;

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
        getBroadcaster().send((b) -> b.setSize(size));
	}

	@Override
	public boolean addNode(VNode node) {
		if (nodeSet.containsKey(node)) {
			throw new InvalidParameterException("The node already exists in the graph.");
		}

		nodeSet.put((T) node.getValue(), new LinkedList<T>());
        getBroadcaster().send((b) -> b.addNode(node));
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
        getBroadcaster().send((b) -> b.addEdge(start, end));
		return true;
	}

	@Override
	public boolean removeNode(VNode node) {
		if (!nodeSet.containsKey(node)) {
			throw new InvalidParameterException("The node does not exist in the graph.");
		}

		nodeSet.remove(node);
		size--;
        getBroadcaster().send((b) -> b.removeNode(node));
		return true;
	}

	@Override
	public boolean removeEdge(VNode start, VNode end) {
		if (nodeSet.containsKey(start)) {
			if (nodeSet.get(start).contains(end)) {
				nodeSet.get(start).remove(end);
                getBroadcaster().send((b) -> b.removeEdge(start, end));
				return true;
			}
		}
		return false;
	}

	public Collection<VEdge> getEdges(VNode node) {
		Collection<VEdge> edges = new ArrayList<VEdge>();

		for (T end : nodeSet.get(node.getValue())) {
			VEdge edge = new VEdge(node, new VNode(end));
			edges.add(edge);
		}

		return edges;
	}

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
			for (Object node : nodes) {
				if (!containsNode((VNode) node))
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

    @Override
	public boolean removeAll() {
		nodeSet = new HashMap<>();
		return true;
	}
}
