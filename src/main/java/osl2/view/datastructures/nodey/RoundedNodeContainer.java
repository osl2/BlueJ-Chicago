package osl2.view.datastructures.nodey;

import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * A rounded node with element.
 *
 * @param <T> The nodetype of the contents.
 */
public class RoundedNodeContainer<T extends Node> extends HBox {
    private final Pane pane;
    private ImageView arrow;
    private T contents;

    /**
     * Creates a new rounded node.
     *
     * @param contents The contents of the new node.
     */
    public RoundedNodeContainer(T contents) {
        this.pane = new Pane();
        this.arrow = new ImageView("images/arrow.png");
        this.pane.getChildren().add(contents);
        setContents(contents);
        this.pane.setMinWidth(25);
        this.pane.setMinHeight(25);
        this.arrow.setFitWidth(20);
        this.arrow.setFitHeight(20);
        getChildren().add(pane);
    }

    /**
     * Returns the contents of the node.
     *
     * @return The contents of the node.
     */
    public T getContents() {
        return contents;
    }

    public void showSelfRefArrow() {
        if (!getChildren().contains(arrow)) getChildren().add(arrow);
    }

    public void hideSelfRefArrow() {
        getChildren().remove(arrow);
    }

    protected void setContentStyle(String style) {
        pane.setStyle(style);
    }

    /**
     * Sets the content fot he node.
     *
     * @param newContents The new contents.
     */
    public void setContents(T newContents) {
        this.contents = newContents;
        pane.getChildren().set(0, newContents);
    }
}
