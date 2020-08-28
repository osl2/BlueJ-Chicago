package osl2.messaging.datastructures;

/**
 * The interface for the communication between maps.
 *
 * @param <K>
 *         The key datatype of the map.
 * @param <V>
 *         The value datatype of the map.
 */
public interface VMapCommunication<K, V> extends DatastructureCommunication {
  /**
   * Puts an element in the map.
   *
   * @param key
   *         The key of the element.
   * @param value
   *         The value of the element.
   */
  void put(K key, V value);

  /**
   * Removes an object from the map.
   *
   * @param key
   *         The key for the pair which should be removed.
   */
  void remove(Object key);

  /**
   * Removes all elements from the map.
   */
  void clear();
}
