package osl2.datastructures;

import osl2.Evanston;
import osl2.messaging.PlayController;
import osl2.view.ui.EvanstonWindow;

public class Breakpoint {

    public static void block(){
        Evanston.getPlayController().pause();
    }
}
