package osl2.messaging.datastructures.nodey;

import osl2.messaging.datastructures.DatastructureCommunication;
import osl2.view.datastructures.nodey.GUINode;

public interface VNodeCommunication<T> extends DatastructureCommunication {
    GUINode asGUINode();

    void valueChange(T newValue);
}
