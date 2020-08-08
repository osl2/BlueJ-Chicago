package osl2.view.ui.window;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import osl2.view.ui.mirror.IMirrorController;

/**
 * The head of a MovableWindow.
 */
public class MovableWindowHead extends HBox {

    private ActionButton minMaxButton;
    private ActionButton hideButton;
    private final HBox buttons;
    private final Pane spacer;
    private Node title;
    private boolean isMax;

    /**
     * Creates a new WindowHead
     *
     * @param window The Window to which it belongs.
     * @param title  The title of the head.
     */
    public MovableWindowHead(MovableWindow window, Node title) {
        setStyle();

        spacer = new Pane();
        spacer.setMinWidth(20);
        HBox.setHgrow(spacer, Priority.ALWAYS);

        buttons = new HBox();
        buttons.setSpacing(2);

        this.title = title;

        getChildren().addAll(this.title, spacer, buttons);
    }

    /**
     * This method sets the style of the head.
     */
    private void setStyle() {
        this.getStyleClass().add("movable-window");
        this.getStyleClass().add("movable-window-head");
    }

    /**
     * This method highlights the head.
     */
    public void highlight() {
        this.getStyleClass().remove("movable-window-head");
        this.getStyleClass().add("movable-window-head-highlight");
    }

    /**
     * This method unhighlights the head.
     */
    public void unHighlight() {
        this.getStyleClass().remove("movable-window-head-highlight");
        this.getStyleClass().add("movable-window-head");
    }

    /**
     * This methods links the buttons for maximizing/minimizing and closing to the controller.
     *
     * @param controller The controller to which the buttons will be linked.
     */
    public void linkBtnToController(IMirrorController controller) {
        hideButton = new ActionButton("X", () -> controller.hideMirror());
        minMaxButton = new ActionButton("^", () -> controller.minOrMaxMirror());
        buttons.getChildren().add(minMaxButton);
        buttons.getChildren().add(hideButton);
    }

    /**
     * Changes the minMaxButtons appearance.
     */
    public void changeMinMaxButton(){
        if(isMax){
            minMaxButton.setText("^");
            isMax = false;
        } else {
            minMaxButton.setText("v");
            isMax = true;
        }
    }

    /**
     * Sets the title of the head.
     * @param name THe title.
     */
    public void setTitle(String name) {
        getChildren().removeAll(title, spacer, buttons);
        this.title = new Label(name);
        this.title.getStyleClass().add("movable-window-head-title");
        getChildren().addAll(title, spacer, buttons);
    }

    /**
     * The Class for the buttons in a MovableWindowHead.
     */
    class ActionButton extends Button {

        /**
         * Creates a new ActionButton
         *
         * @param text     The text of the Button.
         * @param runnable The Runnable wich determines what the button does.
         */
        public ActionButton(String text, Runnable runnable) {
            this.setText(text);
            setOnMousePressed((event) -> runnable.run());
            this.getStyleClass().add("movable-window-head-button");
        }
    }
}
