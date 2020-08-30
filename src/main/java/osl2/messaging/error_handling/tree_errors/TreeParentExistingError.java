package osl2.messaging.error_handling.tree_errors;

import osl2.messaging.error_handling.UserError;
import osl2.view.ui.localisation.LanguageController;

/**
 * Creates a new error for when a parent isn't existing.
 *
 * @param <T>
 *         The type of the node.
 */
public class TreeParentExistingError<T> implements UserError {
    private static final String NAME = "TreeParentExisting";
    private final LanguageController languageController;
    private final T parent;

    /**
     * Creates a new TreeParentExistingError.
     *
     * @param parent
     *         The nonexisiting parent.
     */
    public TreeParentExistingError(T parent) {
        this.languageController = LanguageController.getLanguageController();
        this.parent = parent;
    }

    @Override
    public String getErrorName() {
        return NAME;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(NAME + "Parent")
                + parent.toString() + "\n" + languageController.getMessage(NAME + "Exist");
    }
}
