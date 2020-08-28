package osl2.datastructures;

import osl2.Evanston;

/**
 * represents an Breakpoint
 */
public class Breakpoint {

  /**
   * pauses the visualization
   */
  public static void block() {
    Evanston.getPlayController().pause();
  }
}
