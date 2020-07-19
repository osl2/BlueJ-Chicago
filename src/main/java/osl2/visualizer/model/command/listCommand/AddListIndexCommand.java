package osl2.visualizer.model.command.listCommand;

import osl2.visualizer.model.VisualList;
import osl2.visualizer.model.command.ICommand;

public class AddListIndexCommand<T> implements ICommand {

	private final VisualList visualList;
	private final int index;
	private final T value;

	public AddListIndexCommand(VisualList visualList, int index, T value) {
		this.visualList = visualList;
		this.index = index;
		this.value = value;
	}

	@Override
	public void execute() {
		this.visualList.add(index, value);

	}
}
