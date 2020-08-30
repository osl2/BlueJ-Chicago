package osl2.view.ui.draggable;

import javafx.scene.layout.Pane;

/**
 * The Floormat is a place which contains Draggables.
 */
public class Floormat extends Pane {

    /**
     * Creates a new Floormat.
     */
    public Floormat() {
        super();
    }

    /**
     * Adds a new draggable to the floormat.
     *
     * @param draggable
     *         The draggable which will be added.
     */
    public void addDraggable(Draggable draggable) {
        getChildren().add(draggable);
    }

    /**
     * Removes a new draggable to the floormat.
     *
     * @param draggable
     *         The draggable which will be removed.
     */
    public void removeDraggable(Draggable draggable) {
        getChildren().remove(draggable);
    }
}
