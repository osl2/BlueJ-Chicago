package osl2.visualizer.model;

import osl2.Chicago.VNode;

import java.util.Collection;

public interface IGraph {
	boolean addNode(VNode node);

	boolean addEdge(VNode start, VNode end);

	boolean removeNode(VNode node);

	boolean removeEdge(VNode start, VNode end);

	// TODO Fix
	//Collection<VEdge> getEdges(VNode node);

	Collection<VNode> getAdjacents(VNode node);

	Collection<VNode> getNodes();

	boolean containsNode(VNode node);

	boolean containsNodes(Collection<VNode> nodes);

	boolean containsEdge(VNode start, VNode end);

	// public boolean containsEdges(Collection<VNode, VNode> edges); TODO use VEdge instead?
	int size();

	boolean isEmpty();

	boolean removeAll();

}
