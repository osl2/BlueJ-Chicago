package osl2.Chicago;

public interface IDatastructure {
    /**
     *Returns the size of an datastructure
     *@return int the size of the datastructure
     */
    public int size();

    /**
     * Removes all Elements from a datastructure
     * @return boolean true if all elements were removed, else false
     */
    public boolean removeAll();

    /**
     * Indicates if a datastructure is empty or not
     * @return boolean true if the datastructure is empty, else false
     */
    public boolean isEmpty();
}
