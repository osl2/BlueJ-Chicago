package osl2.visualizer.model.command.arrayCommand;

import osl2.visualizer.model.VisualArray;
import osl2.visualizer.model.command.ICommand;

public class GetArrayAtIndexCommand implements ICommand {

	private final VisualArray visualArray;
	private final int index;

	public GetArrayAtIndexCommand(VisualArray visualArray, int index) {
		this.visualArray = visualArray;
		this.index = index;
	}

	@Override
	public void execute() {
		this.visualArray.getValue(index);
	}
}
