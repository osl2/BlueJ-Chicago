package osl2.Chicago;

import osl2.visualizer.model.command.ICommandManager;

/**
 * The interface for all chicago datastructures.
 */
public interface ChicagoDatastructure {

    /**
     *Setting the CommandManager for an ChicagoDatastrucutre.
     *@param commandManager the Commandmanger for the Datastructure
     */
    public void  setCommandManager(ICommandManager commandManager);
}
