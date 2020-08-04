package osl2.view.datastructures.nodey;

import javafx.scene.Node;
import osl2.messaging.datastructures.nodey.VNodeCommunication;
import osl2.view.ui.draggable.Draggable;

public abstract class GUINode<T, ContentType extends Node> extends Draggable implements VNodeCommunication<T> {

    private final ContentType content;

    protected GUINode(ContentType content) {
        this.content = content;
        getChildren().add(content);
    }

    protected ContentType getContent() { return content; }

    @Override
    public GUINode asGUINode() {
        return this;
    }
}
