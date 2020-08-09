package osl2.datastructures.nodey;

import osl2.datastructures.EvanstonDatastructure;
import osl2.messaging.datastructures.nodey.VNodeCommunication;
import osl2.messaging.datastructures.nodey.VNodeyDatastructureCommunication;


public abstract class NodeyDatastructure<T, NodeyComm extends VNodeyDatastructureCommunication<T, CommType>, CommType extends VNodeCommunication<T>, NodeType extends VNode<CommType, T>> extends EvanstonDatastructure<NodeyComm> {

    /**
     * creates a new Node
     * @return a new node of NodeType
     */
    protected abstract NodeType createNode();

    /**
     * registers the communication
     * @param comm the communication
     */
    final protected void registerNodeVisualization(CommType comm) {
        getBroadcaster().sendWithDelay(b -> b.addGUINode(comm));
    }

    /**
     * creates a new node
     * @return the newly created node
     */
    final public NodeType addNode() {
        return createNode();
    }

    /**
     * removes the node
     * @param node the node to be remoeved
     * @return true if the operation was successful.
     */
    public boolean removeNode(NodeType node) {
        node.disconnectAll();
        getBroadcaster().sendWithDelay(b -> b.removeGUINode(node.getCommunication()));
        return true;
    }
}
