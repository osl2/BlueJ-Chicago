package osl2.visualizer.gui.mirror;

/**
 * Defines the interface of the mirror controller of the MVC.
 * It is responsible for controlling the mirror.
 */
public interface IMirrorController {

	/**
	 * Hide the {@link MirrorView}.
	 */
	void hideMirror();

	// TODO New method
	// It replaces minimizeMirror() and maximizeMirror().
	/**
	 * Minimize or maximize {@link MirrorView} depending on the previous state.
	 */
	void minOrMaxMirror();

	/**
	 * Show the {@link MirrorView}
	 */
	void mirrorBtnClicked();

	/**
	 * Return the {@link MirrorButton} of the mirror.
	 *
	 * @return the mirror button
	 */
	MirrorButton getMirrorButton();

	/**
	 * Return the {@link MirrorView} of the mirror.
	 *
	 * @return the mirror view
	 */
	MirrorView getMirrorView();
}
