package osl2.visualizer.gui.mirror;

import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class MirrorDetailed extends Pane {

	public MirrorDetailed() {
		setBorderDetailed();
	}

	// TODO Move to css
	public void setBorderDetailed() {
		this.setBorder(new Border(new BorderStroke(Color.BLACK,
				BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));

	}
}