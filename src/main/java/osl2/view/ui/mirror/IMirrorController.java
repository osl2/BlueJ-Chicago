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

    // TODO New method
    // It replaces minimizeMirror() and maximizeMirror().

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
}
