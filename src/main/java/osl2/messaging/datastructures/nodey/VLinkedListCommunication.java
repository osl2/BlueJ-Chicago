package osl2.messaging.datastructures.nodey;

/**
 * The communication used by {@link osl2.datastructures.nodey.VLinkedList}.
 *
 * @param <T>
 *         the type used
 */
public interface VLinkedListCommunication<T>
        extends VNodeyDatastructureCommunication<T, VLinkedListNodeCommunication<T>> {
}
