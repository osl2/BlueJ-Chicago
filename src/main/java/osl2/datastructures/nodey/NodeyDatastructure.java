package osl2.datastructures.nodey;

import osl2.datastructures.EvanstonDatastructure;
import osl2.messaging.datastructures.nodey.VNodeCommunication;
import osl2.messaging.datastructures.nodey.VNodeyDatastructureCommunication;

/**
 * Represents a datastructure that uses nodes.
 *
 * @param <T>
 *         the datatype used in the datastructure
 * @param <K>
 *         the communication used
 * @param <C>
 *         the communication type used
 * @param <N>
 *         the type of node
 */
public abstract class NodeyDatastructure<T, K extends VNodeyDatastructureCommunication<T, C>,
        C extends VNodeCommunication<T>, N extends VNode<C, T>> extends EvanstonDatastructure<K> {

  /**
   * Creates a new Node.
   *
   * @return a new node of NodeType
   */
  protected abstract N createNode();

  /**
   * Registers the communication.
   *
   * @param comm
   *         the communication
   */
  protected final void registerNodeVisualization(C comm) {
    getBroadcaster().sendWithDelay(b -> b.addGUINode(comm));
  }

  /**
   * Creates a new node.
   *
   * @return the newly created node
   */
  public final N addNode() {
    return createNode();
  }

  /**
   * Creates a new node with a value.
   *
   * @param value
   *         the value
   * @return the new node
   */
  public final N addNode(T value) {
    N node = createNode();
    node.setValue(value);
    return node;
  }

  /**
   * Removes the node.
   *
   * @param node
   *         the node to be removed
   * @return true if the operation was successful
   */
  public boolean removeNode(N node) {
    node.disconnectAll();
    getBroadcaster().sendWithDelay(b -> b.removeGUINode(node.getCommunication()));
    return true;
  }
}
