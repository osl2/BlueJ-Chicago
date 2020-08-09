package osl2.datastructures;

import osl2.datastructures.interfaces.IDatastructure;
import osl2.datastructures.interfaces.IGraph;
import osl2.datastructures.nodey.NodeyDatastructure;
import osl2.datastructures.nodey.VEdge;
import osl2.datastructures.nodey.VGraphNode;
import osl2.messaging.datastructures.VGraphCommunication;
import osl2.messaging.datastructures.VGraphNodeCommunication;
import osl2.messaging.errorHandling.GraphErrors.*;
import osl2.messaging.errorHandling.UserError;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.datastructures.GUIGraph;

import java.security.InvalidParameterException;
import java.util.*;

public abstract class VGraph<T> extends NodeyDatastructure<T, VGraphCommunication<T>, VGraphNodeCommunication<T>, VGraphNode<T>>
    implements IGraph, IDatastructure {
    private LinkedList<VGraphNode> nodeList;

    private int size;

    public VGraph(String name) {
        nodeList = new LinkedList<>();
        size = 0;
        super.setName(name);
    }

    @Override
    protected VGraphNode<T> createNode() {
        VGraphNode<T> node = new VGraphNode<T>(this);
        nodeList.add(node);
        return node;
    }

    @Override
    public DatastructureVisualization createVisualization() {
        return new GUIGraph();
    }

    @Override
    public String getDatastructureType() {
        return "Graph";
    }

    @Override
    public boolean addEdge(VGraphNode start, VGraphNode end) {
        if (!(nodeList.contains(start))) {
            UserError userError = new GraphNodeNotExistingError<VGraphNode>(start);
            getBroadcaster().send((b) -> b.handleError(userError));
            return false;
        }

        if (!nodeList.contains(end)) {
            UserError userError = new GraphNodeNotExistingError<VGraphNode>(end);
        getBroadcaster().send((b) -> b.handleError(userError));
        return false;
        }

        if(containsEdge(start, end)){
            UserError userError = new GraphEdgeExistingError<VGraphNode>(start, end);
            getBroadcaster().send((b) -> b.handleError(userError));
            return false;
        }
        start.connect(end);;
        return true;
    }

    @Override
    public boolean removeNode(VGraphNode node) {
        super.removeNode(node);
        if(!nodeList.contains(node)) {
            UserError userError = new GraphNodeNotExistingError<VGraphNode>(node);
            getBroadcaster().send((b) -> b.handleError(userError));
            return false;
        }
        nodeList.remove(node);
        size--;
        return true;
    }

    @Override
    public boolean removeEdge(VGraphNode start, VGraphNode end) {
        if(nodeList.contains(start)) {
            if(start.contains(end)) {
                start.disconnect(end);
                return true;
            }
        }
        UserError userError = new GraphEdgeNotExistingError<VGraphNode>(start, end);
        getBroadcaster().send((b) -> b.handleError(userError));
        return false;
    }

    @Override
    public Collection<VEdge> getEdges(VGraphNode node) {
        if(!nodeList.contains(node)){
            UserError userError = new GraphNodeNotExistingError<VGraphNode>(node);
            getBroadcaster().send((b) -> b.handleError(userError));
            return null;
        }
        Collection<VEdge> edges = new ArrayList<VEdge>();

        VGraphNode[] adjacents = node.getAdjacents();

        for(VGraphNode neighbour: adjacents) {
            VEdge edge = new VEdge(node, neighbour);
            edges.add(edge);
        }
        return edges;
    }

    @Override
    public Collection<VGraphNode> getAdjacents(VGraphNode node) {
        if(!nodeList.contains(node)){
            UserError userError = new GraphNodeNotExistingError<>(node);
            getBroadcaster().send((b) -> b.handleError(userError));
            return null;
        }
        return Arrays.asList(node.getAdjacents());
    }

    @Override
    public Collection<VGraphNode> getNodes() {
        return nodeList; // TODO changes orginal values too? Violation of capsulation?
    }

    @Override
    public boolean containsNode(VGraphNode node) {
        return nodeList.contains(node);
    }

    @Override
    public boolean containsNodes(Collection nodes) {
        for(Object node: nodes) {
            if(!containsNode((VGraphNode) node))
                return false;
        }
        return true;
    }

    @Override
    public boolean containsEdge(VGraphNode start, VGraphNode end) {
        if(nodeList.contains(start)) {
            return start.contains(end);
        }
        return false;
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
        for(VGraphNode node: nodeList){
            super.removeNode(node);
        }
        nodeList = new LinkedList<>();
        size = 0;
        return true;
    }
}
