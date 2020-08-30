package osl2.messaging.datastructures;

import osl2.messaging.datastructures.nodey.VNodeyDatastructureCommunication;

/**
 * The interface for the communication between graphs.
 *
 * @param <T>
 *         the datatype of the elements of the graph
 */
public interface VGraphCommunication<T> extends VNodeyDatastructureCommunication<T, VGraphNodeCommunication<T>> {
}
