package osl2.Chicago;

public class VNode<T> {

    private T value;

    /**
     * Creates a new
     * @param value
     */
    public VNode(T value){
        this.value = value;
    }

    /**
     * Returns the value of the node.
     * @return T the value of the node
     */
    public T getValue(){
        return this.value;
    }
}
