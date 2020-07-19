package osl2.Chicago;

/**
 * The Intercaed for all datastructure objects.
 */
public interface IDatastructure {
	/**
	 * Returns the size of an datastructure
	 *
	 * @return int the size of the datastructure
	 */
	int size();

	/**
	 * Removes all Elements from a datastructure
	 *
	 * @return boolean true if all elements were removed, else false
	 */
	boolean removeAll();

	/**
	 * Indicates if a datastructure is empty or not
	 *
	 * @return boolean true if the datastructure is empty, else false
	 */
	boolean isEmpty();
}
