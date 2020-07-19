package osl2.visualizer.model.command.mapCommand;

import osl2.visualizer.model.VisualMap;
import osl2.visualizer.model.command.ICommand;

public class SetKeyValueCommand<K, V> implements ICommand {

	private final VisualMap visualMap;
	private final K key;
	private final V value;

	public SetKeyValueCommand(VisualMap visualMap, K key, V value) {
		this.visualMap = visualMap;
		this.key = key;
		this.value = value;
	}

	@Override
	public void execute() {
		this.visualMap.put(key, value);
	}
}
