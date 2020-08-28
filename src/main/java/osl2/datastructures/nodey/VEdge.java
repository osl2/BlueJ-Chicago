package osl2.datastructures.nodey;

import osl2.messaging.datastructures.nodey.VNodeCommunication;

/**
 * Represents an Edge.
 */
public class VEdge<S, E> {

  private final VNode<VNodeCommunication<S>, S> start;
  private final VNode<VNodeCommunication<E>, E> end;

  /**
   * The constructor for the VEdge.
   *
   * @param start
   *         the start node of the edge
   * @param end
   *         the end node of the edge
   */
  public VEdge(VNode<VNodeCommunication<S>, S> start, VNode<VNodeCommunication<E>, E> end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }

    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }

    VEdge<S, E> other = (VEdge) obj;
    return start.equals(other.start)
            && end.equals(other.end);
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 31 * hash + (start == null ? 0 : start.hashCode());
    hash = 31 * hash + (end == null ? 0 : end.hashCode());
    return hash;
  }

  public VNode<VNodeCommunication<S>, S> getStart() {
    return start;
  }

  public VNode<VNodeCommunication<E>, E> getEnd() {
    return end;
  }
}
