package osl2.view.ui.mirror;

import javafx.geometry.Point2D;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.ui.SideBar;
import osl2.view.ui.draggable.Floormat;

public class MirrorController implements IMirrorController {
    private MirrorButton button;
    private Mirror mirror;
    private Floormat mainRegion;
    private boolean mirrorOpen;

    public MirrorController(DatastructureVisualization visualization, Floormat mainRegion, SideBar sideBar) {
        this.mirrorOpen = false;
        this.mainRegion = mainRegion;
        this.button = new MirrorButton(visualization.getName(), this);
        this.mirror = new Mirror(mainRegion, visualization.getName(), visualization.asNode(), this);
        sideBar.addMirrorButton(button);
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
        if (!mirrorOpen) {
            mirrorOpen = true;
            mainRegion.addDraggable(mirror);
        }
        //TODO Mirror.higlight
    }

    @Override
    public MirrorButton getMirrorButton() {
        return this.button;
    }
}
