package osl2.messaging.datastructures.nodey;

import osl2.messaging.datastructures.DatastructureCommunication;

public interface VNodeyDatastructureCommunication<T, CommType extends VNodeCommunication<T>> extends DatastructureCommunication {
    void addGUINode(CommType node);

    void removeGUINode(CommType node);
}
