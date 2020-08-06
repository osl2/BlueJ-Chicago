package osl2.datastructures;

import osl2.messaging.datastructures.VMapCommunication;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.datastructures.sequential.GUIMap;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VMap<K, V> extends EvanstonDatastructure<VMapCommunication<K, V>> implements Map<K, V> {
    private final Map<K, V> wrapped = new HashMap<>();


    public VMap(){

    }

    public VMap(String name) {
        super.setName(name);
    }

    @Override
    public DatastructureVisualization createVisualization() {
        return new GUIMap<K, V>();
    }

    @Override
    public String getDatastructureType() {
        return "Map";
    }

    @Override
    public int size() {
        return wrapped.size();
    }

    @Override
    public boolean isEmpty() {
        return wrapped.isEmpty();
    }

    @Override
    public boolean containsKey(Object o) {
        return wrapped.containsKey(o);
    }

    @Override
    public boolean containsValue(Object o) {
        return wrapped.containsValue(o);
    }

    @Override
    public V get(Object o) {
        // TODO: Error handling
        return wrapped.get(o);
    }

    @Override
    public V put(K k, V v) {
        // TODO: Error handling
        getBroadcaster().sendWithDelay(b -> b.put(k, v));
        return wrapped.put(k, v);
    }

    @Override
    public V remove(Object o) {
        // TODO: Error handling
        getBroadcaster().sendWithDelay(b -> b.remove(o));
        return wrapped.remove(o);
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        for (K key : map.keySet()) put(key, map.get(key));
    }

    @Override
    public void clear() {
        getBroadcaster().sendWithDelay(b -> b.clear());
        wrapped.clear();
    }

    @Override
    public Set<K> keySet() {
        return wrapped.keySet();
    }

    @Override
    public Collection<V> values() {
        return wrapped.values();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return wrapped.entrySet();
    }
}
