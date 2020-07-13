package main.java.osl2.visualizer.command.listCommand;

import main.java.osl2.visualizer.command.ICommand;
import osl2.model.VisualList;

public class AddListIndexCommand<T> implements ICommand {

    private VisualList visualList;
    private int index;
    private T value;

    public AddListIndexCommand(VisualList visualList, int index, T value){
        this.visualList = visualList;
        this.index = index;
        this.value = value;
    }

    @Override
    public void execute() {
        this.visualList.add(index, value);

    }
}
