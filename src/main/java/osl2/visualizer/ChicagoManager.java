package osl2.visualizer;

import osl2.Chicago.ChicagoDatastructure;
import osl2.Chicago.VArray;
import osl2.visualizer.gui.MainView;
import osl2.visualizer.gui.controller.IMainController;

/**
 * Registers chicago datastructures created by the user.
 */
public class ChicagoManager {
	private static IMainController mainController;
	private static final Object MC_WAIT = new Object();


	public static void main(String[] args) {
		MainView.open();
		VArray<Integer> array= new VArray<Integer>(5);
	}


	/**
	 * Register the {@link IMainController}.
	 *
	 * @param regMainController - the IMainController to be registered
	 */
	public static void registerController(IMainController regMainController) {
		synchronized (MC_WAIT) {
			mainController = regMainController;
			MC_WAIT.notifyAll();
		}
	}

	/**
	 * Register a {@link ChicagoDatastructure}.
	 *
	 * @param chicagoDatastructure - the ChicagoDatastructure to be registered
	 */
	public static void registerDatastructure(ChicagoDatastructure chicagoDatastructure) {
		MainView.open();
		synchronized (MC_WAIT) {
			if (mainController == null) {
				try {
					MC_WAIT.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		mainController.registerDatastructure(chicagoDatastructure);
	}
}
