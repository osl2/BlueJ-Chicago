package osl2.view.datastructures.sequential;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import osl2.view.datastructures.DatastructureVisualization;

public abstract class GUISequential extends DatastructureVisualization<HBox> {
    private final GUISequentialEntry head;

    protected GUISequential(String firstRowLabel, String secondRowLabel) {
        super(new HBox());
        getContents().setSpacing(10);
        head = new GUISequentialEntry(new Label(firstRowLabel), new Label(secondRowLabel));
        clearElements();    // This will insert the head
    }

    protected void clearElements() {
        getContents().getChildren().clear();
        getContents().getChildren().add(head);
    }

    protected void putElement(int i, Node value) {
        Label label = new Label("" + i);
        label.setMaxWidth(Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER);
        putElement(i + 1, value, label);
    }

    protected void putElement(int i, Node above, Node below) {
        while (getContents().getChildren().size() - 1 <= i) {
            getContents().getChildren().add(new GUISequentialEntry(above, below));
        }
        getContents().getChildren().set(i + 1, new GUISequentialEntry(above, below));
    }

    protected void removeElement(int i) {
        if (i >= 0 && i < getContents().getChildren().size() - 1) {
            getContents().getChildren().remove(i + 1);
        }
    }

    private class GUISequentialEntry extends VBox {

        public GUISequentialEntry(Node above, Node below) {
            setSpacing(5);
            getChildren().add(above);
            getChildren().add(below);
        }
    }
}
