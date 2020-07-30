package osl2.evanston.datastructures;

import osl2.evanston.Evanston;
import osl2.evanston.messaging.Broadcaster;
import osl2.evanston.view.datastructures.DatastructureVisualization;

public abstract class EvanstonDatastructure<B> {
    private final Broadcaster<B> broadcaster;

    protected Broadcaster<B> getBroadcaster() {
        return broadcaster;
    }

    public abstract DatastructureVisualization createVisualization();

    public EvanstonDatastructure() {
        DatastructureVisualization visualization = createVisualization();
        broadcaster = new Broadcaster(visualization);
        Evanston.openVisualization(visualization);
    }
}
