package UI.Tests;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.robot.Motion;

import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.junit.Test;
import org.testfx.robot.MouseRobot;
import osl2.Evanston;
import osl2.datastructures.VArray;
import osl2.view.ui.EvanstonWindow;
import osl2.view.ui.PlaySpace;

import java.awt.geom.Point2D;

public class PlayspaceTest extends ApplicationTest {

    private PlaySpace playSpace;
    private EvanstonWindow evanstonWindow;
    private Scene tmpScene;
    private TestThread thread;
    final int x = 0;



    @Override public void start(Stage stage) {
        evanstonWindow = EvanstonWindow.getInstance();
        playSpace = evanstonWindow.getPlayspace();
        Parent sceneRoot = playSpace;
        tmpScene = new Scene(sceneRoot, Screen.getPrimary().getBounds().getMaxX(), Screen.getPrimary().getBounds().getMaxY());
        stage.setScene(tmpScene);
        stage.show();
    }


    @Before
    public void resetMouse(){
        moveTo(point(0,0));
    }

    @After
    public void resetScene(){
        tmpScene.setRoot(new Pane());
    }

    @Test public void click_on_PlayPause()  {
        clickOn(point(playSpace.getPlayAutoButton().getLayoutX(),playSpace.getPlayAutoButton().getLayoutY()));
        Assert.assertTrue(evanstonWindow.getPlayController().getIsRunning());
        clickOn(point(playSpace.getPlayAutoButton().getLayoutX(),playSpace.getPlayAutoButton().getLayoutY()));

    }

        @Test public void fast_auto_toggle(){
        doubleClickOn(point(playSpace.getPlayAutoButton().getLayoutX(),playSpace.getPlayAutoButton().getLayoutY()));
        Assert.assertTrue(!evanstonWindow.getPlayController().getIsRunning());
    }

    @Test public void click_on_playStep(){
        thread = new TestThread();
        thread.start();
        boolean setCorrectly = true;

        clickOn(point(playSpace.getPlayStepButton().getLayoutX(),playSpace.getPlayStepButton().getLayoutY()));
        if(!thread.getArray().getValue(0).equals(3)){
            setCorrectly = false;
        }
        moveTo(point(0,0));
        clickOn(point(playSpace.getPlayStepButton().getLayoutX(),playSpace.getPlayStepButton().getLayoutY()));
        if(!thread.getArray().getValue(1).equals(22)){
            setCorrectly = false;
        }
        moveTo(point(0,0));
        clickOn(point(playSpace.getPlayStepButton().getLayoutX(),playSpace.getPlayStepButton().getLayoutY()));
        if(!thread.getArray().getValue(2).equals(8)){
            setCorrectly = false;
        }

        Assert.assertTrue(setCorrectly);
    }

    class TestThread extends Thread {
        VArray<Integer> array;
        public void run() {
            array = new VArray(5);
            set();
        }
        public void set(){
            array.setValue(0,3);
            array.setValue(1,22);
            array.setValue(2,8);
        }
        public VArray getArray(){
            return array;
        }

    }



    @Test public void drag_scale_bar(){


        drag(point(playSpace.getPlaySpeedSlider().getLayoutX(),playSpace.getPlaySpeedSlider().getLayoutY()+playSpace.getButtonBox().getHeight()));
        dropTo(point(playSpace.getPlaySpeedSlider().getLayoutX()+(playSpace.getPlaySpeedSlider().getWidth()/2),playSpace.getPlaySpeedSlider().getLayoutY()+playSpace.getButtonBox().getHeight()));
        Assert.assertTrue(evanstonWindow.getPlayController().getDelay()<600);
    }




}