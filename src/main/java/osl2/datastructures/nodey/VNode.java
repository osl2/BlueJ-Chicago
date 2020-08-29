package osl2.datastructures.nodey;

import osl2.messaging.Broadcaster;
import osl2.messaging.datastructures.nodey.VNodeCommunication;

/**
 * Represent a generic node.
 *
 * @param <C>
 *         the communication of the node
 * @param <T>
 *         the type of the node
 */
public abstract class VNode<C extends VNodeCommunication, T> {
    private final Broadcaster<C> broadcaster;
    private T value;

    /**
     * Constructor for the VNode. Initialize visualization, broadcaster and registers itself in the parent DS.
     *
     * @param parentDS
     *         the parent datastructure
     */
    public VNode(NodeyDatastructure parentDS) {
        C c = createVisualization();
        this.broadcaster = new Broadcaster<>(c);
        parentDS.registerNodeVisualization(c);
    }

    /**
     * Gets the broadcaster.
     *
     * @return the broadcaster of this node
     */
    protected Broadcaster<C> getBroadcaster() {
        return broadcaster;
    }

    /**
     * Gets the Value of this node.
     *
     * @return the value of this node
     */
    public T getValue() {
        return value;
    }

    /**
     * Sets new value for this node.
     *
     * @param newValue
     *         the newValue for this node
     */
    public void setValue(T newValue) {
        this.value = newValue;
        getBroadcaster().sendWithDelay(b -> b.valueChange(newValue));
    }

    public abstract void disconnectAll();

    /**
     * Gets the broadcasters corresponding client.
     *
     * @return communication
     */
    public C getCorrespondent() {
        return getBroadcaster().getClient();
    }

    protected abstract C createVisualization();

    /**
     * Gets the communication.
     *
     * @return communication
     */
    C getCommunication() {
        return broadcaster.getClient();
    }
}
