package osl2.visualizer.model;

import java.beans.PropertyChangeListener;

public abstract class VisualDatastructure implements IModel {
	private PropertyChangeListener listener;


	protected VisualDatastructure() {
	}

	public abstract Datastructure getDatastructureType();

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.listener = listener;
	}
}
