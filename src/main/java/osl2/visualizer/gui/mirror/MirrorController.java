package osl2.visualizer.gui.mirror;

import osl2.visualizer.model.VisualDatastructure;

public class MirrorController implements IMirrorController {
	private final MirrorView mirrorView;
	private final MirrorButton mirrorButton;
	private double lastHeightOfMirror;
	private boolean isMaximized = true;

	/**
	 * The Constructor will create the MirrorView and MirrorButton with the given visualDatastructure
	 * @param visualDatastructure, the visualDatastructure this Mirror will visualize.
	 */
	public MirrorController(VisualDatastructure visualDatastructure) {
		mirrorView = new MirrorView(this, visualDatastructure);
		// TODO Redo calculation of name
		// maybe calculate it in VisualDatastructure
		// it is also needed in MirrorView
		String name = "testName";
		mirrorButton = new MirrorButton(name, this);
	}

	/**
	 * hides the MirrorView of the MirrorController
	 */
	@Override
	public void hideMirror() {
		mirrorView.hide();
	}

	/**
	 * reveals the MirrorView of the MirrorController
	 */
	@Override
	public void mirrorBtnClicked() {
		mirrorView.show();
	}

	/**
	 * depending on the previous state of the MirrorView, this method will do the inverse of the previous state
	 */
	@Override
	public void minOrMaxMirror() {
		if (isMaximized) {
			minimizeMirror();
			isMaximized = false;
		} else {
			maximizeMirror();
			isMaximized = true;
		}
	}

	/**
	 * reveals the MirrorDetailed and sets the height of the mirrorView to the last maximized height
	 */
	private void maximizeMirror() {
		mirrorView.getMirrorDetailed().setVisible(true);
		mirrorView.setMaxHeight(lastHeightOfMirror);
	}

	/**
	 * hides the MirrorDetailed and sets the lastHeightOfMirror to the proper value
	 */
	private void minimizeMirror() {
		mirrorView.getMirrorDetailed().setVisible(false);
		lastHeightOfMirror = mirrorView.getHeight();
		mirrorView.setMaxHeight(mirrorView.getMirrorHead().getHeight());
	}

	/**
	 * simple getter for MirrorButton
	 * @return the MirrorButton
	 */
	@Override
	public MirrorButton getMirrorButton() {
		return mirrorButton;
	}

	/**
	 * simple getter for MirrorView
	 * @return the MirrorView
	 */
	@Override
	public MirrorView getMirrorView() {
		return this.mirrorView;
	}
}