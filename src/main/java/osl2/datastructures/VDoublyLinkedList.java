package osl2.datastructures;

import osl2.datastructures.nodey.VLinkedList;
import osl2.datastructures.nodey.VLinkedListNode;
import osl2.messaging.datastructures.nodey.VLinkedListCommunication;

public class VDoublyLinkedList<T> extends VLinkedList<T, VLinkedListCommunication<T>> {

    public VDoublyLinkedList() {
    }

    public VDoublyLinkedList(String name) {
        super.setName(name);
    }

    @Override
    public String getDatastructureType() {
        return "Singly Linked List";
    }


    @Override
    protected void disconnectAndRemove(VLinkedListNode<T> node) {
        if (node != null) {
            if (node.getBackward() != null) node.getBackward().setForward(node.getForward());
            if (node.getForward() != null) node.getForward().setBackward(node.getBackward());
            if (getHead() == node) setHead(node.getBackward() != null ? node.getBackward() : node.getForward());
            removeNode(node);
        }
    }

    private void link(VLinkedListNode<T> prev, VLinkedListNode<T> node, VLinkedListNode<T> next) {
        node.setBackward(prev);
        node.setForward(next);
        if (prev != null) prev.setForward(node);
        if (next != null) next.setBackward(node);
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
    public boolean remove(Object o) {
        VLinkedListNode<T> it = getHead();
        while (it != null) {
            if (it.getValue() == o) {
                disconnectAndRemove(it);
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(int i, T t) {
        VLinkedListNode<T> node = createNode();
        node.setValue(t);

        VLinkedListNode next = getNode(i);
        if (next == null) {
            if (i == 0) setHead(node);
            else /* TODO: Out of bounds Error */;
        } else {
            link(next.getBackward(), node, next);
        }
    }
}
