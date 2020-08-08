package osl2.messaging.errorHandling;

import osl2.view.ui.localisation.LanguageController;

public class TreeChildNotExistingError<T> implements UserError {

    private final String name = "TreeChildNotExisting";
    private LanguageController languageController;
    private T parent;
    private T child;

    public TreeChildNotExistingError(T parent, T child){
        this.languageController = LanguageController.getLanguageController();
        this.parent = parent;
        this.child = child;
    }

    @Override
    public String getErrorName() {
        return this.name;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(this.name + "Child") + child.toString() + "\n"
                + languageController.getMessage(this.name + "Parent") + parent.toString() + "\n"
                + languageController.getMessage(this.name + "Exist");
    }
}
