package osl2.messaging.error_handling;

/**
 * The Interface for a UserError.
 */
public interface UserError {
    /**
     * Returns the name of the error.
     *
     * @return The name of the error.
     */
    String getErrorName();

    /**
     * Returns the warning message of the error.
     *
     * @return The warning message.
     */
    String getErrorContent();
}
