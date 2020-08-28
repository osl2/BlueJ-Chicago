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

    private final HBox buttons;
    private final Pane spacer;
    private ActionButton minMaxButton;
    private ActionButton hideButton;
    private Node title;
    private boolean isMin;
    private Button resizeButton;
    private double mouseDragStartY;
    private double mouseDragStartX;

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
        this.title.getStyleClass().add("movable-window-head-title");

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
    public void changeMinMaxButton(){
        if(isMin){
            minMaxButton.setText("^");
            isMin = false;
        } else {
            minMaxButton.setText("v");
            isMin = true;
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
     * Gets the min width of the head with which it is displayed correctly.
     *
     * @return the min width
     */
    public double getHeadMinWidth() {
        return this.getWidth() - spacer.getWidth();
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

    public Button getResizeButton(){return this.resizeButton;}
    public Button getHideButton(){return this.hideButton;}
    public Button getMinMaxButton(){return this.minMaxButton;}
    public HBox getButtons(){return this.buttons;}
    public boolean isMin(){return this.isMin;}
}
