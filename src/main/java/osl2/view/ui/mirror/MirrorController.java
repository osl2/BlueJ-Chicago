package osl2.view.ui.mirror;

import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.ui.MainRegion;
import osl2.view.ui.SideBar;
import osl2.view.ui.draggable.Floormat;

public class MirrorController implements IMirrorController {
    private MirrorButton button;
    private Mirror mirror;
    private Floormat mainRegion;
    private boolean mirrorOpen;
    private boolean mirrorHide;

    public MirrorController(DatastructureVisualization visualization, Floormat mainRegion, SideBar sideBar) {
        this.mirrorOpen = false;
        this.mainRegion = mainRegion;
        this.button = new MirrorButton(visualization.getName(), this);
        this.mirror = new Mirror(mainRegion, visualization.getName(), visualization.asNode(), this);
        sideBar.addMirrorButton(button);
        mirror.setVisible(false);
        mirrorHide = true;
        this.mainRegion.addDraggable(mirror);
    }

    @Override
    public void hideMirror() {
        mirrorOpen = false;
        mirror.disappear();
    }

    @Override
    public void minOrMaxMirror() {
        mirror.toggle();
    }

    @Override
    public void mirrorBtnClicked() {
        if(mirrorHide){
            mirror.setVisible(true);
            mirrorHide = false;
            mainRegion.removeDraggable(mirror);
        }
        if (!mirrorOpen) {
            mirrorOpen = true;
            MainRegion region = (MainRegion) mainRegion;
            region.getFreeSpace(mirror);
            mainRegion.addDraggable(mirror);
        } else {
            mirror.toggleHighlight();
        }
    }

    @Override
    public MirrorButton getMirrorButton() {
        return this.button;
    }
}
