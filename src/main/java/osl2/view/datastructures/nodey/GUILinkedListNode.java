package osl2.view.datastructures.nodey;

import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import osl2.messaging.datastructures.nodey.VLinkedListNodeCommunication;
import osl2.messaging.errorHandling.UserError;
import osl2.view.inlinerepresentation.InlineRepresentation;

public class GUILinkedListNode<T> extends GUINode<T, VBox> implements VLinkedListNodeCommunication<T> {
    private final HBox layoutBox;
    private final ArrowPane leftArrowPane;
    private final ArrowPane rightArrowPane;


    public GUILinkedListNode() {
        super(new VBox());
        getContent().setStyle("-fx-background-color: white");
        this.layoutBox = new HBox();
        getContent().getChildren().add(layoutBox);
        leftArrowPane = new ArrowPane();
        leftArrowPane.setMinWidth(10);
        leftArrowPane.setMinHeight(10);
        rightArrowPane = new ArrowPane();
        rightArrowPane.setMinWidth(10);
        rightArrowPane.setMinHeight(10);
        layoutBox.getChildren().add(leftArrowPane);
        layoutBox.getChildren().add(rightArrowPane);
        valueChange(null);
    }

    @Override
    public void setForward(VLinkedListNodeCommunication<T> node) {
        rightArrowPane.getChildren().clear();
        if (node != null) rightArrowPane.connect(node.asGUINode());
    }

    @Override
    public void setBackward(VLinkedListNodeCommunication<T> node) {
        leftArrowPane.getChildren().clear();
        if (node != null) leftArrowPane.connect(node.asGUINode());
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
    }

    @Override
    public void setName(String name) {
    }
}
