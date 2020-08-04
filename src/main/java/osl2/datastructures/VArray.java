package osl2.datastructures;

import osl2.datastructures.interfaces.IArray;
import osl2.messaging.datastructures.VArrayCommunication;
import osl2.messaging.errorHandling.ArrayIndexOutOfBoundsError;
import osl2.messaging.errorHandling.UserError;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.datastructures.sequential.GUIArray;

import java.util.Collection;

public class VArray<T> extends EvanstonDatastructure<VArrayCommunication<T>> implements IArray<T> {
    private final T[] values;
    private final int size;

    public VArray(int size) {
        this.size = size;
        this.values = (T[]) new Object[size];
        getBroadcaster().send((b) -> b.setSize(size));
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public boolean removeAll() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    public T getValue(int index) {
        return values[index];
    }

    @Override
    public boolean contains(T value) {
        return false;
    }

    @Override
    public boolean contains(Collection<T> values) {
        return false;
    }

    @Override
    public boolean setValue(int index, T value) {
        if (index < 0 || index > this.size) {
            UserError userError = new ArrayIndexOutOfBoundsError(index, size);
            getBroadcaster().sendWithDelay((b) -> b.handleError(userError));
            return false;
        }

        values[index] = value;
        getBroadcaster().sendWithDelay((b) -> b.setValue(index, value));
        return true;
    }

    @Override
    public DatastructureVisualization createVisualization() {
        return new GUIArray<T>();
    }

    @Override
    public String getDatastructureType() {
        return "Array";
    }
}
