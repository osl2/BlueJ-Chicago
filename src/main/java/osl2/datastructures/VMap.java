package osl2.datastructures;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import osl2.messaging.datastructures.VMapCommunication;
import osl2.messaging.errorHandling.MapErrors.MapNullPointerGetError;
import osl2.messaging.errorHandling.MapErrors.MapNullPointerRemoveError;
import osl2.messaging.errorHandling.UserError;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.datastructures.sequential.GUIMap;

/**
 * Represents a Map.
 *
 * @param <K>
 *         The key type of the map.
 * @param <V>
 *         The value type of the map.
 */
public class VMap<K, V> extends EvanstonDatastructure<VMapCommunication<K, V>> implements Map<K, V> {
  private final Map<K, V> wrapped = new HashMap<>();


  /**
   * empty constructor
   */
  public VMap() {

  }

  /**
   * Constructor which allows setting the name.
   *
   * @param name
   *         the name of the DS.
   */
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
    if (!wrapped.containsKey(o)) {
      UserError userError = new MapNullPointerGetError<>(o);
      getBroadcaster().sendWithPauseBlock((b) -> b.handleError(userError));
      return null;
    }
    return wrapped.get(o);
  }

  /**
   * Private getter for default methods which use get.
   *
   * @param o
   *         The Key.
   * @return The Value to the key.
   */
  private V getPrivate(Object o) {
    return wrapped.get(o);
  }

  @Override
  public V put(K k, V v) {
    getBroadcaster().sendWithDelay(b -> b.put(k, v));
    return wrapped.put(k, v);
  }


  @Override
  public V remove(Object o) {
    if (!wrapped.containsKey(o)) {
      UserError userError = new MapNullPointerRemoveError<>(o);
      getBroadcaster().sendWithPauseBlock((b) -> b.handleError(userError));
      return null;
    }
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

  @Override
  public V getOrDefault(Object key, V defaultValue) {
    if (this.containsKey(key)) {
      return this.get(key);
    } else {
      return defaultValue;
    }
  }

  @Override
  public V putIfAbsent(K key, V value) {
    if (!this.containsKey(key)) {
      return wrapped.put(key, value);
    }
    return null;
  }

  @Override
  public boolean remove(Object key, Object value) {
    if (this.containsKey(key) && Objects.equals(this.getPrivate(key), value)) {
      this.remove(key);
      return true;
    } else
      return false;
  }

  @Override
  public boolean replace(K key, V oldValue, V newValue) {
    if (this.containsKey(key) && Objects.equals(this.getPrivate(key), oldValue)) {
      this.put(key, newValue);
      return true;
    } else
      return false;
  }

  @Override
  public V computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) {
    if (this.getPrivate(key) == null) {
      V newValue = mappingFunction.apply(key);
      if (newValue != null)
        this.put(key, newValue);
    }
    return this.getPrivate(key);
  }

  @Override
  public V computeIfPresent(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
    if (this.getPrivate(key) != null) {
      V oldValue = this.getPrivate(key);
      V newValue = remappingFunction.apply(key, oldValue);
      if (newValue != null)
        this.put(key, newValue);
      else
        this.remove(key);
    }
    return this.getPrivate(key);
  }

  @Override
  public V compute(K key, BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
    V oldValue = this.getPrivate(key);
    V newValue = remappingFunction.apply(key, oldValue);
    if (oldValue != null) {
      if (newValue != null)
        this.put(key, newValue);
      else
        this.remove(key);
    } else {
      if (newValue != null)
        this.put(key, newValue);
      else
        return null;
    }
    return this.getPrivate(key);
  }

  @Override
  public V merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
    V oldValue = this.getPrivate(key);
    V newValue = (oldValue == null) ? value :
            remappingFunction.apply(oldValue, value);
    if (newValue == null)
      this.remove(key);
    else
      this.put(key, newValue);
    return this.getPrivate(key);
  }
}
