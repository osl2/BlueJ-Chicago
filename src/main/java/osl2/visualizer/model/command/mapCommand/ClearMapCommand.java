package osl2.visualizer.model.command.mapCommand;

import osl2.visualizer.model.VisualMap;
import osl2.visualizer.model.command.ICommand;

public class ClearMapCommand implements ICommand {

    private VisualMap visualMap;

    public ClearMapCommand(VisualMap visualMap) {
        this.visualMap = visualMap;
    }

    @Override
    public void execute() {
        this.visualMap.clear();
    }
}
