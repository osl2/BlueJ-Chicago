package osl2.view.ui;

import javafx.collections.FXCollections;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import osl2.view.ui.localisation.LANGUAGES;
import osl2.view.ui.localisation.LanguageController;
import osl2.view.ui.settings.SettingsController;

import static osl2.view.ui.localisation.LANGUAGES.*;

public class SettingWindow {

    private Stage settingStage;
    private Scene settingScene;
    private SettingsController settingsController;
    private boolean isShown;
    private Pane settingPane;
    private ComboBox<LANGUAGES> languagesComboBox;

    public SettingWindow(){
        settingsController = new SettingsController();
        setUp();
        isShown = false;
    }

    private void setUp() {
        setUpPane();
        setUpCombobox();
        setUpSettingStage();
    }

    public void showWindow(){
        if(!isShown){
            settingStage.show();
            isShown = true;
        } else {

        }
    }

    private void setUpPane(){
        settingPane = new Pane();
    }
    private void setUpSettingStage(){
        settingStage = new Stage();
        settingScene = new Scene(settingPane, 200, 200);
        settingStage.setTitle(LanguageController.getLanguageController().getMessage("Setting"));
        settingStage.setScene(settingScene);
    }

    private void setUpCombobox(){
        languagesComboBox = new ComboBox<LANGUAGES>();
        languagesComboBox.setItems(FXCollections.observableArrayList( LANGUAGES.values()));
        languagesComboBox.setOnAction(e -> settingsController.setLanguage(languagesComboBox.getValue(), this));
        settingPane.getChildren().add(languagesComboBox);
    }

    public void setTitle(String title){
        settingStage.setTitle(title);
    }

}
