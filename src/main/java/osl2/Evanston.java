package osl2;

import osl2.datastructures.VArray;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.ui.EvanstonWindow;

public class Evanston {

    public static void openVisualization(DatastructureVisualization visualization) {
        EvanstonWindow window = EvanstonWindow.getInstance();
        window.openVisualization(visualization);
    }

    public static void main(String[] args) {
        EvanstonWindow.open();

        VArray<Integer> array = new VArray<Integer>(8);
        new VArray<VArray>(4).setValue(0, array);

        int i = 0;

        loop:
        for (; ; ) {
            for (int x = 0; x < array.size(); x++) {
                array.setValue(x, i++);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break loop;
                }
            }
        }
    }
}
