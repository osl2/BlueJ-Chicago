package osl2.visualizer.gui.mirror;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
//import org.example.*;
import osl2.visualizer.gui.gui_datastructure.*;
import osl2.visualizer.model.VisualArray;
import osl2.visualizer.model.VisualDatastructure;
import osl2.visualizer.model.VisualList;

public class MirrorDetailed extends Pane {

	private GuiDatastructure guiDatastructure;

	/**
	 * the Constructor of the mirrorDetailed, it sets the guiDatastructure and gives the MirrorDetailed a Border
	 * @param visualDatastructure, is used to create the needed guiDatastructure
	 */
	public MirrorDetailed(VisualDatastructure visualDatastructure) {

		guiDatastructure = selectGuiDatastructure(visualDatastructure);

		setBorderDetailed();
		getChildren().add(guiDatastructure.asNode());
	}

	/**
	 * creates a neat border for the mirrorDetailed
	 */
	private void setBorderDetailed() {
		this.setBorder(new Border(new BorderStroke(Color.BLACK,
				BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

	}

	/**
	 * This is a "fancy" version of InstanceOf.
	 * 	  This Methods purpose is to identify the Type of VisualDatastructure we have and select the right GuiDatastructure
	 * @param visualDatastructure, the type of this visualDatastructure is known through the getDatastructureType() method
	 * @return depending on the type of the visualDatastructure a proper GuiDatastructure will be returned
	 */
	private GuiDatastructure selectGuiDatastructure(VisualDatastructure visualDatastructure) {
		return new GuiArray(visualDatastructure);
		/*
		switch (visualDatastructure.getDatastructureType()) {
			case DS_ARRAY:
				return new GuiArray(visualDatastructure);
			case DS_DIRECTED_GRAPH:
				return new GuiDirectedGraph(visualDatastructure);
			case DS_UNDIRECTED_GRAPH:
				return new GuiUndirectedGraph(visualDatastructure);
			case DS_TREE:
				return new GuiTree(visualDatastructure);
			case DS_DOUBLY_LINKED_LIST:
				return new GuiDoublyLinkedList(visualDatastructure);
			case DS_MAP:
				return new GuiMap(visualDatastructure);
			case DS_SINGLY_LINKED_LIST:
				return new GuiSinglyLinkedList(visualDatastructure);
			default:
				return null;
		}
		 */
	}
}
