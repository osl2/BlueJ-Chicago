package osl2.messaging.error_handling.tree_errors;

import osl2.messaging.error_handling.UserError;
import osl2.view.ui.localisation.LanguageController;

public class TreeNoChildError<T> implements UserError {
    private static final String NAME = "TreeNoChild";
    private final LanguageController languageController;
    private final T parent;

    /**
     * Creates a new TreeNoChildError.
     *
     * @param parent
     *         The parent without children.
     */
    public TreeNoChildError(T parent) {
        this.languageController = LanguageController.getLanguageController();
        this.parent = parent;
    }

    @Override
    public String getErrorName() {
        return NAME;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(NAME + "Parent") + parent.toString() + "\n"
                + languageController.getMessage(NAME + "NoChild");
    }
}
