package osl2.visualizer.model.command.graphCommand;

import osl2.visualizer.model.command.ICommand;
import osl2.visualizer.model.VisualGraph;

public class ClearGraphCommand implements ICommand {

    private VisualGraph visualGraph;

    public ClearGraphCommand(VisualGraph visualGraph){
        this.visualGraph = visualGraph;
    }

    @Override
    public void execute() {
        this.visualGraph.removeAll();
    }
}
