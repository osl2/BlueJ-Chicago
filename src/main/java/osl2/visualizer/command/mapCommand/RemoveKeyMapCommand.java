package osl2.visualizer.command.mapCommand;

import osl2.visualizer.command.ICommand;
import osl2.model.VisualMap;

public class RemoveKeyMapCommand<K> implements ICommand {

    private VisualMap visualMap;
    private K key;

    public RemoveKeyMapCommand(VisualMap visualMap, K key){
        this.visualMap = visualMap;
        this.key = key;
    }

    @Override
    public void execute() {
        this.visualMap.remove(key);
    }
}
