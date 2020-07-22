package osl2.Chicago;

import osl2.visualizer.model.VisualArray;
import osl2.visualizer.model.VisualDatastructure;
import osl2.visualizer.model.command.arrayCommand.ClearArrayCommand;
import osl2.visualizer.model.command.arrayCommand.GetArrayAtIndexCommand;
import osl2.visualizer.model.command.arrayCommand.SetArrayCommand;

import java.util.Collection;

/**
 * Implementation of the {@link IArray} interface.
 * Functions as a facade for {@link VisualArray}.
 *
 * @param <T> - the datatype which is used by the array
 */
public class VArray<T> extends ChicagoDatastructure implements IArray<T> {

	private final VisualArray<T> wrapperArray;
	private final VisualArray<T> commandArray;

	public VArray(int size) {
		wrapperArray = new VisualArray<T>(size);
		commandArray = new VisualArray<T>(size);
	}

	@Override
	public boolean setValue(int index, T value) {
		getCommandManager().addCommand(new SetArrayCommand<T>(commandArray, index, value));
		return wrapperArray.setValue(index, value);
	}

	@Override
	public T getValue(int index) {
		getCommandManager().addCommand(new GetArrayAtIndexCommand(commandArray, index));
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

	@Override
	public boolean removeAll() {
		getCommandManager().addCommand(new ClearArrayCommand(commandArray));
		return wrapperArray.removeAll();
	}

	@Override
	public boolean isEmpty() {
		return wrapperArray.isEmpty();
	}

	@Override
	public VisualDatastructure getVisualDatastructure() {
		return commandArray;
	}
}
