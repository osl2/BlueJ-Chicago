package osl2.visualizer;

import javafx.application.Application;
import osl2.Chicago.ChicagoDatastructure;
import osl2.visualizer.gui.MainView;
import osl2.visualizer.gui.controller.IMainController;

/**
 * Registers chicago datastructures created by the user.
 */
public class ChicagoManager {
	private static IMainController mainController;

	static {
		main(null);
	}

	public static void main(String[] args) {
		MainView.open();
	}

	/**
	 * Register the {@link IMainController}.
	 *
	 * @param regMainController - the IMainController to be registered
	 */
	public static void registerController(IMainController regMainController) {
		mainController = regMainController;
	}

	/**
	 * Register a {@link ChicagoDatastructure}.
	 *
	 * @param chicagoDatastructure - the ChicagoDatastructure to be registered
	 */
	public static void registerDatastructure(ChicagoDatastructure chicagoDatastructure) {
		mainController.registerDatastructure(chicagoDatastructure);
	}
}
