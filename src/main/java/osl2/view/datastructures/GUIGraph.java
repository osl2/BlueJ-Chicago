package osl2.view.datastructures;

import osl2.messaging.datastructures.VGraphCommunication;
import osl2.messaging.datastructures.VGraphNodeCommunication;
import osl2.view.datastructures.nodey.GUINodeyDatastructure;

/**
 * The Visualisation of a Graph.
 *
 * @param <T> The datatype of the datastructure.
 */
public class GUIGraph<T> extends GUINodeyDatastructure<T, VGraphNodeCommunication<T>> implements VGraphCommunication<T> {

    /**
     * Creates a new graph visualisation.
     */
    public GUIGraph() {
        setName("Graph");
    }
}
