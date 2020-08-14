package osl2.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import osl2.view.ui.EvanstonWindow;

import java.util.*;

public class VMapTest {
    private static Map map;

    @BeforeAll
    static void setupAll() {
        EvanstonWindow.open();
    }

    @BeforeEach
    void setup() {
        map = new VMap();
        map.put("A", 1);
        map.put("B", 2);
    }

    @Test
    public void size() {
        Assertions.assertEquals(2, map.size());
    }

    @Test
    void isEmpty() {
        Assertions.assertFalse(map.isEmpty());
    }

    @Test
    void containsKey() {
        Assertions.assertTrue(map.containsKey("A"));
    }

    @Test
    void containsNotKey() {
        Assertions.assertFalse(map.containsKey("C"));
    }

    @Test
    void containsValue() {
        Assertions.assertTrue(map.containsValue(2));
    }

    @Test
    void containsNotValue() {
        Assertions.assertFalse(map.containsValue("C"));
    }

    @Test
    void get() {
        Assertions.assertEquals(1, map.get("A"));
    }

    @Test
    void put() {
        map.put("C", 3);
        Assertions.assertEquals(3, map.get("C"));
    }

    @Test
    void putSameKey() {
        map.put("A", 3);
        Assertions.assertEquals(3, map.get("A"));
    }

    @Test
    void remove() {
        map.remove("A");
        Assertions.assertFalse(map.containsKey("A"));
    }

    @Test
    void putAll() {
    }

    @Test
    void clear() {
        map.clear();
        Assertions.assertEquals(0, map.size());
    }

    @Test
    void keySet() {
        Set set = new HashSet();
        set.add("A");
        set.add("B");
        Assertions.assertEquals(set, map.keySet());
    }

    @Test
    void values() {
        Collection collection = new ArrayList();
        collection.add(1);
        collection.add(2);
        Assertions.assertTrue(collection.containsAll(map.values())); // very hacky
    }

    @Test
    void entrySet() {
        Assertions.assertEquals("[A=1, B=2]", map.entrySet().toString()); // hacky
    }
}
