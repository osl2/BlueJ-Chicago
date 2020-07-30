package osl2.evanston.view.ui.window;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MovableWindowBody extends VBox {

    private final MovableWindowHead head;
    private final Node contents;
    private boolean contentsShown = false;


    public void showContents() {
        if (!contentsShown) {
            getChildren().add(contents);
            contentsShown = true;
            head.setMinWidth(-1);   // Undo "snapping" avoidance
        }
    }

    public void hideContents() {
        if (contentsShown) {
            getChildren().remove(1);
            contentsShown = false;
            head.setMinWidth(contents.getBoundsInParent().getWidth());  // Avoid ugly "snapping" of the layout
        }
    }

    public void toggle() {
        if (contentsShown) {
            hideContents();
        } else {
            showContents();
        }
    }

    private void setStyle() {
        setStyle("-fx-border-color: gray;");
    }

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
}