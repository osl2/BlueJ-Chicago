package osl2.visualizer.model.command.treeCommand;

import osl2.Chicago.ITree;
import osl2.Chicago.VNode;
import osl2.visualizer.model.VisualTree;
import osl2.visualizer.model.command.ICommand;

public class AddTreeTreeCommand implements ICommand {

	private final VisualTree visualTree;
	private final ITree child;
	private final VNode parent;

	public AddTreeTreeCommand(VisualTree visualTree, ITree child, VNode parent) {
		this.visualTree = visualTree;
		this.child = child;
		this.parent = parent;
	}

	@Override
	public void execute() {
		this.visualTree.addTree(parent, child);
	}
}