package osl2.visualizer.gui.gui_datastructure;

import javafx.scene.Node;
import osl2.visualizer.model.VisualDatastructure;

import java.beans.PropertyChangeEvent;

public class GuiUndirectedGraph implements GuiDatastructure{

    public GuiUndirectedGraph(VisualDatastructure visualDatastructure){
        //TODO cast parameter visualDatastructure and set the corresponding VisualUndirectedGraph
    }

    @Override
    public Node asNode() {
        return null;    // TODO
    }

    @Override
    public boolean visualize() {
        return false;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        // TODO
    }
}
