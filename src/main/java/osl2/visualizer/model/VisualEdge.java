package osl2.visualizer.model;

import osl2.visualizer.model.VisualNode;

public class VisualEdge {
	private final VisualNode start;
	private final VisualNode end;

	public VisualEdge(VisualNode start, VisualNode end) {
		this.start = start;
		this.end = end;
	}
}

