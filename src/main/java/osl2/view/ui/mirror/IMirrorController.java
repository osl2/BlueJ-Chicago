package osl2.view.ui.mirror;

/**
 * Defines the interface of the mirror controller of the MVC.
 * It is responsible for controlling the mirror.
 */
public interface IMirrorController {

    /**
     * Hide the
     */
    void hideMirror();

    /**
     * Minimize or maximize  depending on the previous state.
     */
    void minOrMaxMirror();

    /**
     * Show the #
     */
    void mirrorBtnClicked();

    /**
     * Return the {@link MirrorButton} of the mirror.
     *
     * @return the mirror button
     */
    MirrorButton getMirrorButton();

    void setName(String name);

    /**
     * Resizes the mirrors width by the specified offset.
     *
     * @param xOffset
     *         - the specified offset
     */
    void resizeMirrorX(double xOffset);

    /**
     * Resizes the mirrors height by the specified offset.
     *
     * @param yOffset
     *         - the specified offset
     */
    void resizeMirrorY(double yOffset);
}
