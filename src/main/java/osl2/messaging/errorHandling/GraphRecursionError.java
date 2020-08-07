package osl2.messaging.errorHandling;

import javafx.scene.canvas.GraphicsContext;
import osl2.view.ui.localisation.LanguageController;

public class GraphRecursionError implements UserError {

    private final String name = "GraphRecursion";
    private LanguageController languageController;

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
