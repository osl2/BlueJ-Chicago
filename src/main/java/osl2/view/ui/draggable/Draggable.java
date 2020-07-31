package osl2.view.ui.draggable;

import javafx.scene.Group;

public class Draggable extends Group {
    private final Floormat floormat;

    private int xOffset;
    private int yOffset;


    public Draggable(Floormat floormat) {
        this.floormat = floormat;
        //TODO Add Mirrir/Draggable to Mirror?
        //floormat.addDraggable(this);
        setBehavior();
    }

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


            if(xOffset + event.getScreenX() < 0){
                setLayoutX(0);
            } else if(xOffset + event.getScreenX() > floormat.getWidth()){
                setLayoutX(floormat.getWidth() - 50);
            } else {
                setLayoutX(xOffset + event.getScreenX());
            }

            if(yOffset + event.getScreenY() < 0){
                setLayoutY(0);

            } else if(yOffset + event.getScreenY() > floormat.getHeight()){
                setLayoutY(floormat.getHeight() + event.getScreenY());

            } else {
                setLayoutY(yOffset + event.getScreenY());
            }
        });
    }
}
