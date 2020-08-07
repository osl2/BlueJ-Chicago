package osl2.messaging.datastructures;

import osl2.messaging.datastructures.nodey.VNodeCommunication;

/**
 * The interface for the communication between graphnodes.
 *
 * @param <T> The datatype of the content of the node.
 */
public interface VGraphNodeCommunication<T> extends VNodeCommunication<T> {
    /**
     * Connects the node to a new node.
     *
     * @param node The node to which this node will be connected.
     */
    void connect(VGraphNodeCommunication<T> node);

    /**
     * Removes the connection to a node.
     *
     * @param node The node to which the connection should be removed.
     */
    void disconnect(VGraphNodeCommunication<T> node);

    /**
     * Removes all conections.
     */
    void disconnectAll();
}
