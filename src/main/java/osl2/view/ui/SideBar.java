package osl2.view.ui;

import javafx.scene.control.ListView;
import osl2.view.ui.mirror.MirrorButton;

import java.util.LinkedList;

/**
 * The Sidebar is the space in the View where the MirrorButtons will be for the user to open.
 */
public class SideBar extends ListView<MirrorButton> {

    private LinkedList<MirrorButton> mirrorButtonList;

    /**
     * Creates a new Sidebar
     */
    public SideBar() {
        mirrorButtonList = new LinkedList<MirrorButton>();
        this.getStyleClass().add("sidebar");
    }

    /**
     * Adds a new MirrorButton to the Sidebar.
     * @param mirrorButton The MirrorButton wich will be added.
     */
    public void addMirrorButton(MirrorButton mirrorButton) {
        getItems().add(mirrorButton);
        mirrorButtonList.add(mirrorButton);
    }

    public void setFontSize(FontSize newFontSize){
        for(MirrorButton mirrorButton: mirrorButtonList){
            removeAllFontSizes(mirrorButton);
            mirrorButton.getStylesheets().add(newFontSize.getFileName());
        }
    }

    private void removeAllFontSizes(MirrorButton mirrorButton) {
        for (FontSize fontSize : FontSize.values()) {
            mirrorButton.getStylesheets().remove(fontSize.getFileName());
        }
    }

}
