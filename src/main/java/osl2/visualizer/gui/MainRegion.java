package osl2.visualizer.gui;

import javafx.scene.layout.VBox;
import osl2.visualizer.gui.mirror.MirrorView;

public class MainRegion extends VBox {
	public void addMirrorView(MirrorView mirrorView) {
		this.getChildren().add(mirrorView);
	}

}
