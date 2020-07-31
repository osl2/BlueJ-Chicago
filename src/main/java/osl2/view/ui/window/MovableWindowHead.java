package osl2.view.ui.window;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import osl2.view.ui.mirror.IMirrorController;
import osl2.view.ui.mirror.MirrorController;

public class MovableWindowHead extends HBox {

    private ActionButton minMaxButton;
    private ActionButton hideButton;
    private HBox buttons;
    private Pane spacer;

    public MovableWindowHead(MovableWindow window, Node title) {
        setStyle();

        spacer = new Pane();
        spacer.setMinWidth(20);
        HBox.setHgrow(spacer, Priority.ALWAYS);

        buttons = new HBox();
        buttons.setSpacing(2);

        getChildren().addAll(title, spacer, buttons);
    }

    private void setStyle() {
        setPadding(new javafx.geometry.Insets(2, 2, 2, 2));
        setStyle("-fx-background-color: gray");
    }

    public void linkBtnToController(IMirrorController controller){
        minMaxButton = new ActionButton("...", () -> controller.minOrMaxMirror());
        hideButton = new ActionButton("X", () -> controller.hideMirror());
        buttons.getChildren().add(minMaxButton);
        buttons.getChildren().add(hideButton);
    }

    class ActionButton extends Button {

        public ActionButton(String text, Runnable runnable) {
            this.setText(text);
            this.setStyle("-fx-background-color: none;");
            setOnMousePressed((event) -> runnable.run());
        }
    }
}
