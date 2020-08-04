package osl2.view.ui;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import osl2.view.ui.draggable.Draggable;
import osl2.view.ui.draggable.Floormat;
import osl2.view.ui.window.MovableWindow;

import java.util.LinkedList;

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
    }

    /**
     * This method calculates where a new Mirror can be added to not overlap with already existing mirrors.
     * @param draggable The Mirror wich will be added.
     */
    public void getFreeSpace(Draggable draggable) {
        if(!draggableLinkedList.contains(draggable)) {
            for (Draggable mirrors : draggableLinkedList) { ;
                Bounds draggableBounds = draggable.getBoundsInParent();
                Bounds mirrorBounds = mirrors.getBoundsInParent();
                for(int i = 0; i < draggableBounds.getWidth(); i++){
                    for(int j = 0; j < draggableBounds.getHeight(); j++){
                        Point2D pointInDraggable = new Point2D(draggableBounds.getMinX() + i, draggableBounds.getMinY() +j);
                        if(mirrorBounds.contains(pointInDraggable)){
                            draggable.setXOffset(mirrorBounds.getMinX() + mirrorBounds.getWidth());
                            draggable.setLayoutX(draggable.getXOffset());
                            break;
                        }
                    }
                }
            }
            draggableLinkedList.add(draggable);
        }
    }


}
