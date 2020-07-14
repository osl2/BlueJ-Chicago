package osl2.visualizer.model.command.graphCommand;

import osl2.visualizer.model.command.ICommand;
import osl2.visualizer.model.VisualGraph;
import osl2.visualizer.model.VisualNode;

public class RemoveNodeGraphCommand implements ICommand {

    private VisualGraph visualGraph;
    private VisualNode node;

    public RemoveNodeGraphCommand(VisualGraph visualGraph, VisualNode node){
        this.visualGraph = visualGraph;
        this.node = node;
    }

    @Override
    public void execute() {
        this.visualGraph.removeNode(node);
    }
}
