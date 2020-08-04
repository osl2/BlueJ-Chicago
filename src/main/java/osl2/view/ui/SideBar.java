package osl2.view.ui;

import javafx.scene.control.ListView;
import osl2.view.ui.mirror.MirrorButton;

/**
 * The Sidebar is the space in the View where the MirrorButtons will be for the user to open.
 */
public class SideBar extends ListView<MirrorButton> {

    /**
     * Creates a new Sidebar
     */
    public SideBar() {
        this.getStyleClass().add("sidebar");
    }

    /**
     * Adds a new MirrorButton to the Sidebar.
     * @param mirrorButton The MirrorButton wich will be added.
     */
    public void addMirrorButton(MirrorButton mirrorButton) {
        getItems().add(mirrorButton);
    }

}
