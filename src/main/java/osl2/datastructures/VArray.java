package osl2.datastructures;

import osl2.datastructures.interfaces.IArray;
import osl2.messaging.datastructures.VArrayCommunication;
import osl2.messaging.errorHandling.ArrayIndexOutOfBoundsError;
import osl2.messaging.errorHandling.UserError;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.datastructures.sequential.GUIArray;

import java.util.Arrays;
import java.util.Collection;

public class VArray<T> extends EvanstonDatastructure<VArrayCommunication<T>> implements IArray<T> {
    private final T[] values;
    private final int size;

    public VArray(int size) {
        this.size = size;
        this.values = (T[]) new Object[size];
        getBroadcaster().send((b) -> b.setSize(size));
    }

    public VArray(int size,String name){
        this.size = size;
        this.values = (T[]) new Object[size];
        getBroadcaster().send((b) -> b.setSize(size));
        super.setName(name);
    }


    public int size() {
        return values.length;
    }

    public T getValue(int index) {
        return values[index];
    }

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

    public boolean contains(T value) {
        for (T e : values) {
            if (e == value) return true;
        }
        return false;
    }

    public boolean contains(Collection<T> values) {
        for (T e : values) {
            if (!contains(e)) return false;
        }
        return true;
    }

    public boolean removeAll() {
        Arrays.fill(values, null); // TODO do not forget the broadcaster
        return true;
    }

    public boolean isEmpty() {
        for(T element: values) {
            if(element != null)
                return false;
        }
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
