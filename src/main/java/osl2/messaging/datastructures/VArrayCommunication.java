package osl2.messaging.datastructures;

public interface VArrayCommunication<T> {
    void setSize(int size);

    void setValue(int i, T value);
}
