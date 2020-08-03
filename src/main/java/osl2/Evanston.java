package osl2;

import osl2.datastructures.VArray;
import osl2.datastructures.VMap;
import osl2.messaging.PlayController;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.ui.EvanstonWindow;

import java.util.Map;

public class Evanston {

    public static void openVisualization(DatastructureVisualization visualization) {
        EvanstonWindow window = EvanstonWindow.getInstance();
        window.openVisualization(visualization);
    }

    public static PlayController getPlayController() {
        return EvanstonWindow.getInstance().getPlayController();
    }

    public static void main(String[] args) {
        EvanstonWindow.open();

        VArray<Integer> errorArray = new VArray<>(5);
        for (int i = 0; i < 6; i++) {
            errorArray.setValue(i % 5, i);
        }
        // IndexOutOfBounds error
        errorArray.setValue(10, 1);

        VArray<Integer> array = new VArray<Integer>(8);
        Map<Integer, Character> amap = new VMap<>();

        for (int x = 64; x < 69; x++) amap.put(x, (char) x);
        for (int x = 64; x < 70; x++) amap.put(x, (char) (x + 5));
        amap.remove(66);

        int i = 0;

        loop:
        for (; ; ) {
            for (int x = 0; x < array.size(); x++) {
                array.setValue(x, i++);
            }
        }
    }
}
