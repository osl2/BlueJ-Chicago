package UI.Tests.MainRegion;

import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseButton;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.junit.Assert;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import osl2.view.datastructures.sequential.GuiArray;
import osl2.view.ui.EvanstonWindow;
import osl2.view.ui.mirror.Mirror;
import osl2.view.ui.mirror.MirrorButton;
import osl2.view.ui.mirror.MirrorController;

public class MainRegionResizeWidth extends ApplicationTest {

    private SplitPane splitPane;
    private EvanstonWindow evanstonWindow;
    private Scene tmpScene;
    private MirrorController controller;
    private MirrorButton mirrorButton;
    private Mirror mirror;


    @Override public void start(Stage stage) {
        evanstonWindow = EvanstonWindow.getInstance();
        splitPane = evanstonWindow.getVerticalSplitter();
        Parent sceneRoot = splitPane;
        tmpScene = new Scene(sceneRoot, Screen.getPrimary().getBounds().getMaxX(), Screen.getPrimary().getBounds().getMaxY());
        stage.setScene(tmpScene);
        stage.show();
        controller= new MirrorController(new GuiArray(), evanstonWindow.getMainRegion(), evanstonWindow.getSideBar());
        mirrorButton = controller.getMirrorButton();
        mirror = controller.getMirror();
    }

    @Test
    public void resizeMirrorWidth(){
        clickOn(point(mirrorButton.getLayoutX() + 5,mirrorButton.getLayoutY()));
        Bounds bound = mirror.getResizeButton().getBoundsInParent();
        double oldWidth = mirror.getWidth();
        moveTo(point(bound.getCenterX() + mirror.getLayoutX() + mirror.getButtons().getLayoutX() + evanstonWindow.getSideBar().getWidth(), mirror.getLayoutY()));
        press(MouseButton.PRIMARY);
        moveTo(point(bound.getCenterX() + mirror.getLayoutX() + mirror.getButtons().getLayoutX() + evanstonWindow.getSideBar().getWidth() + 100, mirror.getLayoutY()));
        release(MouseButton.PRIMARY);
        System.out.println(oldWidth);
        System.out.println(mirror.getWidth());
        Assert.assertTrue(oldWidth + 100 == mirror.getWidth());
    }
}
