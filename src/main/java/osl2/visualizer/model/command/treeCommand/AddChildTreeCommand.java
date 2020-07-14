package osl2.visualizer.model.command.treeCommand;

import osl2.visualizer.model.command.ICommand;
import osl2.visualizer.model.VisualTree;
import osl2.Chicago.VNode;

public class AddChildTreeCommand implements ICommand {

    private VisualNode child;
    private VNode parent;
    private VNode visualTree;

    public AddChildTreeCommand(VisualTree visualTree, VNode child, VNode parent){
        this.visualTree = visualTree;
        this.child = child;
        this.parent = parent;
    }
    @Override
    public void execute() {
        this.visualTree.addChild(child, parent);
    }
}
