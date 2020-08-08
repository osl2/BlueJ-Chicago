package osl2.messaging.errorHandling;

import osl2.view.ui.localisation.LanguageController;

public class MapKeyExistingError<T> implements UserError {

    private final String name = "MapKeyExisting";
    private LanguageController languageController;
    private T key;

    /**
     * Creates a new MapKeyExistingError.
     * @param key The key that already exists in the map.
     */
    public MapKeyExistingError(T key){
        this.key = key;
        languageController = LanguageController.getLanguageController();
    }

    @Override
    public String getErrorName() {
        return this.name;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(this.name + "Key")
                + key.toString() + "\n" + languageController.getMessage(this.name + "Add");
    }
}
