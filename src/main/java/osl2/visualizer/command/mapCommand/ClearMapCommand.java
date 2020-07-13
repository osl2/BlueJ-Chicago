package osl2.visualizer.command.mapCommand;

import osl2.visualizer.command.ICommand;
import osl2.visualizer.model.VisualMap;

public class ClearMapCommand  implements ICommand {

    private VisualMap visualMap;

    public ClearMapCommand(VisualMap visualMap){
        this.visualMap = visualMap;
    }
    @Override
    public void execute() {
        this.visualMap.clear();
    }
}
