package osl2.datastructures.interfaces;

import java.util.Collection;

/**
 * The interface for an array object.
 *
 * @param <T> - the type of objects which can be used as values in an array
 */
public interface IArray<T> extends IDatastructure {
    /**
     * Sets a value at an index in an array.
     *
     * @param index - the index where the value will be set
     * @param value - the value which will be set
     * @return true if the setting worked, else false
     */
    boolean setValue(int index, T value);

    /**
     * Gets the value a specified index.
     *
     * @param index - the index for which the value wants to be known
     * @return the value at the index
     */
    T getValue(int index);

    /**
     * Indicates if an element is in the array.
     *
     * @param value - the element
     * @return true if the element is in the array, else false
     */
    boolean contains(T value);

    /**
     * Indicates if a collection of elements is in the array.
     *
     * @param values - the collection of elements
     * @return true if the elements are all in the array, else false
     */
    boolean contains(Collection<T> values);
}
