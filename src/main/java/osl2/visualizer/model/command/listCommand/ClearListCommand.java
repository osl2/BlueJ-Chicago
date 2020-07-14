package osl2.visualizer.model.command.listCommand;

import osl2.visualizer.model.VisualList;
import osl2.visualizer.model.command.ICommand;

public class ClearListCommand implements ICommand {

    private final VisualList visualList;

    public ClearListCommand(VisualList visualList) {
        this.visualList = visualList;
    }

    @Override
    public void execute() {
        this.visualList.clear();
    }
}
