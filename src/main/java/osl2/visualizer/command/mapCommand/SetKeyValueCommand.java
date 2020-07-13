package main.java.osl2.visualizer.command.mapCommand;

import main.java.osl2.visualizer.command.ICommand;
import osl2.model.VisualMap;

public class SetKeyValueCommand<K, V> implements ICommand {

    private VisualMap visualMap;
    private K key;
    private V value;

    public SetKeyValueCommand(VisualMap visualMap, K key, V value){
        this.visualMap = visualMap;
        this.key = key;
        this.value = value;
    }

    @Override
    public void execute() {
        this.visualMap.put(key, value);
    }
}
