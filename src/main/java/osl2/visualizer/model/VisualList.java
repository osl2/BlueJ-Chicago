package osl2.visualizer.model;

import java.util.*;

public abstract class VisualList<T> extends VisualDatastructure implements List<T> {
	private final List<T> wrapped = new ArrayList<>();

	public VisualList() {
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
	public boolean contains(Object o) {
		return wrapped.contains(o);
	}

	@Override
	public Object[] toArray() {
		return wrapped.toArray();
	}

	@Override
	public <T1> T1[] toArray(T1[] t1s) {
		return wrapped.toArray(t1s);
	}

	@Override
	public boolean add(T t) {
		return wrapped.add(t);
	}

	@Override
	public boolean remove(Object o) {
		return wrapped.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		return wrapped.containsAll(collection);
	}

	@Override
	public boolean addAll(Collection<? extends T> collection) {
		return wrapped.addAll(collection);
	}

	@Override
	public boolean addAll(int i, Collection<? extends T> collection) {
		return wrapped.addAll(i, collection);
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		return wrapped.removeAll(collection);
	}

	@Override
	public boolean retainAll(Collection<?> collection) {
		return wrapped.retainAll(collection);
	}

	@Override
	public void clear() {
		wrapped.clear();
	}

	@Override
	public T get(int i) {
		return wrapped.get(i);
	}

	@Override
	public T set(int i, T t) {
		return wrapped.set(i, t);
	}

	@Override
	public void add(int i, T t) {
		wrapped.add(i, t);
	}

	@Override
	public T remove(int i) {
		return wrapped.remove(i);
	}

	@Override
	public int indexOf(Object o) {
		return wrapped.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return wrapped.lastIndexOf(o);
	}

	@Override
	public List<T> subList(int i, int i1) {
		return wrapped.subList(i, i1);
	}

	@Override
	public Iterator<T> iterator() {
		return null;    // TODO
	}

	@Override
	public ListIterator<T> listIterator() {
		return null;    // TODO
	}

	@Override
	public ListIterator<T> listIterator(int i) {
		return null;    // TODO
	}
}
