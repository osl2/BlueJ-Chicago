package osl2.datastructures.nodey;

import osl2.messaging.Broadcaster;
import osl2.messaging.datastructures.nodey.VNodeCommunication;

/**
 * Represent a generic node
 * @param <Comm> the communication of the node
 * @param <T> the type of the node
 */
public abstract class VNode<Comm extends VNodeCommunication, T> {
    private final Broadcaster<Comm> broadcaster;
    private T value;

    /**
     * Constructor for the VNode. Initialize visualization, broadcaster and registers itself in the parent DS.
     * @param parentDS
     */
    public VNode(NodeyDatastructure parentDS) {
        Comm comm = createVisualization();
        this.broadcaster = new Broadcaster<>(comm);
        parentDS.registerNodeVisualization(comm);
    }

    /**
     * gets the broadcaster
     * @return the broadcaster of this node
     */
    protected Broadcaster<Comm> getBroadcaster() {
        return broadcaster;
    }

    /**
     * get the Value of this node
     * @return the value of this node
     */
    public T getValue() {
        return value;
    }

    /**
     * sets new value for this node
     * @param newValue the newValue for this node
     */
    public void setValue(T newValue) {
        this.value = newValue;
        getBroadcaster().sendWithDelay(b -> b.valueChange(newValue));
    }

    public abstract void disconnectAll();

    /**
     * Gets the broadcasters corresponding client
     * @return Communication
     */
    public Comm getCorrespondent() {
        return getBroadcaster().getClient();
    }

    protected abstract Comm createVisualization();

    /**
     * Gets the communication
     * @return Communication
     */
    Comm getCommunication() {
        return broadcaster.getClient();
    }
}
