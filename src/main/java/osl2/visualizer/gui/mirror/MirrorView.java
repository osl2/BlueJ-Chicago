package osl2.visualizer.gui.mirror;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import osl2.visualizer.model.VisualDatastructure;

public class MirrorView extends Pane {

	private final double DEFAULT_WIDTH = 200;
	private final double DEFAULT_HEIGHT = 200;
	private final VisualDatastructure visualDatastructure;
	private final IMirrorController mirrorController;
	private MirrorHead mirrorHead;
	private MirrorDetailed mirrorDetailed;
	private VBox vBox;


	public MirrorView(IMirrorController mirrorController, VisualDatastructure visualDatastructure) {
		this.visualDatastructure = visualDatastructure;
		this.mirrorController = mirrorController;
		// TODO See comment in MirrorController regarding naming
		String name = "testName";

		mirrorHead = new MirrorHead(name);
		mirrorHead.linkControllerToBtns(mirrorController);
		mirrorDetailed = new MirrorDetailed();

		setUpMirrorView(mirrorController, visualDatastructure);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setColor();
	}

	public void show() {
		this.setVisible(true);
	}

	public void hide() {
		this.setVisible(false);
	}

	public MirrorHead getMirrorHead() {
		return this.mirrorHead;
	}

	public MirrorDetailed getMirrorDetailed() {
		return this.mirrorDetailed;
	}

	private void setUpMirrorView(IMirrorController mirrorController, VisualDatastructure visualDatastructure) {
		mirrorHead.linkControllerToBtns(mirrorController);
		vBox = new VBox();
		vBox.getChildren().add(mirrorHead);
		vBox.getChildren().add(mirrorDetailed);
		this.getChildren().add(vBox);
	}

	private void setSize(double width, double height) {
		vBox.setPrefSize(width, height);
		this.setPrefSize(width, height);
		this.setMaxSize(width, height);
		// the height of the mirrorHead should only be 10% of the mirrorView
		this.mirrorHead.setPrefSize(width, height * 0.1);
		//the height of the mirrorDetailed should be the rest of the mirrorView
		this.mirrorDetailed.setPrefSize(width, height * 0.9);
	}

	private void setColor() {
		this.getStyleClass().add("mirror-view");
	}
}
