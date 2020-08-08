package osl2.messaging.errorHandling.GraphErrors;

import osl2.messaging.errorHandling.UserError;
import osl2.view.ui.localisation.LanguageController;

/**
 * The class for when a edge in a graph allready exist.
 * @param <T> The datatype of the edge.
 */
public class GraphEdgeExistingError<T> implements UserError {

    private final String name = "GraphEdgeExisting";
    private T edge;
    private LanguageController languageController;

    /**
     * Creates a new GraphEdgeExistingError.
     * @param edge The edge.
     */
    public GraphEdgeExistingError(T edge){
        this.languageController = LanguageController.getLanguageController();
        this.edge = edge;
    }

    @Override
    public String getErrorName() {
        return this.name;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(this.name + "Edge")
                + edge.toString() + "\n" + languageController.getMessage(this.name + "Add");
    }
}
