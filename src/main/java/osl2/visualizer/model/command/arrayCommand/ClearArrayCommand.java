package osl2.visualizer.model.command.arrayCommand;

import osl2.visualizer.model.command.ICommand;
import osl2.visualizer.model.VisualArray;

public class ClearArrayCommand implements ICommand {

    private VisualArray visualArray;

    public ClearArrayCommand(VisualArray visualArray){
        this.visualArray = visualArray;
    }

    @Override
    public void execute() {
        //this.visualArray.clear();
    }
}
