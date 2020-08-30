package osl2.view.ui;

/**
 * Manages font sizes.
 */
public enum FontSize {
    SMALL("Stylesheets/fontSize_small.css"),
    MEDIUM("Stylesheets/fontSize_medium.css"),
    LARGE("Stylesheets/fontSize_large.css");

    private final String fileName;

    FontSize(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }
}
