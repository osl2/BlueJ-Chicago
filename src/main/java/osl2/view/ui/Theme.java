package osl2.view.ui;

/**
 * The themes which can be used in the application.
 */
public enum Theme {
    DARK("Stylesheets/theme_bright.css"),
    BRIGHT("Stylesheets/theme_bright.css");

    private final String fileName;

    Theme(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }
}
