package osl2.visualizer.model;

public class VisualNode<T> {
	private final T value;

	public VisualNode(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}
}

