package osl2.view.datastructures.nodey;

import javafx.scene.layout.VBox;
import osl2.messaging.datastructures.VGraphNodeCommunication;
import osl2.messaging.errorHandling.UserError;
import osl2.view.inlinerepresentation.InlineRepresentation;

public class GUIGraphNode<T> extends GUINode<T, RoundedNodeContainer<VBox>> implements VGraphNodeCommunication<T> {

    public GUIGraphNode() {
        super(new RoundedNodeContainer<>(new VBox()));
        getContent().setStyle("-fx-background-color: red");
        getContent().getContents().getChildren().add(InlineRepresentation.get(null));
    }

    @Override
    public void valueChange(T newValue) {
        getContent().getContents().getChildren().set(0, InlineRepresentation.get(newValue));
    }

    @Override
    public void connect(VGraphNodeCommunication<T> node) {
        // TODO: Make arrow to node.asGUINode()
        getChildren().add(new Arrow(this, node.asGUINode(), null));    // TODO: Store all arrows
    }

    @Override
    public void disconnect(VGraphNodeCommunication<T> node) {
        // TODO: Remove arrow to node.asGUINode()
    }

    @Override
    public void disconnectAll() {
        // TODO
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
