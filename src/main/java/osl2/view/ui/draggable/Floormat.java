package osl2.view.ui.draggable;

import javafx.scene.layout.Pane;

public class Floormat extends Pane {

    public Floormat() {
    }

    public void addDraggable(Draggable draggable) {
        getChildren().add(draggable);
    }

    public void removeDraggable(Draggable draggable) {
        getChildren().remove(draggable);
    }

    public void raise(Draggable draggable) {
        if (getChildren().contains(draggable)) {
            removeDraggable(draggable);
        }
        addDraggable(draggable);
    }
}
