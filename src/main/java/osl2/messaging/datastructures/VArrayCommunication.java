package osl2.messaging.datastructures;

public interface VArrayCommunication<T> extends DatastructureCommunication {
    void setSize(int size);

    void setValue(int i, T value);
}
