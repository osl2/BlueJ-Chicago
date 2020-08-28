package osl2.messaging.datastructures;

/**
 * The interface for the communication between arrays.
 *
 * @param <T>
 */
public interface VArrayCommunication<T> extends DatastructureCommunication {
  /**
   * Sets the size of the array.
   *
   * @param size
   *         The size of the array.
   */
  void setSize(int size);

  /**
   * Sets the value at an index.
   *
   * @param i
   *         The index.
   * @param value
   *         The value.
   */
  void setValue(int i, T value);

  /**
   * Sets everything to null.
   */
  void removeAll();
}
