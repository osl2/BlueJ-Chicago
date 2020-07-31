package osl2.view.ui.mirror;

import javafx.scene.control.Button;

/**
 * The Visual Represantation of a MirrorButton
 */
public class MirrorButton extends Button {

    private IMirrorController mirrorController;
    private String name;

    /**
     *The Constructor of the MirrorButton. Here the name and mirrorController field will be set to its values.
     * @param name, this String will be the text of MirrorButton
     * @param mirrorController, The MirrorController will be linked to the actions of this MirrorButton
     */
    public MirrorButton(String name, IMirrorController mirrorController) {
        this.mirrorController = mirrorController;
        this.name = name;
        this.setText(this.name);
        linkButtonToController();
    }

    /**
     * This method links the MirrorButton to the mirrorController. Every Action on the MirrorButton will be sent to the mirrorController
     */
    private void linkButtonToController() {
        this.setOnAction(e -> mirrorController.mirrorBtnClicked());
    }

}
