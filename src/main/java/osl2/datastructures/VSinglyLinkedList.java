package osl2.datastructures;

import osl2.datastructures.nodey.VLinkedList;
import osl2.datastructures.nodey.VLinkedListNode;
import osl2.messaging.datastructures.nodey.VLinkedListCommunication;

/**
 * Represent singly linked list
 *
 * @param <T>
 *         the type of the singly linked list
 */
public class VSinglyLinkedList<T> extends VLinkedList<T, VLinkedListCommunication<T>> {

  public VSinglyLinkedList() {
  }

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
      // TODO raise exception
      throw new IndexOutOfBoundsException();
    }

    VLinkedListNode<T> node = createNode();
    node.setValue(t);

    if (i == 0) {
      if (getHead() != null) node.setForward(getHead());
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
