package osl2.datastructures;

import osl2.datastructures.interfaces.IArray;
import osl2.messaging.datastructures.VArrayCommunication;
import osl2.messaging.errorHandling.ArrayIndexOutOfBoundsError;
import osl2.messaging.errorHandling.UserError;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.datastructures.sequential.GUIArray;

public class VArray<T> extends EvanstonDatastructure<VArrayCommunication<T>> implements IArray<T> {
    private final T[] values;
    private final int size;

    public VArray(int size) {
        this.size = size;
        this.values = (T[]) new Object[size];
        getBroadcaster().send((b) -> b.setSize(size));
    }

    public int size() {
        return values.length;
    }

    public T getValue(int index) {
        return values[index];
    }

    public void setValue(int index, T value) {
        if (index < 0 || index > this.size) {
            UserError userError = new ArrayIndexOutOfBoundsError(index, size);
            getBroadcaster().sendWithDelay((b) -> b.handleError(userError));
            return;
        }

        values[index] = value;
        getBroadcaster().sendWithDelay((b) -> b.setValue(index, value));
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
