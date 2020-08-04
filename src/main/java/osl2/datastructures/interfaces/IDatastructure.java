package osl2.datastructures.interfaces;

/**
 * The Interface for all datastructure objects.
 */
public interface IDatastructure {
    /**
     * Returns the size of a datastructure.
     *
     * @return the size of the datastructure
     */
    int size();

    /**
     * Removes all Elements from a datastructure.
     *
     * @return true if all elements were removed, else false
     */
    boolean removeAll();

    /**
     * Indicates if a datastructure is empty or not.
     *
     * @return true if the datastructure is empty, else false
     */
    boolean isEmpty();
}
