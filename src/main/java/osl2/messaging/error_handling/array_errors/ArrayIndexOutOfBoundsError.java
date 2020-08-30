package osl2.messaging.error_handling.array_errors;

import osl2.messaging.error_handling.UserError;
import osl2.view.ui.localisation.LanguageController;

/**
 * The class for an ArrayIndexOutOfBoundsError.
 */
public class ArrayIndexOutOfBoundsError implements UserError {
    private static final int MIN_INDEX = 0;
    private static final String NAME = "ArrayIndexOutOfBounds";
    private final int userIndex;
    private final int maxIndex;
    private final LanguageController languageController;

    /**
     * Creates a new ArrayIndexOutOfBoundsError.
     *
     * @param userIndex
     *         The Index the user used.
     * @param maxIndex
     *         The max index for the error.
     */
    public ArrayIndexOutOfBoundsError(int userIndex, int maxIndex) {
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
        return languageController.getMessage(NAME + "User") + userIndex + "\n"
                + languageController.getMessage(NAME + "Index") + "[" + MIN_INDEX + "," + maxIndex + "]";
    }
}
