package osl2.visualizer.gui.mirror;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.example.*;

public class MirrorDetailed extends Pane {

	private GuiDatastructure guiDatastructure;

	/*
	The Constructor of the MirrorDetailed,
	 */
	public MirrorDetailed(VisualDatastructure visualDatastructure) {

		guiDatastructure = selectGuiDatastructure(visualDatastructure);

		setBorderDetailed();
	}

	/*
	Gives the MirrorDetailed Border to make it more visual appealing
	 */
	private void setBorderDetailed() {
		this.setBorder(new Border(new BorderStroke(Color.BLACK,
				BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

	}

	/*
	  This is a "fancy" version of InstanceOf.
	  This Methods purpose is to identify the Type of VisualDatastructure we have and select the right GuiDatastructure
	   */
	private GuiDatastructure selectGuiDatastructure(VisualDatastructure visualDatastructure) {
//		if (visualDatastructure.getType() == null) {
//			System.out.println("Waaaaa!");
//		}
		switch (visualDatastructure.getType()) {
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
	}
}
