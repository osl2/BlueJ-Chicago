package osl2.view.ui.window;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import osl2.view.ui.mirror.IMirrorController;

/**
 * The head of a MovableWindow.
 */
public class MovableWindowHead extends HBox {
    private static final String MOVABLE_WINDOW_HEAD = "movable-window-head";
    private final HBox buttons;
    private final Pane spacer;
    private ActionButton minMaxButton;
    private ActionButton hideButton;
    private Node title;
    private boolean isMax;
    private Button resizeButton;
    private double mouseDragStartY;
    private double mouseDragStartX;

    /**
     * Creates a new WindowHead.
     *
     * @param title
     *         The title of the head.
     */
    public MovableWindowHead(Node title) {
        setStyle();

        spacer = new Pane();
        spacer.setMinWidth(20);
        HBox.setHgrow(spacer, Priority.ALWAYS);

        buttons = new HBox();
        buttons.setSpacing(2);

        this.title = title;
        this.title.getStyleClass().add("movable-window-head-title");

        getChildren().addAll(this.title, spacer, buttons);
    }

    /**
     * This method sets the style of the head.
     */
    private void setStyle() {
        this.getStyleClass().add("movable-window");
        this.getStyleClass().add(MOVABLE_WINDOW_HEAD);
    }

    /**
     * This method highlights the head.
     */
    public void highlight() {
        this.getStyleClass().remove(MOVABLE_WINDOW_HEAD);
        this.getStyleClass().add("movable-window-head-highlight");
    }

    /**
     * This method unhighlights the head.
     */
    public void unHighlight() {
        this.getStyleClass().remove("movable-window-head-highlight");
        this.getStyleClass().add(MOVABLE_WINDOW_HEAD);
    }

    /**
     * This methods links the buttons for maximizing/minimizing and closing to the controller.
     *
     * @param controller
     *         The controller to which the buttons will be linked.
     */
    public void linkBtnToController(IMirrorController controller) {
        hideButton = new ActionButton("X", controller::hideMirror);
        minMaxButton = new ActionButton("^", controller::minOrMaxMirror);
        setUpResizeBtn();
        resizeButton.setOnMousePressed(mouseEvent -> {
            mouseDragStartY = mouseEvent.getY();
            mouseDragStartX = mouseEvent.getX();
        });
        resizeButton.setOnMouseDragged(mouseEvent -> {
            double x = mouseEvent.getX() - mouseDragStartX;
            controller.resizeMirrorX(x);

            double y = (mouseDragStartY - mouseEvent.getY()) * -1;
            controller.resizeMirrorY(y);
            mouseDragStartY = mouseEvent.getY();
        });
        buttons.getChildren().add(resizeButton);
        buttons.getChildren().add(minMaxButton);
        buttons.getChildren().add(hideButton);
    }

    private void setUpResizeBtn() {
        resizeButton = new Button();

        ImageView resizeIcon = new ImageView("images/resize.png");
        resizeIcon.setFitHeight(15);
        resizeIcon.setFitWidth(15);
        resizeButton.setGraphic(resizeIcon);

        resizeButton.getStyleClass().add("movable-window-head-resize");
    }

    /**
     * Changes the minMaxButtons appearance.
     */
    public void changeMinMaxButton() {
        if (isMax) {
            minMaxButton.setText("^");
            isMax = false;
        } else {
            minMaxButton.setText("v");
            isMax = true;
        }
    }

    /**
     * Sets the title of the head.
     *
     * @param name
     *         THe title.
     */
    public void setTitle(String name) {
        getChildren().removeAll(title, spacer, buttons);
        this.title = new Label(name);
        this.title.getStyleClass().add("movable-window-head-title");
        getChildren().addAll(title, spacer, buttons);
    }

    /**
     * Gets the min width of the head with which it is displayed correctly.
     *
     * @return the min width
     */
    public double getHeadMinWidth() {
        return this.getWidth() - spacer.getWidth();
    }

    /**
     * Returns the ResizeButton. For testing.
     *
     * @return The ResizeButton.
     */
    public Button getResizeButton() {
        return this.resizeButton;
    }

    /**
     * Returns the HideButton. For testin.
     *
     * @return The HideButton.
     */
    public Button getHideButton() {
        return this.hideButton;
    }

    /**
     * Returns the MinMaxButton. For testing.
     *
     * @return The MinMaxButton.
     */
    public Button getMinMaxButton() {
        return this.minMaxButton;
    }

    /**
     * Returns the HBox for the Buttons. For Testing.
     *
     * @return The HBox for the Buttons.
     */
    public HBox getButtons() {
        return this.buttons;
    }

    /**
     * The Class for the buttons in a MovableWindowHead.
     */
    static class ActionButton extends Button {

        /**
         * Creates a new ActionButton.
         *
         * @param text
         *         The text of the Button.
         * @param runnable
         *         The Runnable wich determines what the button does.
         */
        public ActionButton(String text, Runnable runnable) {
            this.setText(text);
            setOnMousePressed(event -> runnable.run());
            this.getStyleClass().add("movable-window-head-button");
        }
    }
}
