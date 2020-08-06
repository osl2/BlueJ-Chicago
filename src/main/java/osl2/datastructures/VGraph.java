package osl2.datastructures;

import osl2.datastructures.nodey.NodeyDatastructure;
import osl2.datastructures.nodey.VGraphNode;
import osl2.messaging.datastructures.VGraphCommunication;
import osl2.messaging.datastructures.VGraphNodeCommunication;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.datastructures.GUIGraph;

public class VGraph<T> extends NodeyDatastructure<T, VGraphCommunication<T>, VGraphNodeCommunication<T>, VGraphNode<T>> {

    public VGraph(){

    }

    public VGraph(String name){
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
}
