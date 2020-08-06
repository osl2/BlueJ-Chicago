package osl2.view.ui.window;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import osl2.view.ui.FontSize;
import osl2.view.ui.mirror.IMirrorController;
import osl2.view.ui.mirror.MirrorController;

import java.awt.*;

/**
 * The head of a MovableWindow.
 */
public class MovableWindowHead extends HBox {

    private ActionButton minMaxButton;
    private ActionButton hideButton;
    private HBox buttons;
    private Pane spacer;
    private Label title;

    /**
     * Creates a new WindowHead
     * @param window The Window to which it belongs.
     * @param title The title of the head.
     */
    public MovableWindowHead(MovableWindow window, Label title) {
        setStyle();

        spacer = new Pane();
        spacer.setMinWidth(20);
        HBox.setHgrow(spacer, Priority.ALWAYS);

        buttons = new HBox();
        buttons.setSpacing(2);

        this. title = title;

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
    public void highlight(){
        this.getStyleClass().remove("movable-window-head");
        this.getStyleClass().add("movable-window-head-highlight");
    }

    /**
     * This method unhighlights the head.
     */
    public void unHighlight(){
        this.getStyleClass().remove("movable-window-head-highlight");
        this.getStyleClass().add("movable-window-head");

    }

    /**
     * This methods links the buttons for maximizing/minimizing and closing to the controller.
     * @param controller The controller to which the buttons will be linked.
     */
    public void linkBtnToController(IMirrorController controller) {
        minMaxButton = new ActionButton("...", () -> controller.minOrMaxMirror());
        hideButton = new ActionButton("X", () -> controller.hideMirror());
        buttons.getChildren().add(minMaxButton);
        buttons.getChildren().add(hideButton);
    }

    public void setTitle(String name){
        getChildren().removeAll(title, spacer, buttons);
        title.setText(name);
        getChildren().addAll(title, spacer, buttons);
    }

    /**
     * The Class for the buttons in a MovableWindowHead.
     */
    class ActionButton extends Button {

        /**
         * Creates a new ActionButton
         * @param text The text of the Button.
         * @param runnable The Runnable wich determines what the button does.
         */
        public ActionButton(String text, Runnable runnable) {
            this.setText(text);
            setOnMousePressed((event) -> runnable.run());
        }
    }

    public void setFontSize(FontSize newFontSize){
        removeFontSize();
        title.getStylesheets().add(newFontSize.getFileName());
        hideButton.getStylesheets().add(newFontSize.getFileName());
        minMaxButton.getStylesheets().add(newFontSize.getFileName());
    }

    private void removeFontSize(){
        for(FontSize fontSize: FontSize.values()) {
            title.getStylesheets().remove(fontSize.getFileName());
            hideButton.getStylesheets().remove(fontSize.getFileName());
            minMaxButton.getStylesheets().remove(fontSize.getFileName());
        }
    }
}
