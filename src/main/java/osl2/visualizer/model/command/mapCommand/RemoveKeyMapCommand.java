package osl2.visualizer.model.command.mapCommand;

import osl2.visualizer.model.VisualMap;
import osl2.visualizer.model.command.ICommand;

public class RemoveKeyMapCommand<K> implements ICommand {

    private final VisualMap visualMap;
    private final K key;

    public RemoveKeyMapCommand(VisualMap visualMap, K key) {
        this.visualMap = visualMap;
        this.key = key;
    }

    @Override
    public void execute() {
        this.visualMap.remove(key);
    }
}
