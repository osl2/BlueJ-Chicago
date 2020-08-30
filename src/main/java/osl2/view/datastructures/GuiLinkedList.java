package osl2.view.datastructures;

import osl2.messaging.datastructures.nodey.VLinkedListCommunication;
import osl2.messaging.datastructures.nodey.VLinkedListNodeCommunication;
import osl2.view.datastructures.nodey.GUINodeyDatastructure;

/**
 * The visualisation of a linked list.
 *
 * @param <T>
 *     the datatype of the datastructure
 */
public class GuiLinkedList<T> extends GUINodeyDatastructure<T, VLinkedListNodeCommunication<T>>
        implements VLinkedListCommunication<T> {
}
