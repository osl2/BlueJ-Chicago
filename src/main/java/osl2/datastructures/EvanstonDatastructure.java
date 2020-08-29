package osl2.datastructures;

import osl2.Evanston;
import osl2.messaging.Broadcaster;
import osl2.messaging.datastructures.DatastructureCommunication;
import osl2.view.datastructures.DatastructureVisualization;

/**
 * Represents the data structures.
 *
 * @param <C>
 *         the datastructure communication used
 */
public abstract class EvanstonDatastructure<C extends DatastructureCommunication> {
    private final Broadcaster<C> broadcaster;

    private String name;

    /**
     * Creates and opens a visualization.
     */
    public EvanstonDatastructure() {
        broadcaster = Evanston.openVisualization(this);
    }


    /**
     * Gets the broadcaster.
     *
     * @return the broadcaster
     */
    protected Broadcaster<C> getBroadcaster() {
        return broadcaster;
    }

    public abstract DatastructureVisualization createVisualization();

    /**
     * Gets the name of the datastructure.
     *
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the datastructure.
     *
     * @param name
     *         the new name to set for the DS
     */
    public void setName(String name) {
        this.name = name;
        getBroadcaster().send(c -> c.setName(getDatastructureType() + " : " + this.name));
    }

    /**
     * Gets the type of datastructure used for the title bar.
     *
     * @return the type of the datastructure
     */
    public abstract String getDatastructureType();
}
