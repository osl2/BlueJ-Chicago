package osl2.evanston.datastructures.interfaces;

public interface IArray<T> {
    int size();
    T getValue(int index);
    void setValue(int index, T value);
}
