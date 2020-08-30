package osl2.datastructures.nodey;

import osl2.datastructures.EvanstonDatastructure;
import osl2.messaging.datastructures.nodey.VNodeCommunication;
import osl2.messaging.datastructures.nodey.VNodeyDatastructureCommunication;

/**
 * Represents a datastructure with nodes.
 *
 * @param <T>
 *         the type of values stored in the datastructure
 * @param <C>
 *         the node communication used
 * @param <K>
 *         the communication type
 * @param <N>
 *         the node type
 */
public abstract class NodeyDatastructure<T, C extends VNodeyDatastructureCommunication<T, K>,
        K extends VNodeCommunication<T>, N extends VNode<K, T>> extends EvanstonDatastructure<C> {
    /**
     * Creates a new Node.
     *
     * @return a note with type N
     */
    protected abstract N createNode();

    /**
     * Registers the communication.
     *
     * @param k
     *         the communication
     */
    protected final void registerNodeVisualization(K k) {
        getBroadcaster().sendWithDelay(b -> b.addGuiNode(k));
    }

    /**
     * Creates a new node.
     *
     * @return the newly created node
     */
    public final N addNode() {
        return createNode();
    }

    /**
     * Creates a new node with a value.
     *
     * @param value
     *         the value
     * @return the new node.
     */
    public final N addNode(T value) {
        N node = createNode();
        node.setValue(value);
        return node;
    }

    /**
     * Removes the node.
     *
     * @param node
     *         the node to be removed
     * @return true if the operation was successful
     */
    public boolean removeNode(N node) {
        node.disconnectAll();
        getBroadcaster().sendWithDelay(b -> b.removeGuiNode(node.getCommunication()));
        return true;
    }
}
