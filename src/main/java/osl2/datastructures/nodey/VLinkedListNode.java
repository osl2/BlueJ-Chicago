package osl2.datastructures.nodey;

import osl2.messaging.datastructures.nodey.VLinkedListNodeCommunication;
import osl2.view.datastructures.nodey.GUILinkedListNode;

public class VLinkedListNode<T> extends VNode<VLinkedListNodeCommunication<T>, T> {
    private VLinkedListNode<T> forward;
    private VLinkedListNode<T> backward;

    public VLinkedListNode(NodeyDatastructure parentDS) {
        super(parentDS);
    }


    public VLinkedListNode<T> getForward() {
        return forward;
    }

    public void setForward(VLinkedListNode<T> forward) {
        this.forward = forward;
        getBroadcaster().sendWithDelay(b -> b.setForward(forward == null ? null : forward.getCommunication()));
    }

    public VLinkedListNode<T> getBackward() {
        return backward;
    }

    public void setBackward(VLinkedListNode<T> backward) {
        this.backward = backward;
        getBroadcaster().sendWithDelay(b -> b.setBackward(backward == null ? null : backward.getCommunication()));
    }

    @Override
    public void disconnectAll() {
        setForward(null);
        setBackward(null);
    }

    @Override
    protected VLinkedListNodeCommunication<T> createVisualization() {
        return new GUILinkedListNode<T>();
    }
}
