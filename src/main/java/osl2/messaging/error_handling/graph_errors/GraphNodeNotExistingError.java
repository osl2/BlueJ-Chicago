package osl2.messaging.error_handling.graph_errors;

import osl2.messaging.error_handling.UserError;
import osl2.view.ui.localisation.LanguageController;

/**
 * The class for when a node in a graph doesn't exist.
 *
 * @param <T>
 *         The type of the node.
 */
public class GraphNodeNotExistingError<T> implements UserError {
    private static final String NAME = "GraphNodeNotExisting";
    private final T node;
    private final LanguageController languageController;

    /**
     * Creates a new GraphNodeNotExistingError.
     *
     * @param node
     *         The node.
     */
    public GraphNodeNotExistingError(T node) {
        this.languageController = LanguageController.getLanguageController();
        this.node = node;
    }

    @Override
    public String getErrorName() {
        return NAME;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(NAME + "Node")
                + node.toString() + "\n" + languageController.getMessage(NAME + "Get");
    }
}
