package osl2.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import osl2.datastructures.VSinglyLinkedList;
import osl2.view.ui.EvanstonWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class VListTest {
    private static List list;

    @BeforeAll
    static void setupAll() {
        EvanstonWindow.openForTests();
    }

    @BeforeEach
    void setup() {
        list = new VSinglyLinkedList();
        list.add(1);
        list.add(2);
    }

    @Test
    public void size() {
        Assertions.assertEquals(2, list.size());
    }

    @Test
    public void sizeOfAnEmptyList() {
        list = new VSinglyLinkedList();
        Assertions.assertEquals(0, list.size());
    }

    @Test
    void isEmpty() {
        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    void contains() {
        Assertions.assertTrue(list.contains(1));
    }

    @Test
    void containsNotElement() {
        Assertions.assertFalse(list.contains(42));
    }

    @Test
    void toArrayWithInteger() {
        Assertions.assertTrue(Arrays.equals(new Integer[]{1, 2}, list.toArray()));
    }

    @Test
    void add() {
        list.add(3);
        Assertions.assertTrue(list.contains(3));
    }

    @Test
    void remove() {
        list.remove(1);
        Assertions.assertFalse(list.contains(2));
    }

    @Test
    void removeAtWrongIndex() {
        Assertions.assertNull(list.remove(5));
    }

    @Test
    void removeAtNegativeIndex() {
        Assertions.assertNull(list.remove(-5));
    }

    @Test
    void addAll() {
        List<Integer> collection = new ArrayList<>();
        collection.add(5);
        collection.add(7);

        list.addAll(collection);

        Assertions.assertTrue(list.containsAll(collection));
    }

    @Test
    void AddAllAtAIndex() {
        List<Integer> collection = new ArrayList<>();
        collection.add(5);
        collection.add(7);

        list.addAll(1, collection);

        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(5, list.get(1));
        Assertions.assertEquals(7, list.get(2));
        Assertions.assertEquals(2, list.get(3));
    }

    @Test
    void AddAllAtAWrongIndex() {
        List<Integer> collection = new ArrayList<>();
        collection.add(5);
        collection.add(7);

        Assertions.assertFalse(list.addAll(5, collection));
    }

    @Test
    void AddAllAtANegativeIndex() {
        List<Integer> collection = new ArrayList<>();
        collection.add(5);
        collection.add(7);

        Assertions.assertFalse(list.addAll(-5, collection));
    }

    @Test
    void clear() {
        list.clear();
        Assertions.assertTrue(list.isEmpty());
    }

    @Test
    void get() {
        Assertions.assertEquals(1, list.get(0));
    }

    @Test
    void getAtWrongIndex() {
        Assertions.assertNull(list.get(42));
    }

    @Test
    void getAtNegativeIndex() {
        Assertions.assertNull(list.get(-42));
    }

    @Test
    void set() {
        list.set(0, 10);
        Assertions.assertEquals(10, list.get(0));
    }

    @Test
    void setAtWrongIndex() {
        Assertions.assertNull(list.set(42, 10));
    }

    @Test
    void setAtNegativeIndex() {
        Assertions.assertNull(list.set(-42, 10));
    }

    @Test
    void addAtIndex() {
        list.add(1, 5);

        Assertions.assertEquals(1, list.get(0));
        Assertions.assertEquals(5, list.get(1));
        Assertions.assertEquals(2, list.get(2));
    }

    @Test
    void addAtWrongIndex() {
        list.add(5, 5);
        Assertions.assertFalse(list.contains(5));
    }

    @Test
    void addAtNegativeIndex() {
        list.add(-5, 5);
        Assertions.assertFalse(list.contains(5));
    }

    @Test
    void indexOf() {
        Assertions.assertEquals(1, list.indexOf(2));
    }

    @Test
    void indexOfNotContainedElement() {
        Assertions.assertEquals(-1, list.indexOf(42));
    }

    @Test
    void lastIndexOf() {
        list.add(3);
        list.add(1);
        Assertions.assertEquals(3, list.lastIndexOf(1));
    }

    @Test
    void lastIndexOfNotContainedElement() {
        Assertions.assertEquals(-1, list.lastIndexOf(42));
    }

    @Test
    void subList() {
        list.add(3);

        Collection collection = new ArrayList();
        collection.add(1);
        collection.add(2);

        Assertions.assertTrue(collection.containsAll(list.subList(1, 2)));
    }

    @Test
    void retainAll() {
        Collection collection = new ArrayList();
        collection.add(1);

        list.retainAll(collection);
        Assertions.assertTrue(collection.containsAll(collection));
    }

    @Test
    void removeAll() {
        Collection collection = new ArrayList();
        collection.add(1);

        list.removeAll(collection);

        Assertions.assertFalse(list.contains(1));
    }

    @Test
    void containsAll() {
        List<Integer> collection = new ArrayList<>();
        collection.add(1);
        collection.add(2);

        Assertions.assertTrue(list.containsAll(collection));
    }

    @Test
    void toArrayWithArrayAsArgument() {
        Assertions.assertTrue(Arrays.equals(new Integer[]{1, 2}, list.toArray(new Integer[]{})));
    }
}
