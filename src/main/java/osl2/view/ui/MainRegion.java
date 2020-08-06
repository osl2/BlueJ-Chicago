package osl2.view.ui;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import osl2.view.ui.draggable.Draggable;
import osl2.view.ui.draggable.Floormat;
import osl2.view.ui.mirror.Mirror;
import osl2.view.ui.mirror.MirrorButton;
import osl2.view.ui.window.MovableWindow;

import java.util.LinkedList;
import java.util.Random;

/**
 * The Mainregion will be the space, where the Mirrors will be in.
 * It extends a floormat, wich is a pane in wich movable elements can be added.
 */
public class MainRegion extends Floormat {

    /**
     * This List has all Mirrors in it, so that the position for new Mirror can be caluclated.
     */
    private LinkedList<Draggable> draggableLinkedList;

    public MainRegion() {
        this.draggableLinkedList = new LinkedList<Draggable>();
        this.setStyle();
    }

    @Override
    public void addDraggable(Draggable draggable){
        getChildren().add(draggable);
    }

    public void setFontSize(FontSize newFontSize){
        for(Draggable draggable: draggableLinkedList){
            Mirror mirror = (Mirror) draggable;
            mirror.setFontSize(newFontSize);
        }
    }


    private void setStyle() {
        this.getStyleClass().add("main-region");
    }

    /**
     * This method calculates where a new Mirror can be added to not overlap with already existing mirrors.
     * @param draggable The Mirror wich will be added.
     */
    public void getFreeSpace(Draggable draggable) {
        if(!draggableLinkedList.contains(draggable)) {
            double lowX = 0;
            double highX = this.getWidth() - draggable.getBoundsInParent().getWidth();
            double lowY = 0;
            double highY = this.getHeight() - draggable.getBoundsInParent().getHeight();
            draggable.setXOffset(Math.random() * (highX - lowX));
            draggable.setYOffset(Math.random() * (highY - lowY));
            draggable.setLayoutX(draggable.getXOffset());
            draggable.setLayoutY(draggable.getYOffset());
            draggableLinkedList.add(draggable);
        }
    }


}
