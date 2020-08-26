package osl2.view.datastructures.nodey;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import osl2.messaging.datastructures.VGraphNodeCommunication;
import osl2.messaging.errorHandling.UserError;
import osl2.view.inlinerepresentation.InlineRepresentation;

/**
 * The class of a node vor visualisation of graphs.
 *
 * @param <T> The datatype of the value of the node.
 */
public class GUIGraphNode<T> extends GUINode<T, RoundedNodeContainer<StackPane>> implements VGraphNodeCommunication<T> {
    private final VBox vbox;
    private final ArrowPane arrows;

    /**
     * Creates a new GraphNode.
     */
    public GUIGraphNode() {
        super(new RoundedNodeContainer<StackPane>(new StackPane()));

        vbox = new VBox();
        arrows = new ArrowPane();

        getContent().getContents().getChildren().add(arrows);
        getContent().getContents().getChildren().add(vbox);

        getContent().setContentStyle("-fx-background-color: red");
        vbox.getChildren().add(InlineRepresentation.get(null));
    }

    @Override
    public void valueChange(T newValue) {
        vbox.getChildren().set(0, InlineRepresentation.get(newValue));
    }

    @Override
    public void setArrowOverlay(ArrowOverlay overlay) {
        super.setArrowOverlay(overlay);
        arrows.setOverlay(overlay);
    }

    @Override
    public void connect(VGraphNodeCommunication<T> node) {
        if (node == this) getContent().showSelfRefArrow();
        arrows.connect(node.asGUINode());
    }

    @Override
    public void disconnect(VGraphNodeCommunication<T> node) {
        if (node == this) getContent().hideSelfRefArrow();
        arrows.disconnect(node.asGUINode());
    }

    @Override
    public void disconnectAll() {
        arrows.clear();
    }

    @Override
    public void handleError(UserError userError) {
        // TODO / FIXME: Not needed for Nodes
    }

    @Override
    public void setName(String name) {
        // TODO / FIXME: Not needed for Nodes
    }
}
