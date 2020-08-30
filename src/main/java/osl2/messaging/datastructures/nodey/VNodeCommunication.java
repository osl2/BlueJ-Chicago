package osl2.messaging.datastructures.nodey;

import osl2.messaging.datastructures.DatastructureCommunication;
import osl2.view.datastructures.nodey.GuiNode;

/**
 * The communication used by {@link osl2.datastructures.nodey.VNode}.
 *
 * @param <T>
 *         the type used
 */
public interface VNodeCommunication<T> extends DatastructureCommunication {
    /**
     * Get this as a node.
     *
     * @return this as a node
     */
    GuiNode asGUINode();

    /**
     * Sets a specified value.
     *
     * @param newValue
     *         the value to be set
     */
    void valueChange(T newValue);
}
