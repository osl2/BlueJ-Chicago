package osl2.datastructures.nodey;

import osl2.messaging.datastructures.nodey.VLinkedListNodeCommunication;
import osl2.view.datastructures.nodey.GUILinkedListNode;

/**
 * Represents a node of an linked list
 * @param <T> the type of the node
 */
public class VLinkedListNode<T> extends VNode<VLinkedListNodeCommunication<T>, T> {
    private VLinkedListNode<T> forward;
    private VLinkedListNode<T> backward;

    public VLinkedListNode(NodeyDatastructure parentDS) {
        super(parentDS);
    }


    /**
     * get forward node
     * @return the next node
     */
    public VLinkedListNode<T> getForward() {
        return forward;
    }

    /**
     * set the forward node
     * @param forward the node to be set as backward node
     */
    public void setForward(VLinkedListNode<T> forward) {
        if (forward != getForward()) {
            this.forward = forward;
            getBroadcaster().sendWithDelay(b -> b.setForward(forward == null ? null : forward.getCommunication()));
        }
    }

    /**
     * get backward node
     * @return the node before the current node
     */
    public VLinkedListNode<T> getBackward() {
        return backward;
    }

    /**
     * set the backward node
     * @param backward the node to be set as backward node
     */
    public void setBackward(VLinkedListNode<T> backward) {
        if (backward != getBackward()) {
            this.backward = backward;
            getBroadcaster().sendWithDelay(b -> b.setBackward(backward == null ? null : backward.getCommunication()));
        }
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
