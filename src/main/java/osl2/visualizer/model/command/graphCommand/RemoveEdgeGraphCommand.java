package osl2.visualizer.model.command.graphCommand;

import osl2.visualizer.model.command.ICommand;
import osl2.visualizer.model.VisualGraph;
import osl2.visualizer.model.VisualNode;

public class RemoveEdgeGraphCommand implements ICommand {

    private VisualGraph visualGraph;
    private VisualNode start;
    private VisualNode end;

    public RemoveEdgeGraphCommand(VisualGraph visualGraph, VisualNode start, VisualNode end){
        this.visualGraph = visualGraph;
        this.start = start;
        this.end = end;
    }

    @Override
    public void execute() {
        this.visualGraph.removeEdge(start,end);
    }
}
