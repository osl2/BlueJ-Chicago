package osl2.visualizer.gui.gui_datastructure;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import osl2.visualizer.model.VisualArray;
import osl2.visualizer.model.VisualDatastructure;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GuiArray<T> extends ScrollPane implements GuiDatastructure {
    private VisualArray<T> array;
    private HBox rowOne;
    private HBox rowTwo;
    private VBox vBox;

    public GuiArray(VisualArray<T> array) {
        this.array = array;
    }

    public GuiArray(VisualDatastructure visualDatastructure){
        this.array = new VisualArray<>(5);

        //setUpBoxes();
        //visualize();
    }

    private void setUpBoxes(){
        this.rowOne = new HBox();
        this.rowTwo = new HBox();
        rowOne.setSpacing(10);
        rowTwo.setSpacing(10);
        drawSecondRow();
        this.vBox = new VBox();
        vBox.getChildren().add(rowOne);
        vBox.getChildren().add(rowTwo);
        this.getChildren().add(vBox);
    }
    @Override
    public Node asNode() {
        return this;
    }

    @Override
    public boolean visualize() {
        rowOne.getChildren().clear();
        drawFirstRow();
        return true;
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

    private void drawFirstRow(){
        for(int i = 0; i < array.size(); i++){
            GuiArrayBox label = new GuiArrayBox("[" + array.getValue(i) + "]");
            rowOne.getChildren().add(label);
        }
    }

    private void drawSecondRow(){
        for(int i = 0; i < array.size(); i++){
            GuiArrayBox label = new GuiArrayBox("[" + i + "]");
            rowTwo.getChildren().add(this);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        this.array = (VisualArray<T>) propertyChangeEvent.getNewValue();
        update();
        //visualize();
    }
}