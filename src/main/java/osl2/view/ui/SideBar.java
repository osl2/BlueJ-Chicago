package osl2.view.ui;

import javafx.scene.control.ListView;
import osl2.view.ui.mirror.MirrorButton;

public class SideBar extends ListView<MirrorButton> {

    public SideBar() {
    }

    public void addMirrorButton(MirrorButton mirrorButton) {
        getItems().add(mirrorButton);
    }

}
