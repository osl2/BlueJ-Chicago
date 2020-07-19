package osl2.visualizer.gui;

import javafx.scene.control.ListView;
import osl2.visualizer.gui.mirror.MirrorButton;

public class SideBar extends ListView<MirrorButton> {

	public SideBar() {
		super();
		this.widthProperty().addListener(e -> {
			for (MirrorButton b : this.getItems()) {
				b.setPrefWidth(this.getWidth());
			}
		});
	}

	public void addMirrorButton(MirrorButton mirrorButton) {
		getItems().add(mirrorButton);
	}

}
