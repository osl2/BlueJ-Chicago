package osl2.evanston.view.ui.draggable;

import javafx.scene.Group;

public class Draggable extends Group {
    private final Floormat floormat;

    private int xOffset;
    private int yOffset;


    public Floormat getFloormat() {
        return floormat;
    }

    public void raise() {
        getFloormat().raise(this);
    }

    public void disappear() {
        floormat.removeDraggable(this);
    }

    private void setBehavior() {
        setOnMousePressed((event) -> {
            raise();
            xOffset = (int) (getLayoutX() - event.getScreenX());
            yOffset = (int) (getLayoutY() - event.getScreenY());
        });

        setOnMouseDragged((event) -> {
            setLayoutX(xOffset + event.getScreenX());
            setLayoutY(yOffset + event.getScreenY());
        });
    }

    public Draggable(Floormat floormat) {
        this.floormat = floormat;
        floormat.addDraggable(this);
        setBehavior();
    }
}
