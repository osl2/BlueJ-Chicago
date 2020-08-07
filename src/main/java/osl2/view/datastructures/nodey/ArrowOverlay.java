package osl2.view.datastructures.nodey;

import javafx.scene.layout.Pane;

public class ArrowOverlay extends Pane {

    public ArrowOverlay() {
        setMouseTransparent(true);
    }

    public void addArrow(Arrow arrow) {
        getChildren().add(arrow);
    }

    public void removeArrow(Arrow arrow) {
        getChildren().remove(arrow);
    }
}
