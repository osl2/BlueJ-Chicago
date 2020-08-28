package osl2.view.datastructures.nodey;

import javafx.scene.layout.Pane;

/**
 * The arrowoverlay, where the arrows will be contained.
 */
public class ArrowOverlay extends Pane {

    /**
     * Creates a new ArrowOverlay.
     */
    public ArrowOverlay() {
        setMouseTransparent(true);
    }

    /**
     * Adds a new arrow.
     * @param arrow The new arrow.
     */
    public void addArrow(Arrow arrow) {
        getChildren().add(arrow);
    }

    /**
     * Removes a arrow from the overlay.
     * @param arrow The arrow.
     */
    public void removeArrow(Arrow arrow) {
        getChildren().remove(arrow);
    }
}
