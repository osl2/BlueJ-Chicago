package osl2.datastructures.nodey;

import osl2.messaging.Broadcaster;
import osl2.messaging.datastructures.nodey.VNodeCommunication;

/**
 * The class for the Nodes for the datastructures.
 * @param <Comm> The communication for the node.
 * @param <T> The datatype of the value of the node.
 */
public abstract class VNode<Comm extends VNodeCommunication, T> {
    private final Broadcaster<Comm> broadcaster;
    private T value;

    /**
     * Returns the broadcaster of the node.
     * @return The broadcaster.
     */
    protected Broadcaster<Comm> getBroadcaster() { return broadcaster; }

    /**
     * Returns the value of the node.
     * @return The value fo the node.
     */
    public T getValue() {
        return value;
    }

    /**
     * Sets the value of the node.
     * @param newValue The value for the node.
     */
    public void setValue(T newValue) {
        this.value = value;
        getBroadcaster().sendWithDelay(b -> b.valueChange(newValue));
    }


    public abstract void disconnectAll();

    /**
     * Returns the correspondent node to this node.
     * @return The correspondent node.
     */
    public Comm getCorrespondent() {
        return getBroadcaster().getClient();
    }

    /**
     * Creates the visualisation for this node.
     * @return The visualisation for the node.
     */
    protected abstract Comm createVisualization();

    /**
     * Returns the client of the broadcaster of the node.
     * @return The client of the broadcaster.
     */
    Comm getCommunication() { return broadcaster.getClient(); }

    /**
     * Creates a new VNode.
     * @param parentDS The parentDS to which contains the VNode.
     */
    public VNode(NodeyDatastructure parentDS) {
        Comm comm = createVisualization();
        this.broadcaster = new Broadcaster<>(comm);
        parentDS.registerNodeVisualization(comm);
    }
}
