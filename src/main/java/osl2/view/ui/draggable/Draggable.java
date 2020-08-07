package osl2.view.ui.draggable;

import javafx.scene.Group;

/**
 * The draggable class is a object which can be moved.
 */
public class Draggable extends Group {
    private double xOffset;
    private double yOffset;


    /**
     * Creates a new draggable.
     */
    public Draggable() {
        //TODO Add Mirror/Draggable to Mirror?
        setBehavior();
    }

    private Floormat getFloormat() {
        return (Floormat) getParent();  // FIXME: This is a bit hacky
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
        return this.xOffset;
    }

    /**
     * Sets the XOffset of this draggable.
     *
     * @param xOffset The value which will be the XOffset.
     */
    public void setXOffset(double xOffset) {
        this.xOffset = xOffset;
    }

    /**
     * Returns the YOffset of this draggable.
     *
     * @return The YOffset.
     */
    public double getYOffset() {
        return this.yOffset;
    }

    /**
     * Sets the YOffset of this draggable.
     *
     * @param yOffset The value which will be the YOffset.
     */
    public void setYOffset(double yOffset) {
        this.yOffset = yOffset;
    }

    /**
     * Sets the behaviour off the draggable, so that it can be moved inside its parent.
     */
    private void setBehavior() {
        setOnMousePressed((event) -> {
            event.consume();
            raise();
            xOffset = (getLayoutX() - event.getScreenX());
            yOffset = (getLayoutY() - event.getScreenY());
        });

        setOnMouseDragged((event) -> {
            event.consume();
            if (xOffset + event.getScreenX() < 0) {
                setLayoutX(0);
            } else if (xOffset + event.getScreenX() > getFloormat().getWidth()) {
                setLayoutX(getFloormat().getWidth() - 50);
            } else {
                setLayoutX(xOffset + event.getScreenX());
            }

            if (yOffset + event.getScreenY() < 0) {
                setLayoutY(0);

            } else if (yOffset + event.getScreenY() > getFloormat().getHeight()) {
                setLayoutY(getFloormat().getHeight() + event.getScreenY());

            } else {
                setLayoutY(yOffset + event.getScreenY());
            }
        });
    }
}
