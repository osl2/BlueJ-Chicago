package osl2.view.datastructures.sequential;

import osl2.messaging.datastructures.VArrayCommunication;
import osl2.view.inlinerepresentation.InlineRepresentation;

/**
 * The class for a visualized array.
 *
 * @param <T> The datatype of the array.
 */
public class GUIArray<T> extends GUISequential implements VArrayCommunication<T> {

    /**
     * Creates a new array.
     */
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

    @Override
    public void removeAll() {
        final int size = getContents().getChildren().size();
        for (int i = 0; i < size; i++) setValue(i, null);
    }
}
