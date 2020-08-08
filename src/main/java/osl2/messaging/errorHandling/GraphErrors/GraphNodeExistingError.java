package osl2.messaging.errorHandling.GraphErrors;

import osl2.messaging.errorHandling.UserError;
import osl2.view.ui.localisation.LanguageController;

/**
 * The class for when a node in a graph allready exist.
 * @param <T> The type of the node.
 */
public class GraphNodeExistingError<T> implements UserError {

    private final String name = "GraphNodeExisting";
    private T node;
    private LanguageController languageController;

    /**
     * Creates a new GraphNodeExistingError.
     * @param node The node.
     */
    public GraphNodeExistingError(T node){
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
                + node.toString() + "\n" + languageController.getMessage(this.name + "Add");
    }
}
