package osl2.visualizer.model.command.graphCommand;

import osl2.visualizer.model.command.ICommand;
import osl2.visualizer.model.VisualGraph;
import osl2.Chicago.VNode;

public class RemoveNodeGraphCommand implements ICommand {

    private VisualGraph visualGraph;
    private VNode node;

    public RemoveNodeGraphCommand(VisualGraph visualGraph, VNode node){
        this.visualGraph = visualGraph;
        this.node = node;
    }

    @Override
    public void execute() {
        this.visualGraph.removeNode(node);
    }
}
