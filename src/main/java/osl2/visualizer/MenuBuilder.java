package osl2.visualizer;

import bluej.extensions.BPackage;
import bluej.extensions.MenuGenerator;
import osl2.visualizer.gui.controller.IMainController;
import osl2.visualizer.gui.controller.MainController;
import osl2.visualizer.model.command.CommandManager;
import osl2.visualizer.model.command.ICommandManager;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuBuilder extends MenuGenerator {
    public JMenuItem getToolsMenuItem(BPackage aPackage) {
        return new JMenuItem(new ToolsAction("BlueJ Visualizer"));
    }

    private void show() {
        ICommandManager commandManager = new CommandManager();
        IMainController mainController = new MainController(commandManager);
    }

    class ToolsAction extends AbstractAction {
        ToolsAction(String menuName) {
            putValue(AbstractAction.NAME, menuName);
        }

        public void actionPerformed(ActionEvent anEvent) {
            show();
        }
    }
}
