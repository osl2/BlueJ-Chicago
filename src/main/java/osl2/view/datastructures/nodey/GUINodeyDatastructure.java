package osl2.view.datastructures.nodey;

import osl2.messaging.datastructures.nodey.VNodeCommunication;
import osl2.messaging.datastructures.nodey.VNodeyDatastructureCommunication;
import osl2.view.ui.draggable.Floormat;

public class GUINodeyDatastructure<T, CommType extends VNodeCommunication<T>> extends Floormat implements VNodeyDatastructureCommunication<T, CommType> {

    @Override
    public void addGUINode(CommType node) {
        addDraggable(node.asGUINode());
    }

    @Override
    public void removeGUINode(CommType node) {
        removeDraggable(node.asGUINode());
    }
}
