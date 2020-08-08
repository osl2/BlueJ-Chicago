package osl2.messaging.errorHandling.ArrayErrors;

import osl2.messaging.errorHandling.UserError;
import osl2.view.ui.localisation.LanguageController;

/**
 * The class for an ArrayIndexOutOfBoundsError.
 */
public class ArrayIndexOutOfBoundsError implements UserError {
    private static final int MIN_INDEX = 0;

    private final int userIndex;
    private final int MAX_INDEX;
    private final String name = "ArrayIndexOutOfBounds";
    private LanguageController languageController;

    /**
     * Creates a new ArrayIndexOutOfBoundsError.
     * @param userIndex The Index the user used.
     * @param MAX_INDEX The max index for the error.
     */
    public ArrayIndexOutOfBoundsError(int userIndex, int MAX_INDEX) {
        this.userIndex = userIndex;
        if(MAX_INDEX < 0){
            this.MAX_INDEX = 0;
        } else {
            this.MAX_INDEX = MAX_INDEX;
        }
        this.languageController = LanguageController.getLanguageController();
    }

    @Override
    public String getErrorName() {
        return this.name;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(this.name + "User") + userIndex +
                "\n" + languageController.getMessage(this.name + "Index") + "[" + MIN_INDEX + "," + MAX_INDEX + "]";
    }
}
