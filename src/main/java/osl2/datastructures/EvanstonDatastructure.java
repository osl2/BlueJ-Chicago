package osl2.datastructures;

import osl2.Evanston;
import osl2.messaging.Broadcaster;
import osl2.messaging.datastructures.DatastructureCommunication;
import osl2.view.datastructures.DatastructureVisualization;

public abstract class EvanstonDatastructure<B extends DatastructureCommunication> {
    private final Broadcaster<B> broadcaster;


    private String name;

    public EvanstonDatastructure() {
        DatastructureVisualization visualization = createVisualization();
        broadcaster = Evanston.openVisualization(this);
    }


    protected Broadcaster<B> getBroadcaster() {
        return broadcaster;
    }

    public abstract DatastructureVisualization createVisualization();

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
        getBroadcaster().send((b) -> b.setName(getDatastructureType() + " : " + this.name));

    }

    public abstract String getDatastructureType();


}
