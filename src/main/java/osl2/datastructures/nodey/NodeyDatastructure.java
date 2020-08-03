package osl2.datastructures.nodey;

import osl2.datastructures.EvanstonDatastructure;
import osl2.messaging.datastructures.nodey.VNodeCommunication;
import osl2.messaging.datastructures.nodey.VNodeyDatastructureCommunication;

public abstract class NodeyDatastructure<T, CommType extends VNodeCommunication<T>, NodeType extends VNode<CommType, T>> extends EvanstonDatastructure<VNodeyDatastructureCommunication<T, CommType>> {

    abstract NodeType createNode(T value);

    final protected void registerNodeVisualization(CommType comm) {
        getBroadcaster().sendWithDelay(b -> b.addGUINode(comm));
    }

    final protected NodeType addNode(T value) {
        return createNode(value);
    }

    final protected void removeNode(NodeType node) {
        getBroadcaster().sendWithDelay(b -> b.removeGUINode(node.getCommunication()));
    }
}
