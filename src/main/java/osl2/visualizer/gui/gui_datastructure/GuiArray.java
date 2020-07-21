package osl2.visualizer.gui.gui_datastructure;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import osl2.visualizer.model.VisualArray;
import osl2.visualizer.model.VisualDatastructure;

public class GuiArray<T> extends HBox implements GuiDatastructure {
    private final VisualArray<T> array;

    public GuiArray(VisualArray<T> array) {
        this.array = array;
    }

    public GuiArray(VisualDatastructure visualDatastructure){
        //TODO
        this.array = null;
    }

    public void update() {
        getChildren().clear();
        final int size = array.size();
        for (int i = 0; i < size; i++) {
            getChildren().add(new VBox(new Label(array.getValue(i).toString()), new Label("[" + (i++) + "]")));
        }
    }
}