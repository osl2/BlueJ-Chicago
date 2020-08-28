package osl2.view.datastructures.nodey;

import javafx.scene.Node;
import osl2.messaging.datastructures.nodey.VNodeCommunication;
import osl2.view.ui.EvanstonWindow;
import osl2.view.ui.draggable.Draggable;

/**
 * The class for a node for the visualisation.
 *
 * @param <T>           The datatype of the content.
 * @param <ContentType> The type of JavaFX Node the content will be shown in.
 */
public abstract class GUINode<T, ContentType extends Node> extends Draggable implements VNodeCommunication<T> {
    private ArrowOverlay arrows;
    private final ContentType content;

    /**
     * Creates a new GUINode
     *
     * @param content The content of the node.
     */
    protected GUINode(ContentType content) {
        this.content = content;
        getChildren().add(content);
    }

    /**
     * Returns the contend of the node.
     *
     * @return The content of the node.
     */
    protected ContentType getContent() {
        return content;
    }

    /**
     * Returns the ArrowOverlay of the GuiNode.
     * @return The ArrowOverlay.
     */
    private ArrowOverlay getArrowOverlay() {
        return arrows;
    }

    /**
     * Sets the ArrowOverlay of the GuiNode.
     * @param overlay The ArrowOverlay.
     */
    public void setArrowOverlay(ArrowOverlay overlay) {
        this.arrows = overlay;
    }

    @Override
    public GUINode asGUINode() {
        return this;
    }
}