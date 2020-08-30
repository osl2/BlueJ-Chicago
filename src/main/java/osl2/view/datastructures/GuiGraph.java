package osl2.view.datastructures;

import osl2.messaging.datastructures.VGraphCommunication;
import osl2.messaging.datastructures.VGraphNodeCommunication;
import osl2.view.datastructures.nodey.GuiNodeyDatastructure;

/**
 * The Visualisation of a Graph.
 *
 * @param <T>
 *         The datatype of the datastructure.
 */
public class GuiGraph<T> extends GuiNodeyDatastructure<T, VGraphNodeCommunication<T>>
        implements VGraphCommunication<T> {

    /**
     * Creates a new graph visualisation.
     */
    public GuiGraph() {
        setName("Graph");
    }
}
