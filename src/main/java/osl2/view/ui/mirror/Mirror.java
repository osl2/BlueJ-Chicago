package osl2.view.ui.mirror;

import javafx.scene.Node;
import javafx.scene.control.Label;
import osl2.view.ui.window.MovableWindow;

/**
 * This is the Mirror Class, which is a MovableWindow.
 */
public class Mirror extends MovableWindow {

  /**
   * Creates a new Mirror.
   *
   * @param title
   *         The title of the mirror.
   * @param contents
   *         The contents of the mirror.
   * @param controller
   *         The controller of the mirror.
   */
  public Mirror(String title, Node contents, IMirrorController controller) {
    super(new Label(title), contents, controller);
  }

}
