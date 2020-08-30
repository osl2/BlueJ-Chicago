package osl2.view.ui.draggable;

import javafx.scene.Group;

/**
 * The draggable class is a object which can be moved.
 */
public class Draggable extends Group {
    private double xoffset;
    private double yoffset;

    /**
     * Creates a new draggable.
     */
    public Draggable() {
        setBehavior();
    }

    /**
     * Returns the floormat for the draggable.
     *
     * @return The floormat.
     */
    private Floormat getFloormat() {
        return (Floormat) getParent();
    }

    /**
     * Raises the draggable.
     */
    public void raise() {
        toFront();
    }

    /**
     * Let's the draggable be removed from its floormat.
     */
    public void disappear() {
        getFloormat().removeDraggable(this);
    }

    /**
     * Returns the XOffset of this draggable.
     *
     * @return The XOffset.
     */
    public double getXOffset() {
        return this.xoffset;
    }

    /**
     * Sets the XOffset of this draggable.
     *
     * @param xoffset
     *         The value which will be the XOffset.
     */
    public void setXOffset(double xoffset) {
        this.xoffset = xoffset;
    }

    /**
     * Returns the YOffset of this draggable.
     *
     * @return The YOffset.
     */
    public double getYOffset() {
        return this.yoffset;
    }

    /**
     * Sets the YOffset of this draggable.
     *
     * @param yoffset
     *         The value which will be the YOffset.
     */
    public void setYOffset(double yoffset) {
        this.yoffset = yoffset;
    }

    /**
     * Sets the behaviour off the draggable, so that it can be moved inside its parent.
     */
    private void setBehavior() {
        setOnMousePressed(event -> {
            event.consume();
            raise();
            xoffset = (getLayoutX() - event.getScreenX());
            yoffset = (getLayoutY() - event.getScreenY());
        });

        setOnMouseDragged(event -> {
            event.consume();
            if (xoffset + event.getScreenX() < 0) {
                setLayoutX(0);
            } else if (xoffset + event.getScreenX() > getFloormat().getWidth()) {
                setLayoutX(getFloormat().getWidth() - 50);
            } else {
                setLayoutX(xoffset + event.getScreenX());
            }

            if (yoffset + event.getScreenY() < 0) {
                setLayoutY(0);

            } else if (yoffset + event.getScreenY() > getFloormat().getHeight()) {
                setLayoutY(getFloormat().getHeight() + event.getScreenY());

            } else {
                setLayoutY(yoffset + event.getScreenY());
            }
        });
    }
}
