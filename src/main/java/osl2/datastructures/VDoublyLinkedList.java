package osl2.datastructures;

import osl2.datastructures.nodey.VLinkedList;
import osl2.datastructures.nodey.VLinkedListNode;
import osl2.messaging.datastructures.nodey.VLinkedListCommunication;

/**
 * Represents a doubly linked list.
 *
 * @param <T>
 *         the type of data used in the list
 */
public class VDoublyLinkedList<T> extends VLinkedList<T, VLinkedListCommunication<T>> {

    /**
     * Creates a new {@link VDoublyLinkedList}.
     */
    public VDoublyLinkedList() {
    }

    /**
     * Creates a new {@link VDoublyLinkedList} with a specified name.
     *
     * @param name
     *         the name of the list
     */
    public VDoublyLinkedList(String name) {
        super.setName(name);
    }

    @Override
    public String getDatastructureType() {
        return "Doubly Linked List";
    }

    @Override
    protected void disconnectAndRemove(VLinkedListNode<T> node) {
        if (node != null) {
            if (node.getBackward() != null) {
                node.getBackward().setForward(node.getForward());
            }
            if (node.getForward() != null) {
                node.getForward().setBackward(node.getBackward());
            }
            if (getHead() == node) {
                setHead(node.getBackward() != null ? node.getBackward() : node.getForward());
            }
            removeNode(node);
        }
    }

    private void link(VLinkedListNode<T> prev, VLinkedListNode<T> node, VLinkedListNode<T> next) {
        node.setBackward(prev);
        node.setForward(next);
        if (prev != null) {
            prev.setForward(node);
        }
        if (next != null) {
            next.setBackward(node);
        }
    }

    @Override
    public boolean add(T t) {
        VLinkedListNode<T> newNode = createNode();
        newNode.setValue(t);
        if (getHead() == null) {
            setHead(newNode);
        } else {
            VLinkedListNode<T> last = getLast();
            link(last, newNode, null);
        }
        return true;
    }

    @Override
    public void add(int i, T t) {
        VLinkedListNode<T> node = createNode();
        node.setValue(t);

        VLinkedListNode<T> next = getNode(i);
        if (next == null) {
            if (i == 0) {
                setHead(node);
            } else {
                outOfBoundsError(i);
            }
        } else {
            link(next.getBackward(), node, next);
        }
    }
}
