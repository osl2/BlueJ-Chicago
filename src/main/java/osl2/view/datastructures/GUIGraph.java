package osl2.view.datastructures;

import osl2.messaging.datastructures.VGraphCommunication;
import osl2.messaging.datastructures.VGraphNodeCommunication;
import osl2.view.datastructures.nodey.GUINodeyDatastructure;

public class GUIGraph<T> extends GUINodeyDatastructure<T, VGraphNodeCommunication<T>> implements VGraphCommunication<T> {

    public GUIGraph() {
        setName("Graph");
    }
}
