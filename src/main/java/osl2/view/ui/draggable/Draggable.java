package osl2.view.ui.draggable;

import javafx.scene.Group;

/**
 * The draggable class is a object which can be moved.
 */
public class Draggable extends Group {
    private final Floormat floormat;

    private double xOffset;
    private double yOffset;


    /**
     * Creates a new draggable.
     * @param floormat The floormat in which this draggable will be added.
     */
    public Draggable(Floormat floormat) {
        this.floormat = floormat;
        //TODO Add Mirror/Draggable to Mirror?
        setBehavior();
    }

    /**
     * Returns the Floormat in which the draggable will be.
     * @return The Floormat.
     */
    public Floormat getFloormat() {
        return floormat;
    }

    /**
     * Raises the draggable insinde its floormat.
     */
    public void raise() {
        floormat.raise(this);
    }

    /**
     * Let's the draggable be removed from its floormat.
     */
    public void disappear() {
        floormat.removeDraggable(this);
    }

    /**
     * Returns the XOffset of this draggable.
     * @return The XOffset.
     */
    public double getXOffset() {
        return this.xOffset;
    }

    /**
     * Returns the YOffset of this draggable.
     * @return The YOffset.
     */
    public double getYOffset() {
        return this.yOffset;
    }

    /**
     * Sets the XOffset of this draggable.
     * @param xOffset The value which will be the XOffset.
     */
    public void setXOffset(double xOffset) {
        this.xOffset = xOffset;
    }

    /**
     * Sets the YOffset of this draggable.
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
            raise();
            xOffset =  (getLayoutX() - event.getScreenX());
            yOffset =  (getLayoutY() - event.getScreenY());
        });

        setOnMouseDragged((event) -> {


            if (xOffset + event.getScreenX() < 0) {
                setLayoutX(0);
            } else if (xOffset + event.getScreenX() > floormat.getWidth()) {
                setLayoutX(floormat.getWidth() - 50);
            } else {
                setLayoutX(xOffset + event.getScreenX());
            }

            if (yOffset + event.getScreenY() < 0) {
                setLayoutY(0);

            } else if (yOffset + event.getScreenY() > floormat.getHeight()) {
                setLayoutY(floormat.getHeight() + event.getScreenY());

            } else {
                setLayoutY(yOffset + event.getScreenY());
            }
        });
    }
}
