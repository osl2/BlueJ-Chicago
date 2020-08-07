package osl2.view.ui.window;

import javafx.scene.Node;
import javafx.scene.layout.VBox;

/**
 * This class is the body of a MovableWindow where the content of it will be shown.
 */
public class MovableWindowBody extends VBox {
    private final MovableWindowHead head;
    private final Node contents;
    private boolean contentsShown = false;

    /**
     * Creates a new body.
     *
     * @param window   Window to which it belongs.
     * @param title    The title of the head.
     * @param contents The contents of its body.
     */
    public MovableWindowBody(MovableWindow window, Node title, Node contents) {
        this.head = new MovableWindowHead(window, title);
        /*ScrollPane scroll = new ScrollPane(contents);
        scroll.setOnMouseEntered((event) -> {
            scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        });
        scroll.setOnMouseExited((event) -> {
            scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        });*/
        this.contents = contents;
        setStyle();
        getChildren().add(this.head);
        showContents();
    }

    /**
     * Returns the head to this body.
     *
     * @return The head.
     */
    public MovableWindowHead getHead() {
        return this.head;
    }

    /**
     * Shows the content of the body.
     */
    public void showContents() {
        if (!contentsShown) {
            getChildren().add(contents);
            contentsShown = true;
            head.setMinWidth(-1);   // Undo "snapping" avoidance
        }
    }

    /**
     * Hides the content of the body.
     */
    public void hideContents() {
        if (contentsShown) {
            getChildren().remove(1);
            contentsShown = false;
            head.setMinWidth(contents.getBoundsInParent().getWidth());  // Avoid ugly "snapping" of the layout
        }
    }

    /**
     * Toggles the window, which means hiding the contents if they are shown.
     * And else showing the contents.
     */
    public void toggle() {
        if (contentsShown) {
            hideContents();
        } else {
            showContents();
        }
    }

    /**
     * Sets the style of the window.
     */
    private void setStyle() {
        this.getStyleClass().add("movable-window");
        this.getStyleClass().add("movable-window-body");
    }
}
