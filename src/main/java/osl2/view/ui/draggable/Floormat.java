package osl2.view.ui.draggable;

import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

public class Floormat extends ScrollPane {

    public Floormat() {
    }


    public void addDraggable(Draggable draggable) {
        getChildren().add(draggable);
    }

    public void removeDraggable(Draggable draggable) {
        getChildren().remove(draggable);
    }

    public void raise(Draggable draggable) {
        draggable.toFront();
    }
}
