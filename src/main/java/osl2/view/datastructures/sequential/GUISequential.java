package osl2.view.datastructures.sequential;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import osl2.view.datastructures.DatastructureVisualization;

public abstract class GUISequential extends HBox implements DatastructureVisualization {

    @Override
    public Node asNode() {
        return this;
    }

    protected void clearElements() {
        getChildren().clear();
    }

    protected void putElement(int i, Node value) {
        Label label = new Label("" + i);
        label.setMaxWidth(Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER);
        putElement(i, value, label);
    }

    protected void putElement(int i, Node above, Node below) {
        while (getChildren().size() <= i) getChildren().add(new GUISequentialEntry(above, below));
        getChildren().set(i, new GUISequentialEntry(above, below));
    }

    protected void removeElement(int i) {
        getChildren().remove(i);
    }

    protected GUISequential() {
        setSpacing(10);
    }

    private class GUISequentialEntry extends VBox {

        public GUISequentialEntry(Node above, Node below) {
            setSpacing(5);
            getChildren().add(above);
            getChildren().add(below);
        }
    }
}
