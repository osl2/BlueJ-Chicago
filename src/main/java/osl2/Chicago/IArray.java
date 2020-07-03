package osl2.Chicago;


public interface IArray<T> {
    /**
     * Sets an value at an index in an array.
     * @param index the index where the value will be set
     * @param value the value which will be set
     * @return boolean true if the setting worked, else false
     */
    public boolean setValue(int index, T value);

    /**
     * Returns an value at an index.
     * @param index the index for which the value wants to be known
     * @return T the value at the index
     */
    public T getValue(int index);

    /**
     * Indicates if an element is  in the array.
     * @param value the element
     * @return boolean true if the element is in the array, else false
     */
    public boolean contains(T value);

    /**
     *  Indicates if an collection of elements is in the array
     * @param values the collection of elements
     * @return boolean true if the elements are all in the array, else false
     */
    public boolean contains(Collection<T> values);

    /**
     * Returns the size of the array.
     * @return int the size of the array
     */
    public int size();
}
