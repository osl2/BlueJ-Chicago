package osl2.messaging.datastructures;

import osl2.messaging.errorHandling.UserError;

/**
 * The interface for the communication between datastructures.
 */
public interface DatastructureCommunication {

  /**
   * Handles error of the datastructure.
   *
   * @param userError
   *         The error which should be handeled.
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
