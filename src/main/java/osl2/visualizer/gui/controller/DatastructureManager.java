package osl2.visualizer.gui.controller;

import osl2.Chicago.ChicagoDatastructure;

/**
 * Registers chicago datastructures created by the user.
 */
public class DatastructureManager {
	private static IMainController mainController;

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
