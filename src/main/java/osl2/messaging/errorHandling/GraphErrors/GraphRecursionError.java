package osl2.messaging.errorHandling.GraphErrors;

import javafx.scene.canvas.GraphicsContext;
import osl2.messaging.errorHandling.UserError;
import osl2.view.ui.localisation.LanguageController;

/**
 * The class for a error when a graph would be inserted into itself.
 */
public class GraphRecursionError implements UserError {

    private final String name = "GraphRecursion";
    private LanguageController languageController;

    /**
     * Creates a new GraphRecursionError.
     */
    public GraphRecursionError(){
        this.languageController = LanguageController.getLanguageController();
    }

    @Override
    public String getErrorName() {
        return this.name;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(this.name);
    }
}