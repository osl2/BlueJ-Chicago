package osl2.view.ui;

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
        getFreeSpace(draggable);
        super.addDraggable(draggable);
        draggableLinkedList.add(draggable);
    }

    private void getFreeSpace(Draggable draggable) {
        for (Draggable mirrors : draggableLinkedList) {
            MovableWindow mirror = (MovableWindow) mirrors;
            if (draggable.getXOffset() >= mirror.getXOffset() && draggable.getXOffset() <= mirror.getXOffset() + mirror.getWindowWidth()) {
                draggable.setXOffset(mirror.getXOffset() + mirror.getWindowWidth());
                draggable.setLayoutX(draggable.getXOffset());
            }
            if (draggable.getYOffset() >= mirror.getYOffset() && draggable.getYOffset() <= mirror.getYOffset() + mirror.getWindowHeight()) {
                draggable.setYOffset(mirror.getYOffset() + mirror.getWindowHeight());
                draggable.setLayoutY(draggable.getYOffset());
            }
        }
    }
}
