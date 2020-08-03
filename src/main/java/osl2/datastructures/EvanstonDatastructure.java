package osl2.datastructures;

import osl2.Evanston;
import osl2.messaging.Broadcaster;
import osl2.view.datastructures.DatastructureVisualization;
import osl2.view.inlinerepresentation.InlineRepresentation;
import osl2.view.ui.mirror.MirrorController;

public abstract class EvanstonDatastructure<B> {
    private final Broadcaster<B> broadcaster;

    public EvanstonDatastructure() {
        DatastructureVisualization visualization = createVisualization();
        broadcaster = Evanston.openVisualization(this);
    }

    protected Broadcaster<B> getBroadcaster() {
        return broadcaster;
    }

    public abstract DatastructureVisualization createVisualization();
}
