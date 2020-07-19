public class VNode<T> {
	private final T value;

	public VNode(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}
}

