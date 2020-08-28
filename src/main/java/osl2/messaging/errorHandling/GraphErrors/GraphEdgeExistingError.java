package osl2.messaging.errorHandling.GraphErrors;

import osl2.messaging.errorHandling.UserError;
import osl2.view.ui.localisation.LanguageController;

/**
 * The class for when a edge in a graph allready exist.
 * @param <T> The datatype of the edge.
 */
public class GraphEdgeExistingError<T> implements UserError {

    private final String name = "GraphEdgeExisting";
    private T start;
    private T end;
    private LanguageController languageController;

    /**
     * Creates a new GraphEdgeExistingError.
     * @param start The startnode for the edge.
     * @param end The endnode for the edge.
     */
    public GraphEdgeExistingError(T start , T end){
        this.languageController = LanguageController.getLanguageController();
        this.start = start;
        this.end = end;
    }

    @Override
    public String getErrorName() {
        return this.name;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(this.name + "Edge")
                + start.toString() + "-" + end.toString() +
                "\n" + languageController.getMessage(this.name + "Add");
    }
}
