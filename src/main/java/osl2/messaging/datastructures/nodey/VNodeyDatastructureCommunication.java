package osl2.messaging.datastructures.nodey;

import osl2.messaging.datastructures.DatastructureCommunication;

/**
 * The communication used by {@link osl2.datastructures.nodey.NodeyDatastructure}.
 *
 * @param <T>
 *         the type used
 * @param <C>
 *         the communication type used
 */
public interface VNodeyDatastructureCommunication<T, C extends VNodeCommunication<T>>
        extends DatastructureCommunication {

    /**
     * Adds a node.
     *
     * @param node
     *         the node to be added
     */
    void addGuiNode(C node);

    /**
     * Removes a specified node.
     *
     * @param node
     *         the node to be removed
     */
    void removeGuiNode(C node);
}
