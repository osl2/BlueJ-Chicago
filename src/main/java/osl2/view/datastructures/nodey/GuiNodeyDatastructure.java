package osl2.view.datastructures.nodey;

import java.util.Random;
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
 * @param <C>
 *         The communication interface.
 */
public abstract class GuiNodeyDatastructure<T, C extends VNodeCommunication<T>>
        extends DatastructureVisualization<StackPane> implements VNodeyDatastructureCommunication<T, C> {

    private final Floormat floormat;
    private final ArrowOverlay arrows;
    Random rand = new Random();

    /**
     * Creates a new visualisation of a GuiNodeyDatastructure.
     */
    public GuiNodeyDatastructure() {
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
    public void addGuiNode(C node) {
        node.asGuiNode().setArrowOverlay(arrows);
        floormat.addDraggable(node.asGuiNode());
        node.asGuiNode().setLayoutX(rand.nextInt((int) floormat.getMinWidth()));
        node.asGuiNode().setLayoutY(rand.nextInt((int) floormat.getMinHeight()));
    }

    @Override
    public void removeGuiNode(C node) {
        floormat.removeDraggable(node.asGuiNode());
    }
}