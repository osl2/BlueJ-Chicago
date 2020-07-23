package osl2.visualizer.gui;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import osl2.visualizer.gui.controller.IMainController;
import osl2.visualizer.gui.controller.MainController;
import osl2.visualizer.gui.mirror.MirrorButton;
import osl2.visualizer.gui.mirror.MirrorView;

import java.util.concurrent.CountDownLatch;

public class MainView extends Application {
	private IMainController mainController;	// Technically final, but initialized later
	private final int vertical = 500;
	private final int horizontal = 800;
	Scene scene;
	SplitPane verticalSplitter;
	SplitPane sidePlaySplitter;
	MainRegion mainRegion;
	SideBar sideBar;
	PlaySpace playSpace;
	StackPane layout;

	public static final CountDownLatch latch = new CountDownLatch(1);
	public static MainView mainView = null;

	public static MainView waitForStartUpTest() {
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return mainView;
	}

	public static void setMainView(MainView mainViewNew) {
		mainView = mainViewNew;
		latch.countDown();
	}

	public MainView() {
		setMainView(this);
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

	private static Thread APP_THREAD = null;
	public static void open() {
		if (APP_THREAD == null) {
			APP_THREAD = new Thread(new Runnable() {
				@Override
				public void run() {
					Application.launch(MainView.class);
				}
			});
			APP_THREAD.start();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Visualizer");
		setUpSidePlaySplitter();
		setUpVerticalSplitter();
		setUpLayout();

		scene = new Scene(layout, horizontal, vertical);
		scene.getStylesheets().add("style.css");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void setMainController(IMainController mainController) {
		this.mainController = mainController;
	}

	public void addMirrorButton(MirrorButton mirrorButton) {
		sideBar.addMirrorButton(mirrorButton);
	}

	public void addMirrorView(MirrorView mirrorView) {
		mainRegion.addMirrorView(mirrorView);
	}

	private void setUpLayout() {
		layout = new StackPane();
		layout.getChildren().add(verticalSplitter);
	}

	private void setUpVerticalSplitter() {
		mainRegion = new MainRegion();
		verticalSplitter = new SplitPane(sidePlaySplitter, mainRegion);
		verticalSplitter.setOrientation(Orientation.HORIZONTAL);
	}

	private void setUpSidePlaySplitter() {
		setUpSidebar();
		playSpace = new PlaySpace();
		playSpace.linkControllerToBtns(mainController);
		sidePlaySplitter = new SplitPane(sideBar, playSpace);
		sidePlaySplitter.setOrientation(Orientation.VERTICAL);
	}


	private void setUpSidebar() {
		sideBar = new SideBar();
	}
}
