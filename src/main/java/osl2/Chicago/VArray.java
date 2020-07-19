package osl2.Chicago;

import osl2.visualizer.model.VisualArray;
import osl2.visualizer.model.command.CommandManager;
import osl2.visualizer.model.command.ICommandManager;
import osl2.visualizer.model.command.arrayCommand.GetArrayAtIndexCommand;
import osl2.visualizer.model.command.arrayCommand.SetArrayCommand;

import java.util.Collection;

public class VArray<T> implements IArray<T>, IDatastructure {

	private final VisualArray<T> wrapperArray;
	private final VisualArray<T> commandArray;
	private final ICommandManager commandManager;

	public VArray(int size) {
		wrapperArray = new VisualArray<T>(size);
		commandArray = new VisualArray<T>(size);
		commandManager = new CommandManager();
	}

	@Override
	public boolean setValue(int index, T value) {
		commandManager.addCommand(new SetArrayCommand<T>(commandArray, index, value));
		return wrapperArray.setValue(index, value);
	}

	@Override
	public T getValue(int index) {
		commandManager.addCommand(new GetArrayAtIndexCommand(commandArray, index));
		return wrapperArray.getValue(index);
	}

	@Override
	public boolean contains(T value) {
		return wrapperArray.contains(value);
	}

	@Override
	public boolean contains(Collection<T> values) {
		return wrapperArray.contains(values);
	}

	@Override
	public int size() {
		return wrapperArray.size();
	}

	// TODO Fix
	@Override
	public boolean removeAll() {
//		return wrapperArray.removeAll();
		return true;
	}

	// TODO Fix
	@Override
	public boolean isEmpty() {
//		return wrapperArray.isEmpty();
		return true;
	}
}
