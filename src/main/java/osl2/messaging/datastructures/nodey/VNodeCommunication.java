package osl2.messaging.datastructures.nodey;

import osl2.view.datastructures.nodey.GUINode;

public interface VNodeCommunication<T> {
    GUINode asGUINode();
    void valueChange(T newValue);
}
