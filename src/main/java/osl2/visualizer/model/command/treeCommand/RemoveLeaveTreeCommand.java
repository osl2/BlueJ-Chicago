package osl2.visualizer.model.command.treeCommand;

import osl2.visualizer.model.command.ICommand;
import osl2.visualizer.model.VisualTree;
import osl2.visualizer.model.VisualNode;

public class RemoveLeaveTreeCommand implements ICommand {

    private VisualTree visualTree;
    private VisualNode node;

    public RemoveLeaveTreeCommand(VisualTree visualTree, VisualNode node){
        this.visualTree = visualTree;
        this.node = node;
    }

    @Override
    public void execute() {
        this.visualTree.removeLeave(node);
    }
}
