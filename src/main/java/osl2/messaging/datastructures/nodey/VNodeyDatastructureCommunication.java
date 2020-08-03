package osl2.messaging.datastructures.nodey;

public interface VNodeyDatastructureCommunication<T, CommType extends VNodeCommunication<T>> {
    void addGUINode(CommType node);
    void removeGUINode(CommType node);
}
