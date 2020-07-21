package osl2.visualizer.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class VisualSinglyLinkedList<T> extends VisualList<T> {
	private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	@Override
	public Datastructure getDatastructureType() {
		return Datastructure.DS_SINGLY_LINKED_LIST;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		pcs.addPropertyChangeListener(listener);
	}
}
