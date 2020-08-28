package osl2.messaging.datastructures;

import osl2.messaging.datastructures.nodey.VNodeyDatastructureCommunication;

/**
 * The interface for the communication between tree nodes.
 *
 * @param <T>
 *         The datatype of the content of the node.
 */
public interface VTreeCommunication<T> extends VNodeyDatastructureCommunication<T, VGraphNodeCommunication<T>> {

}
