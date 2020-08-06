package osl2.view.ui.settings;

import osl2.view.ui.localisation.LANGUAGES;
import osl2.view.ui.localisation.LanguageController;

public class SettingsController {
    private final SettingsWindow settingsWindow;

    public SettingsController() {
        this.settingsWindow = new SettingsWindow(this);
    }

    public void openSettingsWindow() {
        settingsWindow.showWindow();
    }

    public void setLanguage(LANGUAGES language, SettingsWindow settingsWindow) {
        LanguageController.getLanguageController().setMessages(language);
        settingsWindow.setTitle(LanguageController.getLanguageController().getMessage("SettingsWindowTitle"));
    }
}
