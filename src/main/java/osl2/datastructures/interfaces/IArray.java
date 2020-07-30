package osl2.datastructures.interfaces;

public interface IArray<T> {
    int size();

    T getValue(int index);

    void setValue(int index, T value);
}
