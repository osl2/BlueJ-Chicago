package osl2.view.datastructures;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import osl2.messaging.datastructures.VArrayCommunication;
import osl2.view.inlinerepresentation.InlineRepresentation;

public class GUIArray<T> extends HBox implements DatastructureVisualization, VArrayCommunication<T> {

    public GUIArray() {
        setSpacing(10);
    }

    @Override
    public String getName() {
        return "Array";
    }

    @Override
    public Node asNode() {
        return this;
    }

    @Override
    public void setSize(int size) {
        getChildren().clear();
        for (int x = 0; x < size; x++) {
            getChildren().add(new ArrayEntry(x, InlineRepresentation.get(null)));
        }
    }

    @Override
    public void setValue(int i, T value) {
        getChildren().set(i, new ArrayEntry(i, InlineRepresentation.get(value)));
    }

    class ArrayEntry extends VBox {

        public ArrayEntry(int index, Node value) {
            setSpacing(5);
            getChildren().add(value);
            Label label = new Label("" + index);
            label.setMaxWidth(Double.MAX_VALUE);
            label.setAlignment(Pos.CENTER);
            getChildren().add(label);
        }
    }
}
