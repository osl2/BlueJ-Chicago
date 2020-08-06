package osl2.view.ui.settings;

import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import osl2.view.ui.localisation.LANGUAGES;
import osl2.view.ui.localisation.LanguageController;

public class SettingsWindow {
    private final SettingsController settingsController;
    private Stage settingStage;
    private boolean isShown;
    private Pane settingPane;
    private ComboBox<LANGUAGES> languagesComboBox;

    public SettingsWindow(SettingsController settingsController) {
        this.settingsController = settingsController;
        setUp();
        isShown = false;
    }

    private void setUp() {
        setUpPane();
        setUpCombobox();
        setUpSettingStage();
    }

    public void showWindow() {
        if (!isShown) {
            settingStage.show();
            isShown = true;
        }
    }

    private void setUpPane() {
        settingPane = new Pane();
    }

    private void setUpSettingStage() {
        settingStage = new Stage();
        Scene settingScene = new Scene(settingPane, 400, 200);
        settingStage.setTitle(LanguageController.getLanguageController().getMessage("SettingsWindowTitle"));
        settingStage.setScene(settingScene);
        settingStage.setOnCloseRequest(e -> hideWindow());
    }

    private void hideWindow() {
        this.settingStage.hide();
        this.isShown = false;
    }

    private void setUpCombobox() {
        languagesComboBox = new ComboBox<LANGUAGES>();
        languagesComboBox.setItems(FXCollections.observableArrayList(LANGUAGES.values()));
        languagesComboBox.setOnAction(e -> settingsController.setLanguage(languagesComboBox.getValue(), this));
        settingPane.getChildren().add(languagesComboBox);
    }

    public void setTitle(String title) {
        settingStage.setTitle(title);
    }

}
