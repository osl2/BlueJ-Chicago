package osl2.visualizer.gui.gui_datastructure;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import osl2.visualizer.model.VisualArray;
import osl2.visualizer.model.VisualDatastructure;

import java.beans.PropertyChangeEvent;

public class GuiArray<T> extends HBox implements GuiDatastructure {
    private final VisualArray<T> array;

    public GuiArray(VisualArray<T> array) {
        this.array = array;
    }

    public GuiArray(VisualDatastructure visualDatastructure){
        this.array = (VisualArray<T>) visualDatastructure;
        update();
    }

    @Override
    public Node asNode() {
        return this;
    }

    public void update() {
        getChildren().clear();
        final int size = array.size();
        for (int i = 0; i < size; i++) {
            Object value = array.getValue(i);
            String text = (value == null) ? "null" : value.toString();
            getChildren().add(new VBox(new Label(text), new Label("[" + i + "]")));
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        update();
    }
}