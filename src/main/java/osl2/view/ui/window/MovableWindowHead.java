package osl2.view.ui.window;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import osl2.view.ui.mirror.IMirrorController;
import osl2.view.ui.mirror.MirrorController;

public class MovableWindowHead extends HBox {

    private IMirrorController mirrorController;

    public MovableWindowHead(MovableWindow window, Node title, IMirrorController controller) {
        mirrorController = controller;
        setStyle();

        Pane spacer = new Pane();
        spacer.setMinWidth(20);
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox buttons = new HBox();
        buttons.setSpacing(2);
        buttons.getChildren().add(new ActionButton("...", () -> mirrorController.minOrMaxMirror()));
        buttons.getChildren().add(new ActionButton("X", () -> mirrorController.hideMirror()));

        getChildren().addAll(title, spacer, buttons);
    }

    private void setStyle() {
        setPadding(new javafx.geometry.Insets(2, 2, 2, 2));
        setStyle("-fx-background-color: gray");
    }


    class ActionButton extends Button {

        public ActionButton(String text, Runnable runnable) {
            this.setText(text);
            this.setStyle("-fx-background-color: none;");
            setOnMousePressed((event) -> runnable.run());
        }
    }
}
