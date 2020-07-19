package osl2.visualizer.model.command.listCommand;

import osl2.visualizer.model.VisualList;
import osl2.visualizer.model.command.ICommand;

public class GetListAtIndexCommand implements ICommand {

	private final VisualList visualList;
	private final int index;

	public GetListAtIndexCommand(VisualList visualList, int index) {
		this.visualList = visualList;
		this.index = index;
	}

	@Override
	public void execute() {
		this.visualList.get(index);
	}
}
