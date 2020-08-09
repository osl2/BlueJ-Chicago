import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import osl2.datastructures.VArray;
import osl2.view.ui.EvanstonWindow;

import java.util.ArrayList;
import java.util.List;

public class VArrayTest {
    private static VArray array;

    @BeforeAll
    static void setupAll() {
        EvanstonWindow.open();
    }

    @BeforeEach
    void setup() {
        array = new VArray<Integer>(10);
    }

    @Test
    public void size() {
        Assertions.assertEquals(10, array.size());
    }

    @Test
    void getValue() {
        array.setValue(0, 1);
        Assertions.assertEquals(1, array.getValue(0));
    }

    @Test
    void setValue() {
        array.setValue(0, 1);
        Assertions.assertEquals(1, array.getValue(0));
    }

    @Test
    void contains() {
        array.setValue(0, 1);
        Assertions.assertTrue(array.contains(1));
    }

    @Test
    void containsCollection() {
        array.setValue(0, 1);
        array.setValue(1, 2);
        array.setValue(2, 3);

        List<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);

        Assertions.assertTrue(array.contains(collection));
    }

    @Test
    void containsNotCollection() {
        array.setValue(0, 1);
        array.setValue(1, 2);
        array.setValue(2, 3);

        List<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);
        collection.add(42);

        Assertions.assertFalse(array.contains(collection));
    }

    @Test
    void removeAll() {
        array.setValue(0, 1);
        array.setValue(1, 2);

        array.removeAll();

        for (int i = 0; i < array.size(); i++) {
            if (array.getValue(i) != null) {
                throw new AssertionError("List is not empty!");
            }
        }
    }

    @Test
    void isEmpty() {
        Assertions.assertTrue(array.isEmpty());
    }

    @Test
    void isNotEmpty() {
        array.setValue(0, 1);
        array.setValue(1, 2);

        Assertions.assertFalse(array.isEmpty());
    }
}
