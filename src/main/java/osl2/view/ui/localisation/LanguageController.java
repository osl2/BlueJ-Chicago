package osl2.view.ui.localisation;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The language controller, which determines the language of the test.
 */
public class LanguageController {
    private static LanguageController singletonLanguageController = null;
    private ResourceBundle messages;
    private Languages language;

    /**
     * Creates a new LanguageController.
     */
    private LanguageController() {
        if (singletonLanguageController == null) {
            singletonLanguageController = this;
            language = Languages.GERMAN;
            setMessages(language);
        }
    }

    /**
     * Returns the one language controller.
     *
     * @return The language controller.
     */
    public static LanguageController getLanguageController() {
        if (singletonLanguageController == null) {
            new LanguageController();
        }
        return singletonLanguageController;
    }

    /**
     * Sets all the messages for the language.
     *
     * @param language
     *         The language for the messages.
     */
    public void setMessages(Languages language) {
        Locale locale = new Locale(language.getLanguage(), language.getCountry());
        messages = ResourceBundle.getBundle("MessagesBundle", locale);
    }

    /**
     * Returns the message in the language.
     *
     * @param name
     *         The message key.
     * @return The message.
     */
    public String getMessage(String name) {
        if (messages == null) {
            messages = ResourceBundle.getBundle("MessagesBundle");
        }
        return messages.getString(name);
    }

    /**
     * Returns the language which is now active.
     *
     * @return The language.
     */
    public Languages getLanguage() {
        return this.language;
    }
}
