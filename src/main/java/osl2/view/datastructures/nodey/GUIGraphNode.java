package osl2.view.datastructures.nodey;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import osl2.messaging.datastructures.VGraphNodeCommunication;
import osl2.messaging.errorHandling.UserError;

public class GUIGraphNode<T> extends GUINode<T, Circle> implements VGraphNodeCommunication<T> {

    public GUIGraphNode() {
        super(new Circle(25, Color.RED));
        // TODO: getContent().getChildren().add(InlineRepresentation.get(null));
    }

    @Override
    public void valueChange(T newValue) {
        // TODO: getContent().getChildren().set(0, InlineRepresentation.get(newValue));
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
