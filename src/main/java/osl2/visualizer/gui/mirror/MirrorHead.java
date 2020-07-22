package osl2.visualizer.gui.mirror;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

/**
 * The MirrorHead, this class is the topline of the MirrorView. It keeps several buttons to minimize/maximize or close the mirror.
 * And keeps the name of the Datastructure that will be visualized through the Mirror containing this MirrorHead
 */
public class MirrorHead extends Pane {
	private final Label title;
	private HBox layout;
	private Button hideButton;
	private Button minMaxButton;
	private HBox rightButtons;
	private final int minHeight = 30;

	/**
	 * creates all the necessary buttons and sets the minHeight of this pane
	 * @param name, will be set as the title of the mirrorhead
	 */
	public MirrorHead(String name) {
		this.title = new Label(name);
		createLayout();
		this.getChildren().add(layout);
		this.setMinHeight(minHeight);

		setColor();
		setBorderHead();
	}

	/**
	 * links all buttons contained in this pane to the mirrorController, that on every action on a button a responsible method
	 * @param mirrorController
	 */
	public void linkControllerToBtns(IMirrorController mirrorController) {
		hideButton.setOnAction(e -> mirrorController.hideMirror());
		minMaxButton.setOnAction(e -> mirrorController.minOrMaxMirror());
	}

	/**
	 *sets the layout for the Panel
	 */
	private void createLayout() {
		createRightBox();

		layout = new HBox(title, rightButtons);
		layout.setSpacing(100);
		layout.setPadding(new Insets(2));
	}

	/**
	 * creates the HBox on the right side, which contains all buttons
	 */
	private void createRightBox() {
		createButtons();
		rightButtons = new HBox(hideButton, minMaxButton);
		rightButtons.setAlignment(Pos.CENTER_RIGHT);
		rightButtons.setSpacing(0);
		HBox.setHgrow(rightButtons, Priority.ALWAYS);
	}

	/**
	 * creates the buttons of the mirrorhead
	 */
	private void createButtons() {
		hideButton = new Button("x");
		minMaxButton = new Button("^");
	}

	/**
	 * sets the style of the head
	 */
	private void setColor() {
		this.getStyleClass().add("mirror-head");
	}

	// TODO Move to css
	public void setBorderHead() {
		this.setBorder(new Border(new BorderStroke(Color.BLACK,
				BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	}
}
