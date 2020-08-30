package osl2.messaging.error_handling.map_errors;

import osl2.messaging.error_handling.UserError;
import osl2.view.ui.localisation.LanguageController;

/**
 * The class for a error when a key is not in a map.
 *
 * @param <T>
 *         The datatype of the key of the map.
 */
public class MapKeyExistingError<T> implements UserError {

    private static final String NAME = "MapKeyExisting";
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
        return NAME;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(NAME + "Key")
                + key.toString() + "\n" + languageController.getMessage(NAME + "Add");
    }
}
