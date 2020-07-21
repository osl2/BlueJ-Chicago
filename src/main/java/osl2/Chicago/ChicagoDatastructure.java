package osl2.Chicago;

import osl2.visualizer.model.VisualDatastructure;
import osl2.visualizer.model.command.ICommandManager;

/**
 * The interface for all chicago datastructures.
 */
public interface ChicagoDatastructure {

	/**
	 * Setting the CommandManager for an ChicagoDatastrucutre.
	 *
	 * @param commandManager - the CommandManager for the Datastructure
	 */
	void setCommandManager(ICommandManager commandManager);

	/**
	 * Return the {@link VisualDatastructure}.
	 *
	 * @return the VisualDatastructure
	 */
	VisualDatastructure getVisualDatastructure();
}
