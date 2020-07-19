package osl2.visualizer.model.command.graphCommand;

import osl2.Chicago.VNode;
import osl2.visualizer.model.VisualGraph;
import osl2.visualizer.model.command.ICommand;

public class RemoveNodeGraphCommand implements ICommand {

	private final VisualGraph visualGraph;
	private final VNode node;

	public RemoveNodeGraphCommand(VisualGraph visualGraph, VNode node) {
		this.visualGraph = visualGraph;
		this.node = node;
	}

	@Override
	public void execute() {
		this.visualGraph.removeNode(node);
	}
}
