package osl2.messaging.datastructures.nodey;

public interface VLinkedListNodeCommunication<T> extends VNodeCommunication<T> {
    void setForward(VLinkedListNodeCommunication<T> node);

    void setBackward(VLinkedListNodeCommunication<T> node);
}
