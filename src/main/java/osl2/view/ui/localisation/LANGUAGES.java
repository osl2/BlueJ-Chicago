package osl2.view.ui.localisation;

/**
 * All the languages which are supported.
 */
public enum LANGUAGES {
    ENGLISH_US("en", "US"),
    GERMAN("de", "DE");

    private String language;
    private String country;

    /**
     * Creates a new language.
     * @param language The language string.
     * @param country The country string.
     */
    LANGUAGES(String language, String country) {
        this.language = language;
        this.country = country;
    }

    /**
     * Returns the language.
     * @return The language.
     */
    public String getLanguage(){
        return this.language;
    }

    /**
     * Returns the country.
     * @return The country.
     */
    public String getCountry(){
        return this.country;
    }
}
