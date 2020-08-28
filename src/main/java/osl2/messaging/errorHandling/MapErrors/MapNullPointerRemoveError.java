package osl2.messaging.errorHandling.MapErrors;

import osl2.messaging.errorHandling.UserError;
import osl2.view.ui.localisation.LanguageController;

/**
 * Creates a NullPointer Error when trying to remove.
 *
 * @param <T>
 *         The key datatype of the map.
 */
public class MapNullPointerRemoveError<T> implements UserError {

    private final String name = "MapNullPointerRemove";
    private final T key;
    private final LanguageController languageController;

    /**
     * Creates a new MappNullPointerRemoveError
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
        return this.name;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(this.name + "Key") +
                key.toString() + languageController.getMessage(this.name + "Removed");
    }
}
