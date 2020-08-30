package osl2.messaging.datastructures;

import osl2.messaging.error_handling.UserError;

/**
 * The interface for the communication between datastructures.
 */
public interface DatastructureCommunication {

    /**
     * Handles error of the datastructure.
     *
     * @param userError
     *         The error which should be handled.
     */
    void handleError(UserError userError);

    /**
     * Sets the Name of the datastructure.
     *
     * @param name
     *         The name of the datastructure.
     */
    void setName(String name);
}
