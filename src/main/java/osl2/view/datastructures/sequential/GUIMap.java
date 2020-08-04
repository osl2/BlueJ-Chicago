package osl2.view.datastructures.sequential;

import osl2.messaging.datastructures.VMapCommunication;
import osl2.view.inlinerepresentation.InlineRepresentation;
import osl2.view.ui.mirror.IMirrorController;

import java.util.ArrayList;
import java.util.List;

public class GUIMap<K, V> extends GUISequential implements VMapCommunication<K, V> {

    private final List<Object> keys = new ArrayList<>();

    public GUIMap() {
        super("Key", "Value");
    }

    @Override
    public String getName() {
        return "Map";
    }




    @Override
    public void put(K key, V value) {
        int index = keys.indexOf(key);
        if (index >= 0) {
            putElement(index, InlineRepresentation.get(key), InlineRepresentation.get(value));
        } else {
            keys.add(key);
            putElement(keys.size() - 1, InlineRepresentation.get(key), InlineRepresentation.get(value));
        }
    }

    @Override
    public void remove(Object key) {
        int index = keys.indexOf(key);
        if (index >= 0) {
            keys.remove(index);
            removeElement(index);
        }
    }

    @Override
    public void clear() {
        clearElements();
    }


}
