package osl2.messaging.error_handling.graph_errors;

import osl2.messaging.error_handling.UserError;
import osl2.view.ui.localisation.LanguageController;

/**
 * The class for when a edge in a graph doesn't exist.
 *
 * @param <T>
 *         The datatype of the edge.
 */
public class GraphEdgeNotExistingError<T> implements UserError {

    private static final String NAME = "GraphEdgeNotExisting";
    private final T start;
    private final T end;
    private final LanguageController languageController;

    /**
     * Creates a new GraphEdgeNotExistingError.
     *
     * @param start
     *         The start node for the edge.
     * @param end
     *         The end node for the edge.
     */
    public GraphEdgeNotExistingError(T start, T end) {
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
        return languageController.getMessage(NAME + "Node")
                + start.toString() + "-" + end.toString()
                + "\n" + languageController.getMessage(NAME + "Get");
    }
}
