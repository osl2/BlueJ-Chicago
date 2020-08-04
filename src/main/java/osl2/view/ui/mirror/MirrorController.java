package osl2.view.ui.mirror;

import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.ui.MainRegion;
import osl2.view.ui.SideBar;
import osl2.view.ui.draggable.Floormat;

public class MirrorController implements IMirrorController {
    private final MirrorButton button;
    private final Mirror mirror;
    private final MainRegion mainRegion;
    private boolean isMirrorOpen;
    private boolean isMirrorHidden;

    public MirrorController(DatastructureVisualization visualization, Floormat mainRegion, SideBar sideBar) {
        this.isMirrorOpen = false;
        this.mainRegion = (MainRegion) mainRegion;
        this.button = new MirrorButton(visualization.getName(), this);
        this.mirror = new Mirror(visualization.getName(), visualization.asNode(), this);
        sideBar.addMirrorButton(button);
        mirror.setVisible(false);
        isMirrorHidden = true;
        this.mainRegion.addDraggable(mirror);
    }

    @Override
    public void hideMirror() {
        isMirrorOpen = false;
        mirror.disappear();
    }

    @Override
    public void minOrMaxMirror() {
        mirror.toggle();
    }

    @Override
    public void mirrorBtnClicked() {
        if (isMirrorHidden) {
            showMirror();
        }
        if (!isMirrorOpen) {
            openMirror();
        } else {
            mirror.toggleHighlight();
        }
    }

    private void openMirror() {
        isMirrorOpen = true;
        mainRegion.getFreeSpace(mirror);
        mainRegion.addDraggable(mirror);
    }

    private void showMirror() {
        mirror.setVisible(true);
        isMirrorHidden = false;
        mainRegion.removeDraggable(mirror);
    }

    @Override
    public MirrorButton getMirrorButton() {
        return this.button;
    }

    @Override
    public void setName(String name) {
        this.button.setText(name);
        this.mirror.changeHeadName(name);
    }
}
