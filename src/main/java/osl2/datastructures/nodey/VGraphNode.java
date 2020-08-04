package osl2.datastructures.nodey;

import osl2.messaging.datastructures.VGraphNodeCommunication;
import osl2.view.datastructures.nodey.GUIGraphNode;

public class VGraphNode<T> extends VNode<VGraphNodeCommunication<T>, T> {
    public VGraphNode(NodeyDatastructure parentDS) {
        super(parentDS);
    }

    @Override
    protected VGraphNodeCommunication<T> createVisualization() {
        return new GUIGraphNode<T>();
    }
}
