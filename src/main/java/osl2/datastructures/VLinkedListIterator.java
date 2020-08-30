package osl2.datastructures;

import java.util.ListIterator;
import osl2.datastructures.nodey.VLinkedList;
import osl2.datastructures.nodey.VLinkedListNode;

public class VLinkedListIterator<T> implements ListIterator<T> {
    private final VLinkedList list;
    private int index = 0;
    private VLinkedListNode<T> node;

    @Override
    public boolean hasNext() {
        return node != null;
    }

    @Override
    public T next() {
        // TODO: Error if there is no next element
        T value = node.getValue();
        node = node.getForward();
        index++;
        return value;
    }

    @Override
    public boolean hasPrevious() {
        return node.getBackward() != null;
    }

    @Override
    public T previous() {
        // TODO: Error if there is no next element
        node = node.getBackward();
        index--;
        return node.getValue();
    }

    @Override
    public int nextIndex() {
        return index;
    }

    @Override
    public int previousIndex() {
        return index - 1;
    }

    @Override
    public void set(T t) {
        node.setValue(t);
    }

    @Override
    public void remove() {
        // TODO: Error
    }

    @Override
    public void add(T t) {
        // TODO: Error
    }

    public VLinkedListIterator(VLinkedList list, VLinkedListNode<T> head) {
        this.list = list;
        this.node = head;
    }
}
