package osl2.messaging.errorHandling.TreeErrors;

import osl2.messaging.errorHandling.UserError;
import osl2.view.ui.localisation.LanguageController;

public class TreeToManyChildrenError<T> implements UserError {

    private final String name = "TreeToManyChildren";
    private LanguageController languageController;
    private T parent;

    public TreeToManyChildrenError(T parent){
        this.languageController = LanguageController.getLanguageController();
        this.parent = parent;
    }

    @Override
    public String getErrorName() {
        return this.name;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(this.name + "Parent") +
                parent.toString() + "\n" + languageController.getMessage(this.name + "Children");
    }
}
