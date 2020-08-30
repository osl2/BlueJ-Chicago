package osl2.messaging.datastructures;

/**
 * The interface for the communication between maps.
 *
 * @param <K>
 *         the key datatype of the map
 * @param <V>
 *         the value datatype of the map
 */
public interface VMapCommunication<K, V> extends DatastructureCommunication {
    /**
     * Puts an element in the map.
     *
     * @param key
     *         the key of the element
     * @param value
     *         the value of the element
     */
    void put(K key, V value);

    /**
     * Removes an object from the map.
     *
     * @param key
     *         the key for the pair which should be removed
     */
    void remove(Object key);

    /**
     * Removes all elements from the map.
     */
    void clear();
}
