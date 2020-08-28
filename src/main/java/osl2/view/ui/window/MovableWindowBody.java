package osl2.view.ui.window;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

/**
 * This class is the body of a MovableWindow where the content of it will be shown.
 */
public class MovableWindowBody extends VBox {
    private final MovableWindowHead head;
    private final ScrollPane scroll;
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
        this.scroll = new ScrollPane(contents);
        setUpScrollPane(contents);

        setStyle();
        getChildren().add(this.head);
        showContents();
    }

    private void setUpScrollPane(Node contents) {
        scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scroll.setOnMouseEntered((event) -> {
            scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
            scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        });
        scroll.setOnMouseExited((event) -> {
            scroll.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
            scroll.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        });

        scroll.setContent(contents);
        scroll.pannableProperty().set(true);
        scroll.setMaxWidth(400);
        scroll.setMaxHeight(400);
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
            getChildren().add(scroll);
            contentsShown = true;
            head.setMinWidth(-1);   // Undo "snapping" avoidance
        }
    }

    /**
     * Hides the content of the body.
     */
    public void hideContents() {
        if (contentsShown) {
            getChildren().remove(scroll);
            contentsShown = false;
            head.setMinWidth(scroll.getWidth());
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

    /**
     * Gets the width of the body.
     *
     * @return the width of the body
     */
    public double getBodyWidth() {
        return this.scroll.getWidth();
    }

    /**
     * Sets the width of the body.
     *
     * @param width - the new width
     */
    public void setBodyWidth(double width) {
        this.scroll.setMinWidth(width);
        this.scroll.setMaxWidth(width);
    }

    /**
     * Gets the height of the body.
     *
     * @return the height of the body
     */
    public double getBodyHeight() {
        return this.scroll.getHeight();
    }

    /**
     * Sets the height of the body.
     *
     * @param height - the new height
     */
    public void setBodyHeight(double height) {
        this.scroll.setMinHeight(height);
        this.scroll.setMaxHeight(height);
    }

    public boolean getContentsShown(){
        return this.contentsShown;
    }
}
