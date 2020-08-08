package osl2.datastructures.nodey;

import osl2.datastructures.EvanstonDatastructure;
import osl2.messaging.datastructures.nodey.VNodeCommunication;
import osl2.messaging.datastructures.nodey.VNodeyDatastructureCommunication;


public abstract class NodeyDatastructure<T, NodeyComm extends VNodeyDatastructureCommunication<T, CommType>, CommType extends VNodeCommunication<T>, NodeType extends VNode<CommType, T>> extends EvanstonDatastructure<NodeyComm> {

    protected abstract NodeType createNode();

    final protected void registerNodeVisualization(CommType comm) {
        getBroadcaster().sendWithDelay(b -> b.addGUINode(comm));
    }

    final public NodeType addNode() {
        return createNode();
    }

    public boolean removeNode(NodeType node) {
        node.disconnectAll();
        getBroadcaster().sendWithDelay(b -> b.removeGUINode(node.getCommunication()));
        return true;
    }
}
