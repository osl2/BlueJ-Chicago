package osl2.visualizer.gui.gui_datastructure;

import javafx.scene.Node;

import java.beans.PropertyChangeListener;

public interface GuiDatastructure extends PropertyChangeListener {
    Node asNode();
}
