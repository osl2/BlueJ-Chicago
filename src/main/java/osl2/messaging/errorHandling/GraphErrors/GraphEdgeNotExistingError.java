package osl2.messaging.errorHandling.GraphErrors;

import osl2.messaging.errorHandling.UserError;
import osl2.view.ui.localisation.LanguageController;

/**
 * The class for when a edge in a graph doesn't exist.
 *
 * @param <T>
 *         The datatype of the edge.
 */
public class GraphEdgeNotExistingError<T> implements UserError {

  private final String name = "GraphEdgeNotExisting";
  private final T start;
  private final T end;
  private final LanguageController languageController;

  /**
   * Creates a new GraphEdgeNotExistingError.
   *
   * @param start
   *         The startnode for the edge.
   * @param end
   *         The endnode for the edge.
   */
  public GraphEdgeNotExistingError(T start, T end) {
    this.languageController = LanguageController.getLanguageController();
    this.start = start;
    this.end = end;
  }

  @Override
  public String getErrorName() {
    return this.name;
  }

  @Override
  public String getErrorContent() {
    return languageController.getMessage(this.name + "Node")
            + start.toString() + "-" + end.toString() +
            "\n" + languageController.getMessage(this.name + "Get");
  }
}
