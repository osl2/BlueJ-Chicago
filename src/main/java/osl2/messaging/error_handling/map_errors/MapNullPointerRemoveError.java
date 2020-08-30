package osl2.messaging.error_handling.map_errors;

import osl2.messaging.error_handling.UserError;
import osl2.view.ui.localisation.LanguageController;

/**
 * Creates a NullPointer Error when trying to remove.
 *
 * @param <T>
 *         The key datatype of the map.
 */
public class MapNullPointerRemoveError<T> implements UserError {

    private static final String NAME = "MapNullPointerRemove";
    private final T key;
    private final LanguageController languageController;

    /**
     * Creates a new MapNullPointerRemoveError.
     *
     * @param key
     *         The key that can't be removed.
     */
    public MapNullPointerRemoveError(T key) {
        this.key = key;
        this.languageController = LanguageController.getLanguageController();
    }

    @Override
    public String getErrorName() {
        return NAME;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(NAME + "Key")
                + key.toString() + languageController.getMessage(NAME + "Removed");
    }
}
