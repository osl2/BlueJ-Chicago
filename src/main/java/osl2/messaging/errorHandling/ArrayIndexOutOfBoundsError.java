package osl2.messaging.errorHandling;

import osl2.view.ui.localisation.LanguageController;

public class ArrayIndexOutOfBoundsError implements UserError {
    private static final int MIN_INDEX = 0;

    private final int userIndex;
    private final int maxIndex;
    private final String name = "ArrayIndexIndexOutOfBounds";
    private LanguageController languageController;

    public ArrayIndexOutOfBoundsError(int userIndex, int maxIndex) {
        this.userIndex = userIndex;
        this.maxIndex = maxIndex;
        this.languageController = LanguageController.getLanguageController();
    }

    @Override
    public String getErrorName() {
        return this.name;
    }

    @Override
    public String getErrorContent() {
        return languageController.getMessage(this.name + "User") + userIndex + "\n" + languageController.getMessage(this.name + "Index")+ "[" + MIN_INDEX + "," + maxIndex + "]";
    }
}
