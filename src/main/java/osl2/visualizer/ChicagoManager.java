package osl2.visualizer;

import osl2.Chicago.ChicagoDatastructure;
import osl2.visualizer.gui.MainView;
import osl2.visualizer.gui.controller.IMainController;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Registers chicago datastructures created by the user.
 */
public class ChicagoManager {
	private static IMainController mainController;
	private static Queue<Runnable> pendingRegistrations = new LinkedList<>();


	public static void main(String[] args) {
		MainView.open();
	}


	/**
	 * Register the {@link IMainController}.
	 *
	 * @param regMainController - the IMainController to be registered
	 */
	public static void registerController(IMainController regMainController) {
		synchronized (pendingRegistrations) {
			mainController = regMainController;
			while (!pendingRegistrations.isEmpty()) {
				pendingRegistrations.poll().run();
			}
		}
	}

	/**
	 * Register a {@link ChicagoDatastructure}.
	 *
	 * @param chicagoDatastructure - the ChicagoDatastructure to be registered
	 */
	public static void registerDatastructure(ChicagoDatastructure chicagoDatastructure) {
		MainView.open();
		synchronized (pendingRegistrations) {
			if (mainController == null) {
				pendingRegistrations.add(() -> { mainController.registerDatastructure(chicagoDatastructure); });
			} else {
				mainController.registerDatastructure(chicagoDatastructure);
			}
		}
	}
}
