package osl2.messaging.errorHandling.GraphErrors;

import osl2.messaging.errorHandling.UserError;
import osl2.view.ui.localisation.LanguageController;

public class GraphNodeExisitingError<T> implements UserError {

    private final String name = "GraphNodeExisiting";
    private T node;
    private LanguageController languageController;

    public GraphNodeExisitingError(T node){
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
