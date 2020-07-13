package osl2.visualizer.model.command.listCommand;

import osl2.visualizer.model.command.ICommand;
import osl2.visualizer.model.VisualList;

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
