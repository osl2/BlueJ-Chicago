package osl2.visualizer;

import bluej.extensions.BPackage;
import bluej.extensions.MenuGenerator;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuBuilder extends MenuGenerator {
    public JMenuItem getToolsMenuItem(BPackage aPackage) {
        return new JMenuItem(new ToolsAction("BlueJ Visualizer"));
    }

    private void show() {
        // TODO Start visuasizer here
        JOptionPane.showMessageDialog(null, "BlueJ Visualizer started!");
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
