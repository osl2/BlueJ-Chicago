package osl2.datastructures;

import osl2.Evanston;
import osl2.messaging.Broadcaster;
import osl2.view.datastructures.DatastructureVisualization;

public abstract class EvanstonDatastructure<B> {
    private final Broadcaster<B> broadcaster;

    public EvanstonDatastructure() {
        DatastructureVisualization visualization = createVisualization();
        broadcaster = new Broadcaster(visualization);
        Evanston.openVisualization(visualization);
    }

    protected Broadcaster<B> getBroadcaster() {
        return broadcaster;
    }

    public abstract DatastructureVisualization createVisualization();
}
