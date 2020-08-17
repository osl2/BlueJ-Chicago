package osl2.datastructures.interfaces;

import osl2.datastructures.nodey.VGraphNode;

import java.util.Collection;

/**
 * The interface for a tree object.
 *
 * @param <T> - the type of objects which can be added as nodes to the tree.
 */
public interface ITree<T> {

    /**
     * Create a node and add it to the tree.
     *
     * @return the created node
     */
    VGraphNode<T> addTreeNode();

    /**
     * Adds a child to a parent.
     *
     * @param child  - the child
     * @param parent - the parent
     * @return true if the child as added successfully, else false
     */
    boolean addChild(VGraphNode<T> child, VGraphNode<T> parent);

    /**
     * Removes a node if it is a leave.
     *
     * @param node - the node to be removed
     * @return true if the node was removed successfully, else false
     */
    boolean removeLeaf(VGraphNode<T> node);

    /**
     * Gets the children of a parent.
     *
     * @param parent - the parent
     * @return the children of a parent
     */
    Collection<VGraphNode<T>> getChildren(VGraphNode<T> parent);

    /**
     * Gets the parent to a child.
     *
     * @param child - the child
     * @return the parent to the child
     */
    VGraphNode<T> getParent(VGraphNode<T> child);

    /**
     * Gets the height of the tree.
     *
     * @return the size of the tree
     */
    int getHeight();

    /**
     * Swaps a child with a parent.
     *
     * @param child  - the child
     * @param parent - the parent
     * @return true if the swap was successfully, else false
     */
    boolean swap(VGraphNode<T> child, VGraphNode<T> parent);

    /**
     * Indicates if a node is already in the tree.
     *
     * @param node - the node
     * @return true if the node is in the tree, else false
     */
    boolean contains(VGraphNode<T> node);

    /**
     * Indicates if a collection of nodes is already in the tree.
     *
     * @param nodes - the nodes
     * @return true if the nodes are in the tree, else false
     */
    boolean contains(Collection<VGraphNode<T>> nodes);

    /**
     * Gets the root node.
     *
     * @return the root node
     */
    VGraphNode<T> getRootNode();
}
