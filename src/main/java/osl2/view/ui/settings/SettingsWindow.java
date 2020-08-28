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
import osl2.view.ui.Theme;
import osl2.view.ui.localisation.LANGUAGES;
import osl2.view.ui.localisation.LanguageController;

/**
 * The class for the SettingsWindow.
 */
public class SettingsWindow {
    private final SettingsController settingsController;
    private final LanguageController languageController;
    private final Stage owner;
    private Stage settingStage;
    private boolean isShown;
    private VBox vBox;
    private ComboBox<LANGUAGES> languagesComboBox;
    private Scene settingScene;
    private Label setFontLabel;
    private RadioButton fontSmall;
    private RadioButton fontMedium;
    private RadioButton fontLarge;
    private Label setThemeLabel;
    private RadioButton themeBright;
    private RadioButton themeDark;
    private RadioButton themeColorBlind;

    /**
     * Creates a new Setting Window.
     *
     * @param settingsController
     *         The Controller for this window.
     * @param owner
     *         The Mainwindow to which this window is the settings window.
     */
    public SettingsWindow(SettingsController settingsController, Stage owner) {
        this.settingsController = settingsController;
        this.languageController = LanguageController.getLanguageController();
        this.owner = owner;
        setUp();
        isShown = false;
        setFontSize(FontSize.MEDIUM);
        setTheme(Theme.DARK);
    }

    /**
     * Sets up the Settingswindow.
     */
    private void setUp() {
        setUpPane();
        setUpCombobox();
        setUpFontSizeSelection();
        setUpThemeSelection();
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
        vBox.getStyleClass().add("settings-background");
    }


    private void setUpSettingStage() {
        settingStage = new Stage();
        settingScene = new Scene(vBox, 400, 200);
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
        languagesComboBox.getStyleClass().add("language-selection-box");
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
        setFontLabel = new Label(languageController.getMessage("FontSetting"));
        setFontLabel.getStyleClass().add("white-text");
        vBox.getChildren().add(setFontLabel);
    }

    /**
     * Adds the buttons for chaning the font size.
     */
    private void addFontSizeBtns() {
        final ToggleGroup toggleGroup = new ToggleGroup();

        fontSmall = new RadioButton(languageController.getMessage("FontSettingSmall"));
        fontSmall.setToggleGroup(toggleGroup);
        fontSmall.setUserData(FontSize.SMALL);
        fontSmall.getStyleClass().add("white-text");

        fontMedium = new RadioButton(languageController.getMessage("FontSettingMedium"));
        fontMedium.setToggleGroup(toggleGroup);
        fontMedium.setUserData(FontSize.MEDIUM);
        fontMedium.setSelected(true);
        fontMedium.getStyleClass().add("white-text");

        fontLarge = new RadioButton(languageController.getMessage("FontSettingLarge"));
        fontLarge.setToggleGroup(toggleGroup);
        fontLarge.setUserData(FontSize.LARGE);
        fontLarge.getStyleClass().add("white-text");

        toggleGroup.selectedToggleProperty().addListener(e -> settingsController.setFontSize((FontSize) toggleGroup.getSelectedToggle().getUserData()));

        HBox radioBtns = new HBox();
        radioBtns.setPadding(new Insets(10));
        radioBtns.setSpacing(10);
        radioBtns.getChildren().addAll(fontSmall, fontMedium, fontLarge);

        vBox.getChildren().add(radioBtns);
    }

    /**
     * Sets up the theme selection.
     */
    private void setUpThemeSelection() {
        addThemeLabel();
        addThemeBtns();
    }

    /**
     * Adds the label for theme selection.
     */
    private void addThemeLabel() {
        setThemeLabel = new Label(languageController.getMessage("ThemeSetting"));
        setThemeLabel.getStyleClass().add("white-text");
        vBox.getChildren().add(setThemeLabel);
    }

