package osl2.view.datastructures.nodey;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * A rounded node with element.
 *
 * @param <T> The nodetype of the contents.
 */
public class RoundedNodeContainer<T extends Node> extends Pane {
    private T contents;

    /**
     * Creates a new rounded node.
     *
     * @param contents The contents of the new node.
     */
    public RoundedNodeContainer(T contents) {
        getChildren().add(contents);
        setContents(contents);
        setMinWidth(25);
        setMinHeight(25);
        // TODO
    }

    /**
     * Returns the contents of the node.
     *
     * @return The contents of the node.
     */
    public T getContents() {
        return contents;
    }

    /**
     * Sets the content fot he node.
     *
     * @param newContents The new contents.
     */
    public void setContents(T newContents) {
        this.contents = newContents;
        getChildren().set(0, newContents);
    }
}
