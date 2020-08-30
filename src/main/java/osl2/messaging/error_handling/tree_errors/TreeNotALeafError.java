package osl2.messaging.error_handling.tree_errors;

import osl2.messaging.error_handling.UserError;
import osl2.view.ui.localisation.LanguageController;

public class TreeNotALeafError<T> implements UserError {
    private static final String NAME = "TreeNotALeaf";
    private final LanguageController languageController;
    private final T child;

    /**
     * Creates a new TreeNotALeafError.
     *
     * @param child
     *         The child, that's not a leaf.
     */
    public TreeNotALeafError(T child) {
        this.languageController = LanguageController.getLanguageController();
        this.child = child;
    }

    @Override
    public String getErrorName() {
        return NAME;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(NAME + "Child") + child.toString() + "\n"
                + languageController.getMessage(NAME + "NotLeaf");
    }
}
