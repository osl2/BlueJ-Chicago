package osl2.visualizer.gui.mirror;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import osl2.visualizer.model.VisualDatastructure;
//TODO add drag and drop functionality
//TODO add rezisability functionality
public class MirrorView extends Pane {

	private final double DEFAULT_WIDTH = 200;
	private final double DEFAULT_HEIGHT = 200;
	private final VisualDatastructure visualDatastructure;
	private final IMirrorController mirrorController;
	private MirrorHead mirrorHead;
	private MirrorDetailed mirrorDetailed;
	private VBox vBox;

	/**
	 * Constructor of the MirrorView, creates all the necessary fields and sets up the visual of the mirrorView
	 * @param mirrorController
	 * @param visualDatastructure
	 */
	public MirrorView(IMirrorController mirrorController, VisualDatastructure visualDatastructure) {
		this.visualDatastructure = visualDatastructure;
		this.mirrorController = mirrorController;
		// TODO See comment in MirrorController regarding naming
		String name = "testName";

		mirrorHead = new MirrorHead(name);
		mirrorHead.linkControllerToBtns(mirrorController);
		mirrorDetailed = new MirrorDetailed(visualDatastructure);

		setUpMirrorView(mirrorController);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setColor();
	}

	/**
	 * reveals the MirrorView
	 */
	public void show() {
		this.setVisible(true);
	}

	/**
	 * hides the MirrorView
	 */
	public void hide() {
		this.setVisible(false);
	}

	/**
	 * simple getter for the mirrorhead
	 * @return the mirrorHead
	 */
	public MirrorHead getMirrorHead() {
		return this.mirrorHead;
	}

	/**
	 * simple getter for the mirrorDetailed
	 * @return the mirrorDetailed
	 */
	public MirrorDetailed getMirrorDetailed() {
		return this.mirrorDetailed;
	}

	/**
	 * sets up the VBox, links the buttons and adds all buttons to the VBox
	 * @param mirrorController, all Buttons get linked to that
	 */
	private void setUpMirrorView(IMirrorController mirrorController) {
		mirrorHead.linkControllerToBtns(mirrorController);
		vBox = new VBox();
		vBox.getChildren().add(mirrorHead);
		vBox.getChildren().add(mirrorDetailed);
		this.getChildren().add(vBox);
	}

	/**
	 * sets the size of the MirrorView
	 * @param width
	 * @param height
	 */
	private void setSize(double width, double height) {
		vBox.setPrefSize(width, height);
		this.setPrefSize(width, height);
		this.setMaxSize(width, height);
		// the height of the mirrorHead should only be 10% of the mirrorView
		this.mirrorHead.setPrefSize(width, height * 0.1);
		//the height of the mirrorDetailed should be the rest of the mirrorView
		this.mirrorDetailed.setPrefSize(width, height * 0.9);
	}

	/**
	 * sets the Style
	 */
	private void setColor() {
		this.getStyleClass().add("mirror-view");
	}
}
