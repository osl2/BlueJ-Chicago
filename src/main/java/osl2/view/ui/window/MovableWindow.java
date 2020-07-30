package osl2.view.ui.window;

import javafx.scene.Node;
import osl2.view.ui.draggable.Draggable;
import osl2.view.ui.draggable.Floormat;

public class MovableWindow extends Draggable {
    private final MovableWindowBody body;

    public MovableWindow(Floormat floormat, Node title, Node contents) {
        super(floormat);
        body = new MovableWindowBody(this, title, contents);
        getChildren().add(body);
    }

    public void showContents() {
        body.showContents();
    }

    public void hideContents() {
        body.hideContents();
    }

    public void toggle() {
        body.toggle();
    }
}
