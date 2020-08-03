package osl2.view.datastructures.nodey;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import osl2.messaging.datastructures.nodey.VNodeCommunication;
import osl2.view.ui.draggable.Draggable;
import osl2.view.ui.draggable.Floormat;

public abstract class GUINode extends Draggable implements VNodeCommunication {

    @Override
    public GUINode asGUINode() {
        return this;
    }

    public GUINode(Floormat floormat) {
        super(floormat);
        getChildren().add(new Circle(25, Color.RED));   // TODO: More sophisticated contents ^^
    }
}
