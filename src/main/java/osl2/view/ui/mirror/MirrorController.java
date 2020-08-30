package osl2.view.ui.mirror;

import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.ui.MainRegion;
import osl2.view.ui.SideBar;
import osl2.view.ui.draggable.Floormat;

/**
 * The MirrorController controls one Mirror and one MirrorButton.
 */
public class MirrorController implements IMirrorController {
    private final MirrorButton button;
    private final Mirror mirror;
    private final MainRegion mainRegion;
    private boolean isMirrorOpen;
    private boolean isMirrorHidden;

    /**
     * Creates a new MirrorController.
     *
     * @param visualization
     *         The visualisation of the Mirror.
     * @param mainRegion
     *         The Mainregion where the Mirror will be in.
     * @param sideBar
     *         The Sidebar where the MirrorButtons will be in
     */
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
        this.getMirrorButton().setMirrorHiddenStyle();
    }

    @Override
    public void minOrMaxMirror() {
        mirror.toggle();
        mirror.changeMinMaxButton();
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

    /**
     * Opens the Mirror.
     */
    private void openMirror() {
        isMirrorOpen = true;
        mainRegion.getFreeSpace(mirror);
        mainRegion.addDraggable(mirror);
        this.getMirrorButton().setMirrorShowStyle();
    }

    /**
     * Shows the mirror.
     */
    private void showMirror() {
        mirror.setVisible(true);
        isMirrorHidden = false;
        mainRegion.removeDraggable(mirror);
    }

    @Override
    public MirrorButton getMirrorButton() {
        return this.button;
    }

    /**
     * Returns the Mirror. For testing.
     *
     * @return The Mirror.
     */
    public Mirror getMirror() {
        return this.mirror;
    }

    /**
     * Returns the IsMirrorOpen variable. For testing.
     *
     * @return isMirrorOpen.
     */
    public boolean getIsMirrorOpen() {
        return this.isMirrorOpen;
    }

    @Override
    public void setName(String name) {
        this.button.setText(name);
        this.mirror.changeHeadName(name);
    }

    @Override
    public void resizeMirrorX(double xOffset) {
        double mirrorWidth = this.mirror.getWidth();
        this.mirror.setWidth(mirrorWidth + xOffset);
    }

    @Override
    public void resizeMirrorY(double yOffset) {
        double mirrorHeight = this.mirror.getBodyHeight();
        this.mirror.setBodyHeight(mirrorHeight + yOffset);
    }
}
