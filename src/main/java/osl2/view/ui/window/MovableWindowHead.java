package osl2.view.ui.window;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;

public class MovableWindowHead extends HBox {


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
