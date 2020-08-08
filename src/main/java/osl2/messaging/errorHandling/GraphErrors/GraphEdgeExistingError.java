package osl2.messaging.errorHandling.GraphErrors;

import osl2.messaging.errorHandling.UserError;
import osl2.view.ui.localisation.LanguageController;

public class GraphEdgeExistingError<T> implements UserError {

    private final String name = "GraphEdgeExisting";
    private T edge;
    private LanguageController languageController;

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
