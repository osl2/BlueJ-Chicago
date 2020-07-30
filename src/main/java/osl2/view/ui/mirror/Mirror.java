package osl2.view.ui.mirror;

import javafx.scene.Node;
import javafx.scene.control.Label;
import osl2.view.ui.draggable.Floormat;
import osl2.view.ui.window.MovableWindow;

public class Mirror extends MovableWindow {

    public Mirror(Floormat floormat, String title, Node contents) {
        super(floormat, new Label(title), contents);
    }
}
