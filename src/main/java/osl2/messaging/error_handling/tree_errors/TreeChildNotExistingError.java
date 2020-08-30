package osl2.messaging.error_handling.tree_errors;

import osl2.messaging.error_handling.UserError;
import osl2.view.ui.localisation.LanguageController;

/**
 * The class for a Error, when the child doesn't exist.
 *
 * @param <T>
 *         The type of the node.
 */
public class TreeChildNotExistingError<T> implements UserError {

    private static final String NAME = "TreeChildNotExisting";
    private final LanguageController languageController;
    private final T parent;
    private final T child;

    /**
     * Creates a new TreeChildNotExistingError.
     *
     * @param parent
     *         The parent.
     * @param child
     *         The none existing child.
     */
    public TreeChildNotExistingError(T parent, T child) {
        this.languageController = LanguageController.getLanguageController();
        this.parent = parent;
        this.child = child;
    }

    @Override
    public String getErrorName() {
        return NAME;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(NAME + "Child") + child.toString() + "\n"
                + languageController.getMessage(NAME + "Parent") + parent.toString() + "\n"
                + languageController.getMessage(NAME + "Exist");
    }
}
