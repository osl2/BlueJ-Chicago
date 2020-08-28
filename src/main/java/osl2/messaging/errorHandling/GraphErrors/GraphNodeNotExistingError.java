package osl2.messaging.errorHandling.GraphErrors;

import osl2.messaging.errorHandling.UserError;
import osl2.view.ui.localisation.LanguageController;

/**
 * The class for when a node in a graph doesn't exist.
 *
 * @param <T>
 *         The type of the node.
 */
public class GraphNodeNotExistingError<T> implements UserError {
    private final String name = "GraphNodeNotExisting";
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
        return this.name;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(this.name + "Node")
                + node.toString() + "\n" + languageController.getMessage(this.name + "Get");
    }
}
