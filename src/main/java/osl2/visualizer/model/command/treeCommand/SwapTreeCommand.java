package osl2.visualizer.model.command.treeCommand;

import osl2.Chicago.VNode;
import osl2.visualizer.model.VisualTree;
import osl2.visualizer.model.command.ICommand;

public class SwapTreeCommand implements ICommand {

	private final VisualTree visualTree;
	private final VNode child;
	private final VNode parent;

	public SwapTreeCommand(VisualTree visualTree, VNode child, VNode parent) {
		this.visualTree = visualTree;
		this.child = child;
		this.parent = parent;
	}

	@Override
	public void execute() {
		this.visualTree.swap(child, parent);
	}
}