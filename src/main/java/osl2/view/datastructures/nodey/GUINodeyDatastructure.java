package osl2.view.datastructures.nodey;

import osl2.messaging.datastructures.nodey.VNodeCommunication;
import osl2.messaging.datastructures.nodey.VNodeyDatastructureCommunication;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.ui.draggable.Floormat;

/**
 * The visualisation class for a nodey datastructure like graph, tree or lists.
 * @param <T> The datatype of the nodey datastructure.
 * @param <CommType> The communicationinterface.
 */
public abstract class GUINodeyDatastructure<T, CommType extends VNodeCommunication<T>> extends DatastructureVisualization<Floormat> implements VNodeyDatastructureCommunication<T, CommType> {

    /**
     * Creates a new visualisation of a GuiNodeyDatastructure.
     */
    public GUINodeyDatastructure() {
        super(new Floormat());
        getContents().setMinWidth(250);
        getContents().setMinHeight(250);
    }

    @Override
    public void addGUINode(CommType node) {
        getContents().addDraggable(node.asGUINode());
        node.asGUINode().setLayoutX((int) (Math.random() * getContents().getMinWidth()));
        node.asGUINode().setLayoutY((int) (Math.random() * getContents().getMinHeight()));
    }

    @Override
    public void removeGUINode(CommType node) {
        getContents().removeDraggable(node.asGUINode());
    }
}
