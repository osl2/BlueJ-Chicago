package main.java.osl2.visualizer.command.arrayCommand;
import main.java.osl2.visualizer.command.ICommand;
import osl2.model.VisualArray;

public class SetArrayCommand<T> implements ICommand {

    private VisualArray<T> visualArray;
    private int index;
    private T value;
    public SetArrayCommand(VisualArray<T> visualArray, int index, T value){
        this.visualArray = visualArray;
        this.index = index;
        this.value = value;
    }


    @Override
    public void execute() {
        this.visualArray.setValue(index, value);
    }
}
