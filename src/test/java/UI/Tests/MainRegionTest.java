package UI.Tests;

import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Assert;
import org.testfx.framework.junit.ApplicationTest;
import osl2.datastructures.VArray;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.datastructures.GUIGraph;
import osl2.view.datastructures.sequential.GUIArray;
import osl2.view.ui.EvanstonWindow;
import osl2.view.ui.PlaySpace;
import org.junit.Test;
import org.junit.After;
import osl2.view.ui.mirror.Mirror;
import osl2.view.ui.mirror.MirrorButton;
import osl2.view.ui.mirror.MirrorController;

public class MainRegionTest extends ApplicationTest {

    private SplitPane splitPane;
    private EvanstonWindow evanstonWindow;
    private Scene tmpScene;
    MirrorController controller;
    MirrorButton mirrorButton;
    Mirror mirror;

    @Override public void start(Stage stage) {
        evanstonWindow = EvanstonWindow.getInstance();
        splitPane = evanstonWindow.getVerticalSplitter();
        Parent sceneRoot = splitPane;
        tmpScene = new Scene(sceneRoot, Screen.getPrimary().getBounds().getMaxX(), Screen.getPrimary().getBounds().getMaxY());
        stage.setScene(tmpScene);
        stage.show();
        controller = new MirrorController(new GUIArray(), evanstonWindow.getMainRegion(), evanstonWindow.getSideBar());
        mirrorButton = controller.getMirrorButton();
        mirror = controller.getMirror();
    }


    @Test public void openMirror(){
        clickOn(point(mirrorButton.getLayoutX() + 5,mirrorButton.getLayoutY()));
        Assert.assertTrue(controller.getIsMirrorOpen());
    }

    @Test public void highlightMirror(){
        doubleClickOn(point(mirrorButton.getLayoutX() + 5,mirrorButton.getLayoutY()));
        Assert.assertTrue(mirror.getIsHighlighted());
    }

    @Test public void moveMirror(){
        clickOn(point(mirrorButton.getLayoutX() + 5,mirrorButton.getLayoutY()));
        moveTo(point(mirror.getLayoutX() + evanstonWindow.getSideBar().getWidth() +10, mirror.getLayoutY()));
        double oldX = mirror.getLayoutX();
        double oldY = mirror.getLayoutY();
        System.out.println("OldX " + oldX);
        System.out.println("OldY " + oldY);
        System.out.println("NewX " + mirror.getLayoutX());
        System.out.println("NewY " + mirror.getLayoutY());
        press(MouseButton.PRIMARY);
        moveTo(point(oldX+ evanstonWindow.getSideBar().getWidth() +100, oldY +100));
        release(MouseButton.PRIMARY);
        System.out.println("OldOldX " + oldX);
        System.out.println("OldOldY " + oldY);
        System.out.println("NewNewX " + mirror.getLayoutX());
        System.out.println("NewNewY " + mirror.getLayoutY());
        //+90, because the mouse was moved 10 points to the right.
        Assert.assertTrue((mirror.getLayoutX()  == oldX + 90) && mirror.getLayoutY() == oldY +100);

    }

    @After
    public void resetScene() {
        tmpScene.setRoot(new Pane());
    }
}
