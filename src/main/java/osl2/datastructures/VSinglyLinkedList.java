package osl2.datastructures;

import osl2.datastructures.nodey.VLinkedList;
import osl2.datastructures.nodey.VLinkedListNode;
import osl2.messaging.datastructures.nodey.VLinkedListCommunication;
import osl2.messaging.error_handling.UserError;
import osl2.messaging.error_handling.list_errors.ListIndexOutOfBoundsError;

/**
 * Represent a singly linked list.
 *
 * @param <T>
 *         the type of data used in the singly linked list
 */
public class VSinglyLinkedList<T> extends VLinkedList<T, VLinkedListCommunication<T>> {

    /**
     * Creates a new {@link VSinglyLinkedList}.
     */
    public VSinglyLinkedList() {
    }

    /**
     * Creates a new {@link VSinglyLinkedList} with a specified name.
     *
     * @param name
     *         the name of the list to be created
     */
    public VSinglyLinkedList(String name) {
        super.setName(name);
    }

    @Override
    public String getDatastructureType() {
        return "Singly Linked List";
    }

    @Override
    protected void disconnectAndRemove(VLinkedListNode<T> node) {
        if (node != null) {
            if (node == getHead()) {
                setHead(node.getForward());
            } else {
                VLinkedListNode<T> it = getHead();
                while (it != null) {
                    if (it.getForward() == node) {
                        it.setForward(node.getForward());
                        break;
                    }
                    it = it.getForward();
                }
            }
            removeNode(node);
        }
    }

    @Override
    public boolean add(T t) {
        VLinkedListNode<T> newNode = createNode();
        newNode.setValue(t);

        VLinkedListNode<T> last = getLast();
        if (last == null) {
            setHead(newNode);
        } else {
            last.setForward(newNode);
        }
        return true;
    }

    @Override
    public void add(int i, T t) {
        if (i < 0 || i > size()) {
            UserError userError = new ListIndexOutOfBoundsError(i, size());
            getBroadcaster().sendWithPauseBlock(b -> b.handleError(userError));
            return;
        }

        VLinkedListNode<T> node = createNode();
        node.setValue(t);

        if (i == 0) {
            if (getHead() != null) {
                node.setForward(getHead());
            }
            setHead(node);
        } else {
            VLinkedListNode<T> it = getHead();
            while (i-- > 1) {
                if (it == null) {
                    outOfBoundsError(i);
                    return;
                }
                it = it.getForward();
            }
            node.setForward(it.getForward());
            it.setForward(node);
        }
    }
}
