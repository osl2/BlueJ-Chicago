package osl2.view.ui.localisation;

/**
 * All the languages which are supported.
 */
public enum Languages {
    ENGLISH_US("en", "US"),
    GERMAN("de", "DE");

    private final String language;
    private final String country;

    /**
     * Creates a new language.
     *
     * @param language
     *         The language string.
     * @param country
     *         The country string.
     */
    Languages(String language, String country) {
        this.language = language;
        this.country = country;
    }

    /**
     * Returns the language.
     *
     * @return The language.
     */
    public String getLanguage() {
        return this.language;
    }

    /**
     * Returns the country.
     *
     * @return The country.
     */
    public String getCountry() {
        return this.country;
    }
}
