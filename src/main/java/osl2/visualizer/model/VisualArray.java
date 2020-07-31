package osl2.visualizer.model;

import osl2.Chicago.IArray;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collection;


public class VisualArray<T> extends EvanstonDatastructure<VArrayCommunication<T>> implements IArray<T> {
	private final T[] elements;

	public VisualArray(int size) {
		elements = (T[]) new Object[size];
		getBroadcaster().send((b) -> b.setSize(size));
	}

	@Override
	public boolean setValue(int index, T value) {
		if (index < 0 || index >= elements.length) {
			return false;
		} else {
			elements[index] = value;
			getBroadcaster().send((b) -> b.setValue(index, value));
		}
	}

	@Override
	public T getValue(int index) {
		if (index < 0 || index >= elements.length) {
			return null;
		} else {
			return elements[index];
		}
	}

	@Override
	public boolean contains(T value) {
		for (T e : elements) {
			if (e == value) return true;
		}
		return false;
	}

	@Override
	public boolean contains(Collection<T> values) {
		for (T e : values) {
			if (!contains(e)) return false;
		}
		return true;
	}

	@Override
	public int size() {
		return elements.length;
	}

	@Override
	public boolean removeAll() {
		for(int i = 0; i < elements.length; i++){
			elements[i] = null;
		}
		getBroadcaster().send((b) -> b.removeAll());
		return true;
	}

	@Override
	public boolean isEmpty() {
		//TODO implement
		return true;
	}
}
