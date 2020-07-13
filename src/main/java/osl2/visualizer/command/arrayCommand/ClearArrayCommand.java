package main.java.osl2.visualizer.command.arrayCommand;

import main.java.osl2.visualizer.command.ICommand;
import osl2.model.VisualArray;

public class ClearArrayCommand implements ICommand {

    private VisualArray visualArray;

    public ClearArrayCommand(VisualArray visualArray){
        this.visualArray = visualArray;
    }

    @Override
    public void execute() {
        this.visualArray.clear();
    }
}
