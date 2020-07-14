package osl2.visualizer.model.command.treeCommand;

import osl2.visualizer.model.command.ICommand;
import osl2.visualizer.model.VisualTree;
import osl2.visualizer.model.VisualNode;

public class AddChildTreeCommand implements ICommand {

    private  VisualNode child;
    private VisualNode parent;
    private VisualTree visualTree;

    public AddChildTreeCommand(VisualTree visualTree, VisualNode child, VisualNode parent){
        this.visualTree = visualTree;
        this.child = child;
        this.parent = parent;
    }
    @Override
    public void execute() {
        this.visualTree.addChild(child, parent);
    }
}
