package osl2.visualizer.model.command.treeCommand;

import osl2.visualizer.model.VisualTree;
import osl2.visualizer.model.command.ICommand;

public class RemoveTreeCommand implements ICommand {

	private final VisualTree visualTree;

	public RemoveTreeCommand(VisualTree visualTree) {
		this.visualTree = visualTree;
	}

	@Override
	public void execute() {
		this.visualTree.removeAll();
	}
}
