package osl2.view.ui.settings;

import osl2.view.ui.EvanstonWindow;
import osl2.view.ui.FontSize;
import osl2.view.ui.localisation.LANGUAGES;
import osl2.view.ui.localisation.LanguageController;

public class SettingsController {
    private final SettingsWindow settingsWindow;
    private final EvanstonWindow evanstonWindow;

    public SettingsController(EvanstonWindow evanstonWindow) {
        this.evanstonWindow = evanstonWindow;
        this.settingsWindow = new SettingsWindow(this, evanstonWindow.getStage());
    }

    public void openSettingsWindow() {
        settingsWindow.showWindow();
    }

    public void setLanguage(LANGUAGES language, SettingsWindow settingsWindow) {
        LanguageController.getLanguageController().setMessages(language);
        settingsWindow.setTitle(LanguageController.getLanguageController().getMessage("SettingsWindowTitle"));
    }

    public void setFontSize(FontSize fontSize) {
        this.evanstonWindow.setFontSize(fontSize);
    }
}
