package osl2.messaging.error_handling.graph_errors;

import osl2.messaging.error_handling.UserError;
import osl2.view.ui.localisation.LanguageController;

/**
 * The class for when a edge in a graph already exists.
 *
 * @param <T>
 *         The datatype of the edge.
 */
public class GraphEdgeExistingError<T> implements UserError {

    private static final String NAME = "GraphEdgeExisting";
    private final T start;
    private final T end;
    private final LanguageController languageController;

    /**
     * Creates a new GraphEdgeExistingError.
     *
     * @param start
     *         The start node for the edge.
     * @param end
     *         The end node for the edge.
     */
    public GraphEdgeExistingError(T start, T end) {
        this.languageController = LanguageController.getLanguageController();
        this.start = start;
        this.end = end;
    }

    @Override
    public String getErrorName() {
        return NAME;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(NAME + "Edge")
                + start.toString() + "-" + end.toString()
                + "\n" + languageController.getMessage(NAME + "Add");
    }
}
