package osl2.messaging.errorHandling.TreeErrors;

import osl2.messaging.errorHandling.UserError;
import osl2.view.ui.localisation.LanguageController;

public class TreeNotALeafError<T> implements UserError {


    private final String name = "TreeNotALeaf";
    private LanguageController languageController;
    private T child;

    /**
     * Creates a new TreeNotALeafError.
     * @param child The child, thats not a leaf.
     */
    public TreeNotALeafError(T child){
        this.languageController = LanguageController.getLanguageController();
        this.child = child;
    }

    @Override
    public String getErrorName() {
        return this.name;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(this.name + "Child") + child.toString() + "\n"
                + languageController.getMessage(this.name + "NotLeaf");
    }
}
