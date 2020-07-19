package osl2.visualizer.gui.mirror;

import osl2.visualizer.model.VisualDatastructure;

public class MirrorController implements IMirrorController {
	private final MirrorView mirrorView;
	private final MirrorButton mirrorButton;
	private double lastHeightOfMirror;
	private boolean isMaximized = true;

	public MirrorController(VisualDatastructure visualDatastructure) {
		mirrorView = new MirrorView(this, visualDatastructure);
		// TODO Redo calculation of name
		// maybe calculate it in VisualDatastructure
		// it is also needed in MirrorView
		String name = "testName";
		mirrorButton = new MirrorButton(name, this);
	}

	@Override
	public void hideMirror() {
		//TODO Implement
		mirrorView.hide();
	}

	@Override
	public void mirrorBtnClicked() {
		//TODO Implement
		mirrorView.show();
	}

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

	private void maximizeMirror() {
		//TODO Implement
		mirrorView.getMirrorDetailed().setVisible(true);
		mirrorView.setMaxHeight(lastHeightOfMirror);
	}

	private void minimizeMirror() {
		//TODO Implement
		mirrorView.getMirrorDetailed().setVisible(false);
		lastHeightOfMirror = mirrorView.getHeight();
		mirrorView.setMaxHeight(mirrorView.getMirrorHead().getHeight());
	}

	@Override
	public MirrorButton getMirrorButton() {
		return mirrorButton;
	}

	@Override
	public MirrorView getMirrorView() {
		return this.mirrorView;
	}
}