package osl2.visualizer.gui.controller;

import javafx.stage.Stage;
import osl2.Chicago.ChicagoDatastructure;
import osl2.visualizer.ChicagoManager;
import osl2.visualizer.gui.MainView;
import osl2.visualizer.gui.mirror.IMirrorController;
import osl2.visualizer.gui.mirror.MirrorController;
import osl2.visualizer.model.VisualDatastructure;
import osl2.visualizer.model.command.CommandManager;
import osl2.visualizer.model.command.ICommandManager;

/**
 * Implementation of the {@link IMainController} of MVC.
 */
public class MainController implements IMainController {
	private final MainView mainView;
	private final ICommandManager commandManager;

	private boolean isPlaying = false;

	/**
	 * Create a new MainController.
	 *
	 * @param view - a reference to the {@link MainView} instance
	 */
	public MainController(MainView view) {
		this.mainView = view;
		this.commandManager = new CommandManager();
		ChicagoManager.registerController(this);
	}

	@Override
	public void setPlayspeed(int playspeed) {
		commandManager.setPlayspeed(playspeed);
	}

	@Override
	public void playOrPause() {
		if (isPlaying) {
			commandManager.stopAutoPlay();
			isPlaying = false;
		} else {
			commandManager.startAutoPlay();
			isPlaying = true;
		}
	}

	@Override
	public void playStep() {
		commandManager.playStep();
	}

	@Override
	public void registerDatastructure(ChicagoDatastructure chicagoDatastructure) {
		chicagoDatastructure.setCommandManager(commandManager);
		VisualDatastructure visualDatastructure = chicagoDatastructure.getVisualDatastructure();

		IMirrorController mirrorController = new MirrorController(visualDatastructure);
		mainView.addMirrorButton(mirrorController.getMirrorButton());
		mainView.addMirrorView(mirrorController.getMirrorView());
	}
}
