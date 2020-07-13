package osl2.visualizer.command.listCommand;

import osl2.visualizer.command.ICommand;
import osl2.model.VisualList;

public class RemoveListIndexCommand implements ICommand {

    private VisualList visualList;
    private int index;

    private RemoveListIndexCommand(VisualList visualList, int index){
        this.visualList = visualList;
        this.index = index;
    }
    @Override
    public void execute() {
        this.visualList.remove(index);
    }
}
