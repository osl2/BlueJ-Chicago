package osl2.messaging.errorHandling.TreeErrors;

import osl2.messaging.errorHandling.UserError;
import osl2.view.ui.localisation.LanguageController;

/**
 * The class for a Error, when the child doesn't exist.
 *
 * @param <T>
 *         The type of the node.
 */
public class TreeChildNotExistingError<T> implements UserError {

    private final String name = "TreeChildNotExisting";
    private final LanguageController languageController;
    private final T parent;
    private final T child;

    /**
     * Creates a new TreeChildNotExistingError.
     *
     * @param parent
     *         The parent.
     * @param child
     *         The nonexisting child.
     */
    public TreeChildNotExistingError(T parent, T child) {
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
