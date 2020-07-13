package osl2.visualizer.model.command.arrayCommand;

import osl2.visualizer.model.VisualArray;
import osl2.visualizer.model.command.ICommand;

public class ClearArrayCommand implements ICommand {

    private VisualArray visualArray;

    public ClearArrayCommand(VisualArray visualArray) {
        this.visualArray = visualArray;
    }

    @Override
    public void execute() {
        //this.visualArray.clear();
    }
}
