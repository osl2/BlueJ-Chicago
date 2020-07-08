package osl2.visualizer.gui;

import javafx.geometry.Orientation;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;

public class SideBar extends ListView {
    public SideBar(){
        super();
    }


    public void addMirrorButton(MirrorButton mirrorButton){getItems().add(mirrorButton);}

}

