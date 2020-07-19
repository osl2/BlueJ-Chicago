package osl2.visualizer.model.command.listCommand;

import osl2.visualizer.model.VisualList;
import osl2.visualizer.model.command.ICommand;

public class RemoveListIndexCommand implements ICommand {

	private final VisualList visualList;
	private final int index;

	private RemoveListIndexCommand(VisualList visualList, int index) {
		this.visualList = visualList;
		this.index = index;
	}

	@Override
	public void execute() {
		this.visualList.remove(index);
	}
}
