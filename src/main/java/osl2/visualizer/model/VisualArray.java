package osl2.visualizer.model;

import osl2.Chicago.IArray;

import java.util.Collection;


public class VisualArray<T> extends VisualDatastructure implements IArray<T> {
    private T[] elements;

    public VisualArray(int size) {
        elements = (T[]) new Object[size];
    }

    @Override
    Datastructure getDatastructureType() {
        return Datastructure.DS_ARRAY;
    }

    @Override
    public boolean setValue(int index, T value) {
        if (index < 0 || index >= elements.length) {
            return false;
        } else {
            elements[index] = value;
            return true;
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
}
