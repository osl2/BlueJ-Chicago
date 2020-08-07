package osl2.datastructures;

import osl2.datastructures.nodey.VLinkedList;
import osl2.messaging.datastructures.nodey.VLinkedListCommunication;

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
}
