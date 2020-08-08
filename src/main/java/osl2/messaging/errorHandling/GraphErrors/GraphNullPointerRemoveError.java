package osl2.messaging.errorHandling.GraphErrors;

import osl2.messaging.errorHandling.UserError;
import osl2.view.ui.localisation.LanguageController;

public class GraphNullPointerRemoveError<T> implements UserError {

    private final String name = "GraphNullPointerRemove";
    private LanguageController languageController;
    private T node;

    public GraphNullPointerRemoveError(T node){
        this.languageController = LanguageController.getLanguageController();
        this.node = node;
    }

    @Override
    public String getErrorName() {
        return this.name;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(this.name + node)
                + node.toString()  + "\n" + languageController.getMessage(this.name + "Remove");
    }
}