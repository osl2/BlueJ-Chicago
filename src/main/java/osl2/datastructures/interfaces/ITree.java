package osl2.datastructures.interfaces;

import osl2.datastructures.nodey.VNode;

import java.util.Collection;

/**
 * The interface for a tree object.
 *
 * @param <T> the type of objects which can be added as nodes to the tree.
 */
public interface ITree<T> {
    /**
     * Adds an child to a parent.
     *
     * @param child  the child
     * @param parent the parent
     * @return boolean true if the child as added successfully, else false
     */
    boolean addChild(VNode child, VNode parent);

    /**
     * Removes a node if it is a leave.
     *
     * @param node the node which will be removed
     * @return boolean true if the node was removed successfully, else false
     */
    boolean removeLeave(VNode node);

    /**
     * Returns the children of a parent.
     *
     * @param parent the parent
     * @return Collection<Node> the children of a parent
     */
    Collection<VNode> getChilds(VNode parent);

    /**
     * Returns the parent to a child.
     *
     * @param child the child
     * @return VNode the parent to the child.
     */
    VNode getParent(VNode child);

    /**
     * Returns the height of the tree.
     *
     * @return int the size of the tree.
     */
    int getHeight();

    /**
     * Swaps a child with a parent.
     *
     * @param child  the child
     * @param parent the parent
     * @return boolean true if the swap was successfully, else false
     */
    boolean swap(VNode child, VNode parent);

    /**
     * Adds an tree to this tree.
     *
     * @param parent the parent to wich the tree will be added
     * @param child  the tree wich will be added
     * @return boolean true if the tree was added successfully, else false
     */
    boolean addTree(VNode parent, ITree<T> child);

    /**
     * Indicates if a node is allready in the tree.
     *
     * @param node the node
     * @return boolean true if the node is in the tree, else false
     */
    boolean contains(VNode node);

    /**
     * Indicates if a collection of nodes is allready in the tree.
     *
     * @param nodes the nodes
     * @return boolean true if the nodes are in the tree, else false
     */
    boolean contains(Collection<VNode> nodes);
}
