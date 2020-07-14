package osl2.visualizer.model.command.treeCommand;

import osl2.visualizer.model.command.ICommand;
import osl2.visualizer.model.VisualTree;
import osl2.visualizer.model.VisualNode;

public class SwapTreeCommand implements ICommand {

    private VisualTree visualTree;
    private VisualNode child;
    private VisualNode parent;

    public SwapTreeCommand(VisualTree visualTree, VisualNode child, VisualNode parent){
        this.visualTree = visualTree;
        this.child = child;
        this.parent = parent;
    }

    @Override
    public void execute() {
        this.visualTree.swap(child, parent);
    }
}
