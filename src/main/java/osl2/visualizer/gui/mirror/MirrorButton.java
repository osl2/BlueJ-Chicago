package osl2.visualizer.gui.mirror;

import javafx.scene.control.Button;

public class MirrorButton extends Button {
	IMirrorController mirrorController;
	String name;

	public MirrorButton(String name, IMirrorController mirrorController) {
		this.mirrorController = mirrorController;
		this.name = name;
		this.setText(this.name);
		linkButtonToController();
	}

	private void linkButtonToController() {
		this.setOnAction(e -> mirrorController.mirrorBtnClicked());
	}
}
