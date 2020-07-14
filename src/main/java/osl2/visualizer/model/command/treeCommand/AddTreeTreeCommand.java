package osl2.visualizer.model.command.treeCommand;

import osl2.visualizer.model.command.ICommand;
import osl2.visualizer.model.VisualTree;
import osl2.visualizer.model.VisualNode;

public class AddTreeTreeCommand implements ICommand {

    private VisualTree visualTree;
    private VisualTree child;
    private VisualNode parent;

    public AddTreeTreeCommand(VisualTree visualTree, VisualTree child, VisualNode parent){
        this.visualTree = visualTree;
        this.child = child;
        this.parent = parent;
    }

    @Override
    public void execute() {
        this.visualTree.addTree(child, parent);
    }
}
