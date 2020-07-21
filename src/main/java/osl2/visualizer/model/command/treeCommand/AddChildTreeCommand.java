package osl2.visualizer.model.command.treeCommand;

import osl2.Chicago.VNode;
import osl2.visualizer.model.VisualTree;
import osl2.visualizer.model.command.ICommand;

public class AddChildTreeCommand implements ICommand {

	private final VNode child;
	private final VNode parent;
	private final VisualTree visualTree;

	public AddChildTreeCommand(VisualTree visualTree, VNode child, VNode parent) {
		this.visualTree = visualTree;
		this.child = child;
		this.parent = parent;
	}

	@Override
	public void execute() {
		this.visualTree.addChild(child, parent);
	}
}
