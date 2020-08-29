package TestScenarios.TestScenario10;

import java.util.List;
import osl2.Evanston;
import osl2.datastructures.VArray;
import osl2.datastructures.VDoublyLinkedList;

public class TestScenario10 {
    private static List<Integer> intList;
    private static VArray<Integer> intArray;

    public TestScenario10() {
        Evanston.start();
        intList = new VDoublyLinkedList<>();
        intArray = new VArray<>(10);
    }

    public void auffüllen() {
        for (int i = 0; i < 10; i++) {
            intList.add((int) (Math.random() * 50 + 1));
        }
    }

    public void inArray() {
        Object[] listArray = intList.toArray();
        for (int i = 0; i < listArray.length; i++) {
            intArray.setValue(i, (Integer) listArray[i]);
        }
    }
}
