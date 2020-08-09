package osl2.datastructures.nodey;

import osl2.messaging.datastructures.nodey.VLinkedListCommunication;
import osl2.messaging.datastructures.nodey.VLinkedListNodeCommunication;
import osl2.messaging.errorHandling.ArrayErrors.ArrayIndexOutOfBoundsError;
import osl2.messaging.errorHandling.ListErrors.ListIndexOutOfBoundsError;
import osl2.messaging.errorHandling.UserError;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.datastructures.GUILinkedList;

import java.util.*;

/**
 * an abstract class to represent an linked list
 * @param <T> the type of the linked list
 * @param <Comm> the communication type of the linked list
 */
public abstract class VLinkedList<T, Comm extends VLinkedListCommunication<T>> extends NodeyDatastructure<T, Comm, VLinkedListNodeCommunication<T>, VLinkedListNode<T>> implements List<T> {
    private final VLinkedListNode<Object> head;

    /**
     * constructor for the linked list. Creates the head node.
     */
    public VLinkedList() {
        head = (VLinkedListNode<Object>) createNode();
        head.setValue("<HEAD>");
    }

    @Override
    protected VLinkedListNode<T> createNode() {
        return new VLinkedListNode(this);
    }

    @Override
    public DatastructureVisualization createVisualization() {
        return new GUILinkedList();
    }


    protected void outOfBoundsError(int index) {
        UserError userError = new ListIndexOutOfBoundsError(index, this.size() - 1);
        getBroadcaster().send((b) -> b.handleError(userError));
    }

    protected VLinkedListNode<T> getHead() { return (VLinkedListNode<T>) head.getForward(); }

    protected void setHead(VLinkedListNode<T> newHead) {
        this.head.setForward((VLinkedListNode<Object>) newHead);
    }

    protected VLinkedListNode<T> getLast() {
        VLinkedListNode<T> node = getHead();
        VLinkedListNode<T> last = node;
        while (node != null) {
            last = node;
            node = node.getForward();
        }
        return last;
    }

    protected VLinkedListNode<T> getNode(int i) {
        VLinkedListNode<T> it = getHead();
        while (i-- > 0) {
            if (it == null) {
                outOfBoundsError(i);
                return null;
            }
            it = it.getForward();
        }

        return it;
    }

    protected abstract void disconnectAndRemove(VLinkedListNode<T> node);


    @Override
    public int size() {
        int size = 0;
        VLinkedListNode<T> node = getHead();
        while (node != null) {
            node = node.getForward();
            size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return getHead() == null;
    }

    @Override
    public boolean contains(Object o) {
        VLinkedListNode<T> node = getHead();

        while (node != null) {
            if (node.getValue() == null ? o == null : node.getValue().equals(o)) return true;
            node = node.getForward();
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;    // TODO
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;    // TODO
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        return null;    // TODO
    }

    @Override
    public Object[] toArray() {
        Object[] data = new Object[size()];
        int pos = 0;
        VLinkedListNode<T> node = getHead();
        while (node != null) {
            data[pos++] = node.getValue();
            node = node.getForward();
        }
        return data;
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return null;    // TODO
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object o : collection) {
            if (!contains(o)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        for (T value : collection) {
            add(value);
        }
        return !collection.isEmpty();
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {
        for (T value : collection) {
            add(i++, value);
        }
        return !collection.isEmpty();
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean hasChanged = false;
        for (Object o : collection) {
            hasChanged |= contains(o);
            remove(o);
        }
        return hasChanged;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        // TODO
        return false;
    }

    @Override
    public void clear() {
        VLinkedListNode<T> node = getHead();
        setHead(null);
        while (node != null) {
            VLinkedListNode<T> next = node.getForward();
            disconnectAndRemove(node);
            node = next;
        }
    }

    @Override
    public T get(int i) {
        VLinkedListNode<T> node = getNode(i);
        if (node == null) {
            outOfBoundsError(i);
            return null;
        } else {
            return node.getValue();
        }
    }

    @Override
    public T set(int i, T t) {
        VLinkedListNode<T> it = getNode(i);
        if (it == null) {
            outOfBoundsError(i);
            return null;
        } else {
            T old = it.getValue();
            it.setValue(t);
            return old;
        }
    }

    @Override
    public T remove(int i) {
        VLinkedListNode<T> it = getNode(i);
        if (it == null) {
            outOfBoundsError(i);
            return null;
        } else {
            disconnectAndRemove(it);
            return it.getValue();
        }
    }

    @Override
    public int indexOf(Object o) {
        int pos = 0;
        VLinkedListNode<T> it = getHead();
        while (it != null) {
            if (it.getValue() == o) return pos;
            it = it.getForward();
            pos++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int pos = 0;
        int last = -1;
        VLinkedListNode<T> it = getHead();
        while (it != null) {
            if (it.getValue() == o) last = pos;
            it = it.getForward();
            pos++;
        }
        return last;
    }

    @Override
    public List<T> subList(int i, int i1) {
        // TODO: According to the standard, changes in the sublist have to be mapped to this list, too
        List<T> lst = new ArrayList<>();
        int pos = 0;
        VLinkedListNode<T> it = getHead();
        while (it != null && pos < i1) {
            if (pos >= i) lst.add(it.getValue());
            it = it.getForward();
            pos++;
        }
        return lst;
    }
}
