package osl2.evanston.view.ui.window;

import javafx.animation.FillTransition;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class MovableWindowHead extends HBox {


    class ActionButton extends Button {

        public ActionButton(String text, Runnable runnable) {
            this.setText(text);
            this.setStyle("-fx-background-color: none;");
            setOnMousePressed((event) -> runnable.run());
        }
    }


    private void setStyle() {
        setPadding(new javafx.geometry.Insets(2, 2, 2, 2));
        setStyle("-fx-background-color: gray");
    }


    public MovableWindowHead(MovableWindow window, Node title) {
        setStyle();

        Pane spacer = new Pane();
        spacer.setMinWidth(20);
        HBox.setHgrow(spacer, Priority.ALWAYS);

        HBox buttons = new HBox();
        buttons.setSpacing(2);
        buttons.getChildren().add(new ActionButton("...", () -> window.toggle()));
        buttons.getChildren().add(new ActionButton("X", () -> window.disappear()));

        getChildren().addAll(title, spacer, buttons);
    }
}
