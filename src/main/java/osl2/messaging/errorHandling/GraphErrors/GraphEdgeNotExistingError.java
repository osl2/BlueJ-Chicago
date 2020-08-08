package osl2.messaging.errorHandling.GraphErrors;

import osl2.messaging.errorHandling.UserError;
import osl2.view.ui.localisation.LanguageController;

/**
 * The class for when a edge in a graph doesn't exist.
 * @param <T> The datatype of the edge.
 */
public class GraphEdgeNotExistingError<T> implements UserError {

    private final String name = "GraphEdgeNotExisting";
    private T edge;
    private LanguageController languageController;

    /**
     * Creates a new GraphEdgeNotExistingError.
     * @param edge The edge.
     */
    public GraphEdgeNotExistingError(T edge){
        this.languageController = LanguageController.getLanguageController();
        this.edge = edge;
    }

    @Override
    public String getErrorName() {
        return this.name;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(this.name + "Node")
                + edge.toString() + "\n" + languageController.getMessage(this.name + "Get");
    }
}
