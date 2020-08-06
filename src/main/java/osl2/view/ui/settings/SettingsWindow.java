package osl2.view.ui.settings;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import osl2.view.ui.FontSize;
import osl2.view.ui.localisation.LANGUAGES;
import osl2.view.ui.localisation.LanguageController;

public class SettingsWindow {
    private final SettingsController settingsController;
    private final LanguageController languageController;
    private Stage settingStage;
    private boolean isShown;
    private VBox vBox;
    private ComboBox<LANGUAGES> languagesComboBox;

    public SettingsWindow(SettingsController settingsController) {
        this.settingsController = settingsController;
        this.languageController = LanguageController.getLanguageController();
        setUp();
        isShown = false;
    }

    private void setUp() {
        setUpPane();
        setUpCombobox();
        setUpFontSizeSelection();
        setUpSettingStage();
    }

    public void showWindow() {
        if (!isShown) {
            settingStage.show();
            isShown = true;
        }
    }

    private void setUpPane() {
        vBox = new VBox();
        vBox.setSpacing(10);
    }

    private void setUpSettingStage() {
        settingStage = new Stage();
        Scene settingScene = new Scene(vBox, 400, 200);
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
        vBox.getChildren().add(languagesComboBox);
    }

    private void setUpFontSizeSelection() {
        addFontSizeLabel();
        addFontSizeBtns();
    }

    private void addFontSizeLabel() {
        Label setFontLabel = new Label(languageController.getMessage("FontSetting"));
        vBox.getChildren().add(setFontLabel);
    }

    private void addFontSizeBtns() {
        final ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton fontSmall = new RadioButton(languageController.getMessage("FontSettingSmall"));
        fontSmall.setToggleGroup(toggleGroup);
        fontSmall.setUserData(FontSize.SMALL);

        RadioButton fontMedium = new RadioButton(languageController.getMessage("FontSettingMedium"));
        fontMedium.setToggleGroup(toggleGroup);
        fontMedium.setUserData(FontSize.MEDIUM);
        fontMedium.setSelected(true);

        RadioButton fontLarge = new RadioButton(languageController.getMessage("FontSettingLarge"));
        fontLarge.setToggleGroup(toggleGroup);
        fontLarge.setUserData(FontSize.LARGE);

        toggleGroup.selectedToggleProperty().addListener(e -> settingsController.setFontSize((FontSize) toggleGroup.getSelectedToggle().getUserData()));

        HBox radioBtns = new HBox();
        radioBtns.setPadding(new Insets(10));
        radioBtns.setSpacing(10);
        radioBtns.getChildren().addAll(fontSmall, fontMedium, fontLarge);

        vBox.getChildren().add(radioBtns);
    }

    public void setTitle(String title) {
        settingStage.setTitle(title);
    }

}
