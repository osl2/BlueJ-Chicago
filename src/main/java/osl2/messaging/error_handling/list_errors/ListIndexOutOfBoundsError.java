package osl2.messaging.error_handling.list_errors;

import osl2.messaging.error_handling.UserError;
import osl2.view.ui.localisation.LanguageController;

/**
 * The class for a ListIndexOutOfBoundsError.
 */
public class ListIndexOutOfBoundsError implements UserError {
    private static final int MIN_INDEX = 0;

    private final int userIndex;
    private final int maxIndex;
    private static final String NAME = "ListIndexOutOfBounds";
    private final LanguageController languageController;

    /**
     * Creates a new ListIndexOutOfBoundsError.
     *
     * @param userIndex
     *         The Index the user used.
     * @param maxIndex
     *         The max index for the error.
     */
    public ListIndexOutOfBoundsError(int userIndex, int maxIndex) {
        this.userIndex = userIndex;
        this.maxIndex = Math.max(maxIndex, 0);
        this.languageController = LanguageController.getLanguageController();
    }

    @Override
    public String getErrorName() {
        return NAME;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(NAME + "User") + userIndex
                + "\n" + languageController.getMessage(NAME + "Index") + "[" + MIN_INDEX + "," + maxIndex + "]";
    }
}

