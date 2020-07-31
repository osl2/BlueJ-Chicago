package osl2.view.ui.window;

import javafx.scene.Node;
import osl2.view.ui.draggable.Draggable;
import osl2.view.ui.draggable.Floormat;
import osl2.view.ui.mirror.IMirrorController;

public class MovableWindow extends Draggable {
    private final MovableWindowBody body;

    public MovableWindow(Floormat floormat, Node title, Node contents, IMirrorController controller) {
        super(floormat);
        body = new MovableWindowBody(this, title, contents);
        body.getHead().linkBtnToController(controller);
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

    public double getWindowWidth() {
        return body.getWidth();
    }

    public double getWindowHeight() {
        return body.getHeight();
    }
}
