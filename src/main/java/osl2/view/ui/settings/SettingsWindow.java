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
import javafx.stage.Modality;
import javafx.stage.Stage;
import osl2.view.ui.FontSize;
import osl2.view.ui.localisation.LANGUAGES;
import osl2.view.ui.localisation.LanguageController;

/**
 * The class for the SettingsWindow.
 */
public class SettingsWindow {
    private final SettingsController settingsController;
    private final LanguageController languageController;
    private Stage settingStage;
    private boolean isShown;
    private VBox vBox;
    private ComboBox<LANGUAGES> languagesComboBox;
    private final Stage owner;

    /**
     * Creates a new Setting Window.
     * @param settingsController The Controller for this window.
     * @param owner The Mainwindow to which this window is the settings window.
     */
    public SettingsWindow(SettingsController settingsController, Stage owner) {
        this.settingsController = settingsController;
        this.languageController = LanguageController.getLanguageController();
        this.owner = owner;
        setUp();
        isShown = false;
    }

    /**
     * Sets up the Settingswindow.
     */
    private void setUp() {
        setUpPane();
        setUpCombobox();
        setUpFontSizeSelection();
        setUpSettingStage();
    }

    /**
     * Shows the window if hidden.
     */
    public void showWindow() {
        if (!isShown) {
            settingStage.show();
            isShown = true;
        }
    }

    /**
     * Sets up the Pane inside the window.
     */
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
        settingStage.setOnHiding(e -> isShown = false);
        settingStage.initOwner(owner);
        settingStage.initModality(Modality.APPLICATION_MODAL);
    }

    /**
     * Hides the Settingswindow.
     */
    private void hideWindow() {
        this.settingStage.hide();
        this.isShown = false;
    }

    /**
     * Sets up the combobox for the languages.
     */
    private void setUpCombobox() {
        languagesComboBox = new ComboBox<LANGUAGES>();
        languagesComboBox.setItems(FXCollections.observableArrayList(LANGUAGES.values()));
        languagesComboBox.setOnAction(e -> settingsController.setLanguage(languagesComboBox.getValue(), this));
        languagesComboBox.getSelectionModel().select(LanguageController.getLanguageController().getLanguage());
        vBox.getChildren().add(languagesComboBox);
    }

    /**
     * Sets up the Font size selection.
     */
    private void setUpFontSizeSelection() {
        addFontSizeLabel();
        addFontSizeBtns();
    }

    /**
     * Adds the Label for al the Fontsizes.
     */
    private void addFontSizeLabel() {
        Label setFontLabel = new Label(languageController.getMessage("FontSetting"));
        vBox.getChildren().add(setFontLabel);
    }

    /**
     * Adds the buttons for chaning the font size.
     */
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

    /**
     * Sets the title of the Settingspane.
     * @param title The new title.
     */
    public void setTitle(String title) {
        settingStage.setTitle(title);
    }

}
