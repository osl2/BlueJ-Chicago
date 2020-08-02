package osl2.view.datastructures;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import osl2.view.ui.draggable.Draggable;
import osl2.view.ui.draggable.Floormat;

public class GUINode extends Draggable {

    public GUINode(Floormat floormat) {
        super(floormat);
        getChildren().add(new Circle(25, Color.RED));   // TODO: More sophisticated contents ^^
    }
}