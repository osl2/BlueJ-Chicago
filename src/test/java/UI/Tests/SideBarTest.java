package UI.Tests;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import org.junit.After;
import org.testfx.framework.junit.ApplicationTest;
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
import osl2.view.ui.EvanstonWindow;
import osl2.view.ui.PlaySpace;

import java.awt.geom.Point2D;

public class SideBarTest {




    public class PlayspaceTest extends ApplicationTest {

        private SideBar sideBar;
        private EvanstonWindow evanstonWindow;
        private Scene tmpScene;



        @Override public void start(Stage stage) {
            evanstonWindow = EvanstonWindow.getInstance();
            sideBar = evanstonWindow.getSideBar();
            Parent sceneRoot = sideBar;
            tmpScene = new Scene(sceneRoot, Screen.getPrimary().getBounds().getMaxX(), Screen.getPrimary().getBounds().getMaxY());
            stage.setScene(tmpScene);
            stage.show();
        }
        @After
        public void resetScene(){
            tmpScene.setRoot(new Pane());
        }
}}
