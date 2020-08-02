package osl2.view.ui.draggable;

import javafx.scene.Group;
import javafx.scene.layout.Pane;

public class Draggable extends Pane {
    private final Floormat floormat;

    private double xOffset;
    private double yOffset;


    public Draggable(Floormat floormat) {
        this.floormat = floormat;
        //TODO Add Mirror/Draggable to Mirror?
        setBehavior();
    }

    public Floormat getFloormat() {
        return floormat;
    }

    public void raise() {
        floormat.raise(this);
    }

    public void disappear() {
        floormat.removeDraggable(this);
    }

    public double getXOffset() {
        return this.xOffset;
    }

    public double getYOffset() {
        return this.yOffset;
    }

    public void setXOffset(double xOffset) {
        this.xOffset = xOffset;
    }

    public void setYOffset(double yOffset) {
        this.yOffset = yOffset;
    }

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
