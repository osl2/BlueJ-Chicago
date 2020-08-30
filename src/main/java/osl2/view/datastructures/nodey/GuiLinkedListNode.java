package osl2.view.datastructures.nodey;

import javafx.scene.Node;
import javafx.scene.layout.VBox;
import osl2.messaging.datastructures.nodey.VLinkedListNodeCommunication;
import osl2.messaging.error_handling.UserError;
import osl2.view.inlinerepresentation.InlineRepresentation;

/**
 * A Linked List node in the gui.
 *
 * @param <T>
 *         The datatype of the contents.
 */
public class GuiLinkedListNode<T> extends GuiNode<T, VBox> implements VLinkedListNodeCommunication<T> {
    private final ArrowPane backwardArrowPane;
    private final ArrowPane forwardArrowPane;

    /**
     * Creates a new Linked List.
     */
    public GuiLinkedListNode() {
        super(new VBox());
        getContent().setStyle("-fx-background-color: white");
        VBox layoutBox = new VBox();
        getContent().getChildren().add(layoutBox);
        backwardArrowPane = new ArrowPane();
        backwardArrowPane.setMinWidth(10);
        backwardArrowPane.setMinHeight(10);
        backwardArrowPane.setStyle("-fx-border-color: black");
        forwardArrowPane = new ArrowPane();
        forwardArrowPane.setMinWidth(10);
        forwardArrowPane.setMinHeight(10);
        forwardArrowPane.setStyle("-fx-border-color: black");
        layoutBox.getChildren().add(forwardArrowPane);
        layoutBox.getChildren().add(backwardArrowPane);
        valueChange(null);
    }

    @Override
    public void setArrowOverlay(ArrowOverlay overlay) {
        super.setArrowOverlay(overlay);
        backwardArrowPane.setOverlay(overlay);
        forwardArrowPane.setOverlay(overlay);
    }

    @Override
    public void setForward(VLinkedListNodeCommunication<T> node) {
        forwardArrowPane.clear();
        if (node != null) {
            forwardArrowPane.connect(node.asGUINode());
        }
    }

    @Override
    public void setBackward(VLinkedListNodeCommunication<T> node) {
        backwardArrowPane.clear();
        if (node != null) {
            backwardArrowPane.connect(node.asGUINode());
        }
    }

    @Override
    public void valueChange(T newValue) {
        Node inlinerepresentation = InlineRepresentation.get(newValue);
        if (getContent().getChildren().size() < 2) {
            getContent().getChildren().add(inlinerepresentation);
        } else {
            getContent().getChildren().set(1, inlinerepresentation);
        }
    }

    @Override
    public void handleError(UserError userError) {
        // Not needed for nodes
    }

    @Override
    public void setName(String name) {
        // Not needed for nodes
    }
}