package osl2.Chicago;

/**
 * The interface for a tree object.
 * @param <T> the type of objects which can be added as nodes to the tree.
 */
public interface ITree<T> {
    /**
     * Adds an child to a parent.
     * @param child the child
     * @param parent the parent
     * @return boolean true if the child as added successfully, else false
     */
    public boolean addChild(VNode<T> child, VNode<T> parent);

    /**
     * Removes a node if it is a leave.
     * @param node the node which will be removed
     * @return boolean true if the node was removed successfully, else false
     */
    public boolean removeLeave(VNode<T> node);

    /**
     * Returns the children of a parent.
     * @param parent the parent
     * @return Collection<Node> the children of a parent
     */
    public Collection<VNode<T>> getChilds(VNode<T> parent);

    /**
     * Returns the parent to a child.
     * @param child the child
     * @return VNode the parent to the child.
     */
    public VNode<T> getParent(VNode<T> child);

    /**
     * Returns the height of the tree.
     * @return int the size of the tree.
     */
    public int getHeight();

    /**
     * Swaps a child with a parent.
     * @param child the child
     * @param parent the parent
     * @return boolean true if the swap was successfully, else false
     */
    public boolean swap(VNode<T> child, VNode<T> parent);

    /**
     * Adds an tree to this tree.
     * @param parent the parent to wich the tree will be added
     * @param child the tree wich will be added
     * @return boolean true if the tree was added successfully, else false
     */
    public boolean addTree(VNode<T> parent, ITree<T> child);

    /**
     * Indicates if a node is allready in the tree.
     * @param node the node
     * @return boolean true if the node is in the tree, else false
     */
    public boolean contains(VNode<T> node);

    /**
     * Indicates if a collection of nodes is allready in the tree.
     * @param nodes the nodes
     * @return boolean true if the nodes are in the tree, else false
     */
    public boolean contains(Collection<VNode<T>> nodes);
}
