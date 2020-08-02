package osl2.view.ui;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import osl2.view.ui.draggable.Draggable;
import osl2.view.ui.draggable.Floormat;
import osl2.view.ui.window.MovableWindow;

import java.util.LinkedList;

public class MainRegion extends Floormat {

    private LinkedList<Draggable> draggableLinkedList;

    public MainRegion() {
        this.draggableLinkedList = new LinkedList<Draggable>();
    }

    @Override
    public void addDraggable(Draggable draggable) {
        super.addDraggable(draggable);
    }

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
