package osl2.datastructures;

import osl2.datastructures.interfaces.IDatastructure;
import osl2.datastructures.interfaces.IGraph;
import osl2.datastructures.nodey.NodeyDatastructure;
import osl2.datastructures.nodey.VEdge;
import osl2.datastructures.nodey.VGraphNode;
import osl2.messaging.datastructures.VGraphCommunication;
import osl2.messaging.datastructures.VGraphNodeCommunication;
import osl2.messaging.errorHandling.GraphErrors.GraphNodeExistingError;
import osl2.messaging.errorHandling.GraphErrors.GraphNodeNotExistingError;
import osl2.messaging.errorHandling.GraphErrors.GraphRecursionError;
import osl2.messaging.errorHandling.UserError;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.datastructures.GUIGraph;

import java.security.InvalidParameterException;
import java.util.*;

public class VGraph<T> extends NodeyDatastructure<T, VGraphCommunication<T>, VGraphNodeCommunication<T>, VGraphNode<T>>
    implements IGraph, IDatastructure {
    private List nodeList;

    private int size;

    public VGraph(String name) {
        nodeList = new ArrayList();
        super.setName(name);
    }

    @Override
    protected VGraphNode<T> createNode() {
        return new VGraphNode<T>(this);
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
    public boolean addNode(VGraphNode node) {
        if(node.equals(this)){
            UserError userError = new GraphRecursionError();
            getBroadcaster().send((b) -> b.handleError(userError));
            return false;
        }
        if(nodeList.contains(node)) {
            System.out.println("Test");
            UserError userError = new GraphNodeExistingError<>(node);
            getBroadcaster().send((b) -> b.handleError(userError));
            return false;
        }

        nodeList.add(node);
        size++;
        return true;
    }

    @Override
    public boolean addEdge(VGraphNode start, VGraphNode end) {
        if (!nodeList.contains(start))
            addNode(start);

        if (!nodeList.contains(end))
            addNode(end);

        start.connect(end);
        return true;
    }

    @Override
    public boolean removeNode(VGraphNode node) {
        super.removeNode(node);
        if(!nodeList.contains(node)) {
            UserError userError = new GraphNodeNotExistingError<>(node);
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
        return false;
    }

    @Override
    public Collection<VEdge> getEdges(VGraphNode node) {
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
        nodeList = new ArrayList();
        size = 0;
        return true;
    }
}
