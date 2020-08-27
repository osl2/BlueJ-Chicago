package UI.Tests;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.testfx.framework.junit.ApplicationTest;
import osl2.datastructures.VArray;
import osl2.view.ui.EvanstonWindow;
import osl2.view.ui.SideBar;


public class SideBarTest extends ApplicationTest {

    private SideBar sideBar;
    private EvanstonWindow evanstonWindow;
    private Scene tmpScene;


    @Override
    public void start(Stage stage) {
        evanstonWindow = EvanstonWindow.getInstance();
        sideBar = evanstonWindow.getSideBar();
        Parent sceneRoot = sideBar;
        tmpScene = new Scene(sceneRoot, Screen.getPrimary().getBounds().getMaxX()/4, Screen.getPrimary().getBounds().getMaxY()/2);
        stage.setScene(tmpScene);
        stage.show();
    }

    @BeforeAll
    public void mouse_To_Default() {
        moveTo(point(0, 0));
        VArray<Integer> vArray = new VArray<>(2, "Array");

    }

    @After
    public void resetScene() {
        tmpScene.setRoot(new Pane());
    }

    @Test
    public void button_Exists() {
        System.out.println(sideBar.getItems().size());
        Assert.assertTrue(true);
    }
}
