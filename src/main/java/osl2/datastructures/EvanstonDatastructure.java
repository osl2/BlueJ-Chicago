package osl2.datastructures;

import osl2.Evanston;
import osl2.messaging.Broadcaster;
import osl2.messaging.datastructures.DatastructureCommunication;
import osl2.view.datastructures.DatastructureVisualization;

/**
 * Represents the data structures
 *
 * @param <B>
 */
public abstract class EvanstonDatastructure<B extends DatastructureCommunication> {
  private final Broadcaster<B> broadcaster;


  private String name;

  /**
   * Constructor. Creates and open visualization.
   */
  public EvanstonDatastructure() {
    DatastructureVisualization visualization = createVisualization();
    broadcaster = Evanston.openVisualization(this);
  }


  /**
   * gets the broadcaster
   *
   * @return broadcaster
   */
  protected Broadcaster<B> getBroadcaster() {
    return broadcaster;
  }

  public abstract DatastructureVisualization createVisualization();

  /**
   * gets the name of the DS
   *
   * @return string which represents the name
   */
  public String getName() {
    return this.name;
  }

  /**
   * sets the name of the DS
   *
   * @param name
   *         the new name to set for the DS
   */
  public void setName(String name) {
    this.name = name;
    getBroadcaster().send((b) -> b.setName(getDatastructureType() + " : " + this.name));

  }

  /**
   * gets the type of DS. Used for the titlebar.
   *
   * @return a String representing the type of the DS
   */
  public abstract String getDatastructureType();


}
