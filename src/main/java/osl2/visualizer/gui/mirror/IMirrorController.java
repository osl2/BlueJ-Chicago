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

	/**
	 * Maximize the {@link MirrorView}.
	 */
	void maximizeMirror();

	/**
	 * Minimize the {@link MirrorView}.
	 */
	void minimizeMirror();

	/**
	 * Show the {@link MirrorView}
	 */
	void mirrorBtnKlicked();

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
