package osl2.visualizer.model.command.graphCommand;

import osl2.visualizer.model.command.ICommand;
import osl2.visualizer.model.VisualGraph;
import osl2.visualizer.model.VisualNode;
import osl2.visualizer.model.command.treeCommand.AddTreeTreeCommand;

public class AddNodeGraphCommand implements ICommand {

    private VisualGraph visualGraph;
    private VisualNode node;

    private AddNodeGraphCommand(VisualGraph visualGraph, VisualNode node){
        this.visualGraph = visualGraph;
        this.node = node;
    }

    @Override
    public void execute() {
        this.visualGraph.addNode(node);
    }
}