    /**
     * Adds the buttons for chaning the theme.
     */
    private void addThemeBtns() {
        final ToggleGroup toggleGroup = new ToggleGroup();

        themeBright = new RadioButton(languageController.getMessage("ThemeSettingBright"));
        themeBright.setToggleGroup(toggleGroup);
        themeBright.setUserData(Theme.BRIGHT);
        themeBright.getStyleClass().add("white-text");

        themeDark = new RadioButton(languageController.getMessage("ThemeSettingDark"));
        themeDark.setToggleGroup(toggleGroup);
        themeDark.setUserData(Theme.DARK);
        themeDark.setSelected(true);
        themeDark.getStyleClass().add("white-text");

        themeColorBlind = new RadioButton(languageController.getMessage("ThemeSettingColorBlindness"));
        themeColorBlind.setToggleGroup(toggleGroup);
        themeColorBlind.setUserData(Theme.COLOR_BLINDNESS);
        themeColorBlind.getStyleClass().add("white-text");

        toggleGroup.selectedToggleProperty().addListener(e -> settingsController.setTheme((Theme) toggleGroup.getSelectedToggle().getUserData()));

        HBox radioBtns = new HBox();
        radioBtns.setPadding(new Insets(10));
        radioBtns.setSpacing(10);
        radioBtns.getChildren().addAll(themeBright, themeDark, themeColorBlind);

        vBox.getChildren().add(radioBtns);
    }

    /**
     * Sets the title of the Settingspane.
     *
     * @param title
     *         The new title.
     */
    private void setTitle(String title) {
        settingStage.setTitle(title);
    }

    /**
     * Sets the font size used in this window.
     *
     * @param newFontSize
     *         - the new {@link FontSize} to be used
     */
    public void setFontSize(FontSize newFontSize) {
        removeAllFontSizes();
        this.settingScene.getStylesheets().add(newFontSize.getFileName());
    }

    /**
     * Removes all the font sizes from the SettingsWindow.
     */
    private void removeAllFontSizes() {
        for (FontSize fontSize : FontSize.values()) {
            this.settingScene.getStylesheets().remove(fontSize.getFileName());
        }
    }

    /**
     * Sets the theme used in the window.
     *
     * @param newTheme
     *         - the new {@link Theme} to be used
     */
    public void setTheme(Theme newTheme) {
        removeAllThemes();
        this.settingScene.getStylesheets().add(newTheme.getFileName());

    }

    /**
     * Removes all themes from the SettingsWindow.
     */
    private void removeAllThemes() {
        for (Theme theme : Theme.values()) {
            this.settingScene.getStylesheets().remove(theme.getFileName());
        }
    }

    /**
     * Sets the new language in the SettingsWindow.
     */
    public void setWithNewLanguage() {
        setTitle(LanguageController.getLanguageController().getMessage("SettingsWindowTitle"));
        setFontSizeLanguage();
        setThemeLanguage();
    }

    /**
     * Sets the language for the font size region.
     */
    private void setFontSizeLanguage() {
        setFontLabel.setText(LanguageController.getLanguageController().getMessage("FontSetting"));
        fontSmall.setText(LanguageController.getLanguageController().getMessage("FontSettingSmall"));
        fontMedium.setText(LanguageController.getLanguageController().getMessage("FontSettingMedium"));
        fontLarge.setText(LanguageController.getLanguageController().getMessage("FontSettingLarge"));
    }

    /**
     * Sets the language for the theme region.
     */
    private void setThemeLanguage() {
        setThemeLabel.setText(LanguageController.getLanguageController().getMessage("ThemeSetting"));
        themeBright.setText(LanguageController.getLanguageController().getMessage("ThemeSettingBright"));
        themeDark.setText(LanguageController.getLanguageController().getMessage("ThemeSettingDark"));
        themeColorBlind.setText(LanguageController.getLanguageController().getMessage("ThemeSettingColorBlindness"));
    }
}
