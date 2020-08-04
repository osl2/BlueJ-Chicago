package osl2.datastructures.nodey;

import osl2.messaging.Broadcaster;
import osl2.messaging.datastructures.nodey.VNodeCommunication;

public abstract class VNode<Comm extends VNodeCommunication, T> {
    private final Broadcaster<Comm> broadcaster;
    private T value;

    protected Broadcaster<Comm> getBroadcaster() { return broadcaster; }

    public T getValue() {
        return value;
    }

    public void setValue(T newValue) {
        this.value = value;
        getBroadcaster().sendWithDelay(b -> b.valueChange(newValue));
    }

    protected abstract Comm createVisualization();

    Comm getCommunication() { return broadcaster.getClient(); }

    public VNode(NodeyDatastructure parentDS) {
        Comm comm = createVisualization();
        this.broadcaster = new Broadcaster<>(comm);
        parentDS.registerNodeVisualization(comm);
    }
}
