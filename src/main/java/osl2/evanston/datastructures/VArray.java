package osl2.evanston.datastructures;

import osl2.evanston.datastructures.interfaces.IArray;
import osl2.evanston.messaging.datastructures.VArrayCommunication;
import osl2.evanston.view.datastructures.DatastructureVisualization;
import osl2.evanston.view.datastructures.GUIArray;

public class VArray<T> extends EvanstonDatastructure<VArrayCommunication<T>> implements IArray<T> {
    private final T[] values;

    public int size() {
        return values.length;
    }

    public T getValue(int index) {
        return values[index];
    }

    public void setValue(int index, T value) {
        values[index] = value;
        getBroadcaster().send((b) -> b.setValue(index, value));
    }

    @Override
    public DatastructureVisualization createVisualization() {
        return new GUIArray<T>();
    }

    public VArray(int size) {
        this.values = (T[]) new Object[size];
        getBroadcaster().send((b) -> b.setSize(size));
    }
}
