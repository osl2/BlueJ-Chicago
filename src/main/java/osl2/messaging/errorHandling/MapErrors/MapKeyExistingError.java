package osl2.messaging.errorHandling.MapErrors;

import osl2.messaging.errorHandling.UserError;
import osl2.view.ui.localisation.LanguageController;

/**
 * The class for a error when a key is not in a map.
 *
 * @param <T>
 *         The datatype of the key of the map.
 */
public class MapKeyExistingError<T> implements UserError {

    private final String name = "MapKeyExisting";
    private final LanguageController languageController;
    private final T key;

    /**
     * Creates a new MapKeyExistingError.
     *
     * @param key
     *         The key that already exists in the map.
     */
    public MapKeyExistingError(T key) {
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
