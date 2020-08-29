package osl2.datastructures;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import osl2.datastructures.interfaces.IArray;
import osl2.messaging.datastructures.VArrayCommunication;
import osl2.messaging.errorHandling.ArrayErrors.ArrayIndexOutOfBoundsError;
import osl2.messaging.errorHandling.UserError;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.datastructures.sequential.GUIArray;

/**
 * Represents an array.
 *
 * @param <T>
 *         the type of data stored in the array
 */
public class VArray<T> extends EvanstonDatastructure<VArrayCommunication<T>> implements IArray<T> {
    private final T[] values;
    private final int size;

    /**
     * Creates a new {@link VArray} with a specified size.
     *
     * @param size
     *         the size of the array
     */
    public VArray(int size) {
        this.size = size;
        this.values = (T[]) new Object[size];
        getBroadcaster().send(b -> b.setSize(size));
    }

    /**
     * Creates a new {@link VArray} with a specified size and name.
     *
     * @param size
     *         the size of the array
     * @param name
     *         the name of the array
     */
    public VArray(int size, String name) {
        this.size = size;
        this.values = (T[]) new Object[size];
        getBroadcaster().send(b -> b.setSize(size));
        super.setName(name);
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public T getValue(int index) {
        if (index < 0 || index >= this.size) {
            UserError userError = new ArrayIndexOutOfBoundsError(index, size - 1);
            getBroadcaster().sendWithPauseBlock(b -> b.handleError(userError));
            return null;
        }
        return values[index];
    }

    @Override
    public boolean setValue(int index, T value) {
        if (index < 0 || index >= this.size) {
            UserError userError = new ArrayIndexOutOfBoundsError(index, size - 1);
            getBroadcaster().sendWithPauseBlock(b -> b.handleError(userError));
            return false;
        }

        values[index] = value;
        getBroadcaster().sendWithDelay(b -> b.setValue(index, value));
        return true;
    }

    @Override
    public boolean contains(T value) {
        for (T e : values) {
            if (Objects.equals(e, value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Collection<T> values) {
        for (T e : values) {
            if (!contains(e)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean removeAll() {
        Arrays.fill(values, null);
        getBroadcaster().sendWithDelay(VArrayCommunication::removeAll);
        return true;
    }

    @Override
    public boolean isEmpty() {
        for (T element : values) {
            if (element != null) {
                return false;
            }
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
