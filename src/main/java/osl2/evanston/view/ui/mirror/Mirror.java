package osl2.evanston.view.ui.mirror;

import javafx.scene.Node;
import javafx.scene.control.Label;
import osl2.evanston.view.ui.draggable.Floormat;
import osl2.evanston.view.ui.window.MovableWindow;

public class Mirror extends MovableWindow {

    public Mirror(Floormat floormat, String title, Node contents) {
        super(floormat, new Label(title), contents);
    }
}
