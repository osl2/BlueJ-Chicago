package osl2.datastructures;

import osl2.Evanston;

/**
 * Represents a Breakpoint.
 */
public class Breakpoint {

    private Breakpoint() {
    }

    /**
     * Pauses the visualization.
     */
    public static void block() {
        Evanston.getPlayController().pause();
    }
}
