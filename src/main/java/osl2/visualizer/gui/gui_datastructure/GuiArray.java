package osl2.visualizer.gui.render;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import osl2.visualizer.model.VisualArray;

public class GUIArrayRenderer<T> extends HBox {
    private final VisualArray<T> array;

    public GUIArrayRenderer(VisualArray<T> array) {
        this.array = array;
    }

    public void update() {
        getChildren().clear();
        final int size = array.size();
        for (int i = 0; i < size; i++) {
            getChildren().add(new VBox(new Label(array.getValue(i).toString()), new Label("[" + (i++) + "]")));
        }
    }
}
