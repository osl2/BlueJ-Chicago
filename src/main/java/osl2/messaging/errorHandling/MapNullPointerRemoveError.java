package osl2.messaging.errorHandling;

import osl2.view.ui.localisation.LanguageController;

public class MapNullPointerRemoveError<T> implements UserError {

    private final String name = "MapNullPointerRemove";
    private T key;
    private LanguageController languageController;

    /**
     * Creates a new MappNullPointerRemoveError
     * @param key The key that can't be removed.
     */
    public MapNullPointerRemoveError(T key){
        this.key = key;
        this.languageController = LanguageController.getLanguageController();
    }

    @Override
    public String getErrorName() {
        return this.name;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(this.name + "Key") +
                key.toString() + languageController.getMessage(this.name + "Removed");
    }
}
