package osl2.visualizer.gui;

import javafx.geometry.Orientation;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

public class SideBar extends Pane {
    ListView<MirrorButton> mirrorButtonList;
    public SideBar(){
        mirrorButtonList = new ListView<MirrorButton>();
        mirrorButtonList.setEditable(true);
        mirrorButtonList.setOrientation(Orientation.VERTICAL);
        this.getChildren().add(mirrorButtonList);
    }


    public void AddMirrorButton(MirrorButton mirrorButton){
        mirrorButtonList.getItems().add(mirrorButton);
    }

}

