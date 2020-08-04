package osl2.view.ui.localisation;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The language controller, which determines the language of the test.
 */
public class LanguageController {

    private Locale locale;
    private ResourceBundle messages;
    private static LanguageController singeltonLanguageController = null;

    /**
     * Creates a new LanguageController.
     */
    public LanguageController(){
        if(singeltonLanguageController == null){
            singeltonLanguageController = this;
        }
    }

    /**
     * Returns the one languagecontroller.
     * @return The languagecontroller.
     */
    public static LanguageController getLanguageController(){
        if(singeltonLanguageController == null){
            new LanguageController();
            return singeltonLanguageController;
        } else {
            return singeltonLanguageController;
        }
    }

    /**
     * Sets all the messages for the language.
     * @param language The language for the messages.
     */
    public void setMessages(LANGUAGES language) {
        locale = new Locale(language.getLanguage(), language.getCountry());
        messages = ResourceBundle.getBundle("MessagesBundle", locale);
    }

    /**
     * Returns the message in the language.
     * @param name The messagekey.
     * @return The message.
     */
    public String getMessage(String name){
        return messages.getString(name);
    }

}
