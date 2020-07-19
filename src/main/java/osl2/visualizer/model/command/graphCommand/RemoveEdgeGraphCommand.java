package osl2.visualizer.model.command.graphCommand;

import osl2.Chicago.VNode;
import osl2.visualizer.model.VisualGraph;
import osl2.visualizer.model.command.ICommand;

public class RemoveEdgeGraphCommand implements ICommand {

	private final VisualGraph visualGraph;
	private final VNode start;
	private final VNode end;

	public RemoveEdgeGraphCommand(VisualGraph visualGraph, VNode start, VNode end) {
		this.visualGraph = visualGraph;
		this.start = start;
		this.end = end;
	}

	@Override
	public void execute() {
		this.visualGraph.removeEdge(start, end);
	}
}
