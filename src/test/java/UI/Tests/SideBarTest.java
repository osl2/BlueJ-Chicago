package UI.Tests;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.junit.After;
import org.testfx.framework.junit.ApplicationTest;
import osl2.datastructures.VArray;
import osl2.view.ui.EvanstonWindow;
import osl2.view.ui.PlaySpace;
import osl2.view.ui.SideBar;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
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

    private SplitPane splitPane;
    private EvanstonWindow evanstonWindow;
    private Scene tmpScene;


    @Override
    public void start(Stage stage) {
        evanstonWindow = EvanstonWindow.getInstance();
        splitPane = evanstonWindow.getVerticalSplitter();
        Parent sceneRoot = splitPane;
        tmpScene = new Scene(sceneRoot, Screen.getPrimary().getBounds().getMaxX()/2, Screen.getPrimary().getBounds().getMaxY()/2);
        stage.setScene(tmpScene);
        stage.show();
    }

    @Test
    public void test1() {
        TestThread thread = new TestThread();
        thread.start();
    }

    @After
    public void resetScene() {
        tmpScene.setRoot(new Pane());
    }

    class TestThread extends Thread {
        public void run() {
            VArray<Integer> array = new VArray(5);
            array.setValue(1, 3);
            array.setValue(2, 4);
            array.setValue(3, 5);

        }
    }
}
