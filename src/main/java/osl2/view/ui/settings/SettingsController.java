package osl2.view.ui.settings;

import osl2.view.ui.EvanstonWindow;
import osl2.view.ui.FontSize;
import osl2.view.ui.Theme;
import osl2.view.ui.localisation.LANGUAGES;
import osl2.view.ui.localisation.LanguageController;

/**
 * The Controller for a Settingswindow.
 */
public class SettingsController {
    private final SettingsWindow settingsWindow;
    private final EvanstonWindow evanstonWindow;

    /**
     * Creates a new SettingsController.
     *
     * @param evanstonWindow
     *         The Mainwindow to which the settings belong.
     */
    public SettingsController(EvanstonWindow evanstonWindow) {
        this.evanstonWindow = evanstonWindow;
        this.settingsWindow = new SettingsWindow(this, evanstonWindow.getStage());
    }

    /**
     * Opens the Settingswindow.
     */
    public void openSettingsWindow() {
        settingsWindow.showWindow();
    }

    /**
     * Sets the language which was selected.
     *
     * @param language
     *         The new language.
     * @param settingsWindow
     *         The settingswindow to which it is part of.
     */
    public void setLanguage(LANGUAGES language, SettingsWindow settingsWindow) {
        LanguageController.getLanguageController().setMessages(language);
        settingsWindow.setWithNewLanguage();
    }

    /**
     * Changes the font size in the application.
     *
     * @param fontSize
     *         - the new {@link FontSize} to be used
     */
    public void setFontSize(FontSize fontSize) {
        this.evanstonWindow.setFontSize(fontSize);
        this.settingsWindow.setFontSize(fontSize);
    }

    /**
     * Changes the theme of the application.
     *
     * @param theme
     *         - the new {@link Theme} to be used
     */
    public void setTheme(Theme theme) {
        this.evanstonWindow.setTheme(theme);
        this.settingsWindow.setTheme(theme);
    }
}
