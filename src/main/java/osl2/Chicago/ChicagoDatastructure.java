package osl2.Chicago;

import osl2.visualizer.ChicagoManager;
import osl2.visualizer.model.VisualDatastructure;
import osl2.visualizer.model.command.ICommandManager;

/**
 * The interface for all chicago datastructures.
 */
public abstract class ChicagoDatastructure {
	private ICommandManager commandManager;

	public ChicagoDatastructure() {
		ChicagoManager.registerDatastructure(this);
	}

	/**
	 * Get the CommandManager
	 */
	protected ICommandManager getCommandManager() {
		return commandManager;
	}

	/**
	 * Setting the CommandManager for an ChicagoDatastrucutre.
	 *
	 * @param commandManager - the CommandManager for the Datastructure
	 */
	public void setCommandManager(ICommandManager commandManager) {
		this.commandManager = commandManager;
	}

	/**
	 * Return the {@link VisualDatastructure}.
	 *
	 * @return the VisualDatastructure
	 */
	public abstract VisualDatastructure getVisualDatastructure();
}
