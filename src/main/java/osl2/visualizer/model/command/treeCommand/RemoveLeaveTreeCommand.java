package osl2.visualizer.model.command.treeCommand;

import osl2.visualizer.model.command.ICommand;
import osl2.visualizer.model.VisualTree;
import osl2.Chicago.VNode;

public class RemoveLeaveTreeCommand implements ICommand {

    private VisualTree visualTree;
    private VNode node;

    public RemoveLeaveTreeCommand(VisualTree visualTree, VNode node){
        this.visualTree = visualTree;
        this.node = node;
    }

    @Override
    public void execute() {
        this.visualTree.removeLeave(node);
    }
}
