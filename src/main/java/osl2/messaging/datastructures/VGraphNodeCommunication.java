package osl2.messaging.datastructures;

import osl2.messaging.datastructures.nodey.VNodeCommunication;

public interface VGraphNodeCommunication<T> extends VNodeCommunication<T> {
    void connect(VGraphNodeCommunication<T> node);
    void disconnect(VGraphNodeCommunication<T> node);
    void disconnectAll();
}
