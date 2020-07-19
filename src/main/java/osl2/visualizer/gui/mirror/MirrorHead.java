package osl2.visualizer.gui.mirror;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class MirrorHead extends Pane {
	private final Label title;
	private HBox layout;
	private Button hideButton;
	private Button minMaxButton;
	private HBox rightButtons;

	public MirrorHead(String name) {
		this.title = new Label(name);
		createLayout();
		this.getChildren().add(layout);
		this.setMinHeight(30);

		setColor();
		setBorderHead();
	}

	public void linkControllerToBtns(IMirrorController mirrorController) {
		hideButton.setOnAction(e -> mirrorController.hideMirror());
		minMaxButton.setOnAction(e -> mirrorController.minOrMaxMirror());
	}

	private void createLayout() {
		createRightBox();

		layout = new HBox(title, rightButtons);
		layout.setSpacing(100);
		layout.setPadding(new Insets(2));
	}

	private void createRightBox() {
		createButtons();
		rightButtons = new HBox(hideButton, minMaxButton);
		rightButtons.setAlignment(Pos.CENTER_RIGHT);
		rightButtons.setSpacing(0);
		HBox.setHgrow(rightButtons, Priority.ALWAYS);
	}

	private void createButtons() {
		hideButton = new Button("x");
		minMaxButton = new Button("^");
	}

	private void setColor() {
		this.getStyleClass().add("mirror-head");
	}

	// TODO Move to css
	public void setBorderHead() {
		this.setBorder(new Border(new BorderStroke(Color.BLACK,
				BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	}
}
