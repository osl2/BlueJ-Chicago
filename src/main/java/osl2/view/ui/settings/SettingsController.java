package osl2.view.ui.settings;

import osl2.view.ui.SettingWindow;
import osl2.view.ui.localisation.LANGUAGES;
import osl2.view.ui.localisation.LanguageController;

public class SettingsController {

    public void openSettingsWindow(SettingWindow settingWindow){
        settingWindow.showWindow();
    }

    public void setLanguage(LANGUAGES language, SettingWindow settingWindow){
        LanguageController.getLanguageController().setMessages(language);
        settingWindow.setTitle(LanguageController.getLanguageController().getMessage("Setting"));
    }
}
