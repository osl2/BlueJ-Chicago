package osl2.view.ui.localisation;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The language controller, which determines the language of the test.
 */
public class LanguageController {
    private static LanguageController singeltonLanguageController = null;
    private ResourceBundle messages;
    private Languages language;

    /**
     * Creates a new LanguageController.
     */
    private LanguageController() {
        if (singeltonLanguageController == null) {
            singeltonLanguageController = this;
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
        if (singeltonLanguageController == null) {
            new LanguageController();
            return singeltonLanguageController;
        } else {
            return singeltonLanguageController;
        }
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
