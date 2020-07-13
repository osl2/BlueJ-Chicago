package osl2.visualizer.model.command.arrayCommand;

import osl2.visualizer.model.VisualArray;
import osl2.visualizer.model.command.ICommand;

public class SetArrayCommand<T> implements ICommand {

    private VisualArray<T> visualArray;
    private int index;
    private T value;

    public SetArrayCommand(VisualArray<T> visualArray, int index, T value) {
        this.visualArray = visualArray;
        this.index = index;
        this.value = value;
    }


    @Override
    public void execute() {
        this.visualArray.setValue(index, value);
    }
}
