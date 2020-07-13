package osl2.visualizer.model.command.listCommand;

import osl2.visualizer.model.command.ICommand;
import osl2.visualizer.model.VisualList;

public class SetListIndexCommand<T> implements ICommand {

    private VisualList visualList;
    private int index;
    private T value;

    public SetListIndexCommand(VisualList visualList, int index, T value){
        this.visualList = visualList;
        this.index = index;
        this.value = value;
    }

    @Override
    public void execute() {
        this.visualList.set(index, value);
    }
}
