package osl2.messaging.errorHandling.TreeErrors;

import osl2.messaging.errorHandling.UserError;
import osl2.view.ui.localisation.LanguageController;

public class TreeNoChildError<T> implements UserError {
  private final String name = "TreeNoChild";
  private final LanguageController languageController;
  private final T parent;

  /**
   * Creates a new TreeNoChildError.
   *
   * @param parent
   *         The parent without childs.
   */
  public TreeNoChildError(T parent) {
    this.languageController = LanguageController.getLanguageController();
    this.parent = parent;
  }

  @Override
  public String getErrorName() {
    return this.name;
  }

  @Override
  public String getErrorContent() {
    return languageController.getMessage(this.name + "Parent") + parent.toString() + "\n"
            + languageController.getMessage(this.name + "NoChild");
  }
}
