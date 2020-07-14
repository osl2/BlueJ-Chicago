import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class VNode<T> {
    private T value;

    public VNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}

