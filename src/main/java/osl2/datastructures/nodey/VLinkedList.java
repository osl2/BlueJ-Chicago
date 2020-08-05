package osl2.datastructures.nodey;

import osl2.messaging.datastructures.nodey.VLinkedListCommunication;
import osl2.messaging.datastructures.nodey.VLinkedListNodeCommunication;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.datastructures.GUILinkedList;

public abstract class VLinkedList<T, Comm extends VLinkedListCommunication<T>> extends NodeyDatastructure<T, Comm, VLinkedListNodeCommunication<T>, VLinkedListNode<T>> {

    @Override
    protected VLinkedListNode<T> createNode() {
        return new VLinkedListNode(this);
    }

    @Override
    public DatastructureVisualization createVisualization() {
        return new GUILinkedList();
    }
}
