package osl2.visualizer.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VisualMap<K, V> extends VisualDatastructure implements Map<K, V> {

	private final Map<K, V> wrapped = new HashMap<>();

	@Override
	public Datastructure getDatastructureType() {
		return Datastructure.DS_MAP;
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
		return wrapped.get(o);
	}

	@Override
	public V put(K k, V v) {
		return wrapped.put(k, v);
	}

	@Override
	public V remove(Object o) {
		return wrapped.remove(o);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> map) {
		wrapped.putAll(map);
	}

	@Override
	public void clear() {
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
