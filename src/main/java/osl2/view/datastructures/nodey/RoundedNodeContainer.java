package osl2.view.datastructures.nodey;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class RoundedNodeContainer<T extends Node> extends Pane {
    private T contents;

    public T getContents() { return contents; }
    public void setContents(T newContents) {
        this.contents = newContents;
        getChildren().set(0, newContents);
    }

    public RoundedNodeContainer(T contents) {
        getChildren().add(contents);
        setContents(contents);
        setMinWidth(25);
        setMinHeight(25);
        // TODO
    }
}
