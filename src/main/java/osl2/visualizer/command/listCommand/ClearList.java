package main.java.osl2.visualizer.command.listCommand;

import main.java.osl2.visualizer.command.ICommand;
import osl2.model.VisualList;

public class ClearList implements ICommand {

    private VisualList visualList;

    public ClearList(VisualList visualList){
        this.visualList = visualList;
    }

    @Override
    public void execute() {
        this.visualList.clear();
    }
}
