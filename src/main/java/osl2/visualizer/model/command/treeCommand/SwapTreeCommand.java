package osl2.visualizer.model.command.treeCommand;

import osl2.visualizer.model.command.ICommand;
import osl2.visualizer.model.VisualTree;
import osl2.Chicago.VNode;

public class SwapTreeCommand implements ICommand {

    private VisualTree visualTree;
    private VNode child;
    private VNode parent;

    public SwapTreeCommand(VisualTree visualTree, VNode child, VNode parent){
        this.visualTree = visualTree;
        this.child = child;
        this.parent = parent;
    }

    @Override
    public void execute() {
        this.visualTree.swap(child, parent);
    }
}
