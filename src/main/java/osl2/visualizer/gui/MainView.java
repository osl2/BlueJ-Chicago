package osl2.visualizer.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import osl2.visualizer.gui.controller.IMainController;
import osl2.visualizer.gui.mirror.MirrorButton;
import osl2.visualizer.gui.mirror.MirrorView;

public class MainView extends Application {
    private int vertical = 500;
    private int horizontal = 800;
    Scene scene;
    SplitPane verticalSplitter;
    SplitPane sidePlaySplitter;
    MainRegion mainRegion;
    SideBar sideBar;
    PlaySpace playSpace;
    StackPane layout;

    public MainView(IMainController mainController) {
        // TODO
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Visualizer");
        setUpSidePlaySplitter();
        setUpVerticalSplitter();
        setUpLayout();

        scene = new Scene(layout,horizontal, vertical);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void addMirrorButton(MirrorButton mirrorButton){
        sideBar.addMirrorButton(mirrorButton);
    }

    public void addMirrorView(MirrorView mirror){
        //mainRegion.addMirror(mirror);
    }


    private  void setUpLayout(){
        layout = new StackPane();
        layout.getChildren().add(verticalSplitter);
    }
    private void setUpVerticalSplitter(){
        mainRegion = new MainRegion();
        verticalSplitter = new SplitPane( sidePlaySplitter, mainRegion);
        verticalSplitter.setOrientation(Orientation.HORIZONTAL);
    }
    private void setUpSidePlaySplitter(){
        setUpSidebar();
        setUpPlaySpace();
        sidePlaySplitter = new SplitPane(sideBar, playSpace);
        sidePlaySplitter.setOrientation(Orientation.VERTICAL);
    }

    private void setUpSidebar(){
        sideBar = new SideBar();
    }
    private void setUpPlaySpace(){
        playSpace = new PlaySpace();
        playSpace.setPadding(new Insets(50,50,50,50));

    }

}
