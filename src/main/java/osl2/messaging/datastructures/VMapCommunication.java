package osl2.messaging.datastructures;

public interface VMapCommunication<K, V> extends DatastructureCommunication {
    void put(K key, V value);

    void remove(Object key);

    void clear();
}
