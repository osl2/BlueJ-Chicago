package osl2.messaging.errorHandling.MapErrors;

import osl2.messaging.errorHandling.UserError;
import osl2.view.ui.localisation.LanguageController;

public class MapNullPointerGetError<T> implements UserError {

    private final String name = "MapNullPointerGet";
    private T key;
    private LanguageController languageController;

    /**
     * Creates a new MappNullPointerGetError
     * @param key The key that can't be removed.
     */
    public MapNullPointerGetError(T key){
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
                key.toString() + languageController.getMessage(this.name + "Get");
    }
}
