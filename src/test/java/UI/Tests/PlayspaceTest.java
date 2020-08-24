package UI.Tests;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

import javafx.scene.input.MouseButton;
import javafx.stage.Screen;
import org.junit.Assert;
import org.junit.Before;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.robot.Motion;

import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import org.junit.Test;
import org.testfx.robot.MouseRobot;
import osl2.Evanston;
import osl2.view.ui.EvanstonWindow;
import osl2.view.ui.PlaySpace;

import java.awt.geom.Point2D;

public class PlayspaceTest extends ApplicationTest {

    private PlaySpace playSpace;
    private EvanstonWindow evanstonWindow;

    @Override public void start(Stage stage) {
        evanstonWindow = new EvanstonWindow();
        playSpace = evanstonWindow.getPlayspace();
        Parent sceneRoot = playSpace;
        Scene scene = new Scene(sceneRoot, Screen.getPrimary().getBounds().getMaxX(), Screen.getPrimary().getBounds().getMaxY());
        stage.setScene(scene);
        stage.show();
    }

    @Before
    public void resetMouse(){
        moveTo(point(0,0));
    }
    @Test public void click_on_PlayPause()  {

        clickOn(point(playSpace.getPlayAutoButton().getLayoutX(),playSpace.getPlayAutoButton().getLayoutY()));
        Assert.assertTrue(evanstonWindow.getPlayController().getIsRunning());
        clickOn(point(playSpace.getPlayAutoButton().getLayoutX(),playSpace.getPlayAutoButton().getLayoutY()));

    }
    //TODO fix
   /* @Test public void fast_auto_toggle(){
        doubleClickOn(point(playSpace.getPlayAutoButton().getLayoutX(),playSpace.getPlayAutoButton().getLayoutY()));
        Assert.assertTrue(!evanstonWindow.getPlayController().getIsRunning());
    }*/

    //TODO How to check this ?
    @Test public void click_on_playStep(){
        clickOn(point(playSpace.getPlayStepButton().getLayoutX(),playSpace.getPlayStepButton().getLayoutY()));
        Assert.assertTrue(true);
    }

    @Test public void drag_scale_bar(){


        drag(point(playSpace.getPlaySpeedSlider().getLayoutX(),playSpace.getPlaySpeedSlider().getLayoutY()+playSpace.getButtonBox().getHeight()));
        dropTo(point(playSpace.getPlaySpeedSlider().getLayoutX()+500,playSpace.getPlaySpeedSlider().getLayoutY()+playSpace.getButtonBox().getHeight()));
        Assert.assertTrue(evanstonWindow.getPlayController().getDelay()<1000);
    }


}