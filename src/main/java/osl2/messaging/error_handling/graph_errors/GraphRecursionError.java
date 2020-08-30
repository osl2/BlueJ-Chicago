package osl2.messaging.error_handling.graph_errors;

import osl2.messaging.error_handling.UserError;
import osl2.view.ui.localisation.LanguageController;

/**
 * The class for a error when a graph would be inserted into itself.
 */
public class GraphRecursionError implements UserError {

    private static final String NAME = "GraphRecursion";
    private final LanguageController languageController;

    /**
     * Creates a new GraphRecursionError.
     */
    public GraphRecursionError() {
        this.languageController = LanguageController.getLanguageController();
    }

    @Override
    public String getErrorName() {
        return NAME;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(NAME);
    }
}