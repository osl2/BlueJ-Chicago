package osl2.view.datastructures.sequential;

import osl2.messaging.datastructures.VArrayCommunication;
import osl2.view.inlinerepresentation.InlineRepresentation;

public class GUIArray<T> extends GUISequential implements VArrayCommunication<T> {

    public GUIArray() {
        super("Value", "Index");
        setName("Array");
    }

    @Override
    public void setSize(int size) {
        clearElements();
        for (int x = 0; x < size; x++) {
            putElement(x, InlineRepresentation.get(null));
        }
    }

    @Override
    public void setValue(int i, T value) {
        putElement(i, InlineRepresentation.get(value));
    }
}
