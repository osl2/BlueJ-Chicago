package osl2.view.datastructures.nodey;

import javafx.scene.layout.StackPane;
import osl2.messaging.datastructures.nodey.VNodeCommunication;
import osl2.messaging.datastructures.nodey.VNodeyDatastructureCommunication;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.ui.draggable.Floormat;

/**
 * The visualisation class for a nodey datastructure like graph, tree or lists.
 *
 * @param <T>
 *         The datatype of the nodey datastructure.
 * @param <CommType>
 *         The communicationinterface.
 */
public abstract class GUINodeyDatastructure<T, CommType extends VNodeCommunication<T>> extends DatastructureVisualization<StackPane> implements VNodeyDatastructureCommunication<T, CommType> {
    private final Floormat floormat;
    private final ArrowOverlay arrows;

    /**
     * Creates a new visualisation of a GuiNodeyDatastructure.
     */
    public GUINodeyDatastructure() {
        super(new StackPane());
        floormat = new Floormat();
        arrows = new ArrowOverlay();
        getContents().getChildren().add(floormat);
        getContents().getChildren().add(arrows);
        arrows.toFront();
        floormat.setMinWidth(450);
        floormat.setMinHeight(450);
    }

    @Override
    public void addGUINode(CommType node) {
        node.asGUINode().setArrowOverlay(arrows);
        floormat.addDraggable(node.asGUINode());
        node.asGUINode().setLayoutX((int) (Math.random() * floormat.getMinWidth()));
        node.asGUINode().setLayoutY((int) (Math.random() * floormat.getMinHeight()));
    }

    @Override
    public void removeGUINode(CommType node) {
        floormat.removeDraggable(node.asGUINode());
    }
}