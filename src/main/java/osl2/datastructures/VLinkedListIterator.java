package osl2.datastructures;

import java.util.ListIterator;
import osl2.datastructures.nodey.VLinkedListNode;

public class VLinkedListIterator<T> implements ListIterator<T> {
    private int index = 0;
    private VLinkedListNode<T> node;

    public VLinkedListIterator(VLinkedListNode<T> head) {
        this.node = head;
    }

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
        // An error can occur when there is no next element
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
        // This method is not implemented
    }

    @Override
    public void add(T t) {
        // This method is not implemented
    }
}
