package osl2.visualizer.model.command.graphCommand;

import osl2.visualizer.model.VisualGraph;
import osl2.visualizer.model.command.ICommand;

public class ClearGraphCommand implements ICommand {

	private final VisualGraph visualGraph;

	public ClearGraphCommand(VisualGraph visualGraph) {
		this.visualGraph = visualGraph;
	}

	@Override
	public void execute() {
		this.visualGraph.removeAll();
	}
}
