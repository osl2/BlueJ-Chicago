package osl2.messaging.errorHandling.TreeErrors;

import osl2.messaging.errorHandling.UserError;
import osl2.view.ui.localisation.LanguageController;

/**
 * Creates a error for when a parent in a tree has too many children.
 * @param <T> The type of the node.
 */
public class TreeToManyChildrenError<T> implements UserError {

    private final String name = "TreeToManyChildren";
    private LanguageController languageController;
    private T parent;

    /**
     * Creates a new TreeToManyChildrenError.
     * @param parent The parent which has enough children.
     */
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
