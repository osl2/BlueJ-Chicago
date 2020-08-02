package osl2.view.datastructures.sequential;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import osl2.messaging.datastructures.VArrayCommunication;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.inlinerepresentation.InlineRepresentation;

public class GUIArray<T> extends GUISequential implements DatastructureVisualization, VArrayCommunication<T> {

    @Override
    public String getName() {
        return "Array";
    }

    @Override
    public void setSize(int size) {
        clearElements();
        for (int x = 0; x < size; x++) {
            putElement(x, InlineRepresentation.get(null));
        }
    }

    @Override
    public void setValue(int i, T value) {
        putElement(i, InlineRepresentation.get(value));
    }
}
