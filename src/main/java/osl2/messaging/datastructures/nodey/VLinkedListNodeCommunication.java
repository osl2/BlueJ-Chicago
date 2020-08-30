package osl2.messaging.datastructures.nodey;

/**
 * The communication used by {@link osl2.datastructures.nodey.VLinkedListNode}.
 *
 * @param <T>
 *         the type used
 */
public interface VLinkedListNodeCommunication<T> extends VNodeCommunication<T> {
    /**
     * Sets the next node.
     *
     * @param node
     *         the next node to be set
     */
    void setForward(VLinkedListNodeCommunication<T> node);

    /**
     * Sets the previous node.
     *
     * @param node
     *         the previous node to be set
     */
    void setBackward(VLinkedListNodeCommunication<T> node);
}
