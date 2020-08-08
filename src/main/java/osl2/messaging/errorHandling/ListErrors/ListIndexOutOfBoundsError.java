package osl2.messaging.errorHandling.ListErrors;

import osl2.messaging.errorHandling.UserError;
import osl2.view.ui.localisation.LanguageController;

public class ListIndexOutOfBoundsError implements UserError {
    private static final int MIN_INDEX = 0;

    private final int userIndex;
    private final int MAX_INDEX;
    private final String name = "ListIndexOutOfBounds";
    private LanguageController languageController;

    public ListIndexOutOfBoundsError(int userIndex, int MAX_INDEX) {
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

