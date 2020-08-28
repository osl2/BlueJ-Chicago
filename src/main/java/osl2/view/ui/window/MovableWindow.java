package osl2.view.ui.window;

import javafx.scene.Node;
import osl2.view.ui.draggable.Draggable;
import osl2.view.ui.mirror.IMirrorController;

/**
 * The MovableWindow class is window with two parts, which extends a draggable, so that its movable in the mainspace.
 */
public class MovableWindow extends Draggable {
    private final MovableWindowBody body;
    private final MovableWindowHead head;
    private final double MIN_BODY_HEIGHT = 50;
    private final double HEAD_MIN_WIDTH_OFFSET = 20;
    private boolean isHighlighted;

    public MovableWindow(Node title, Node contents, IMirrorController controller) {
        body = new MovableWindowBody(this, title, contents);
        head = body.getHead();
        head.linkBtnToController(controller);
        getChildren().add(body);
        setBehaviourHighlight();
        isHighlighted = false;
    }

    /**
     * This method toggles the highlighting of the window.
     */
    public void toggleHighlight() {
        if (isHighlighted) {
            unHighlight();
        } else {
            highlight();
        }
    }

    /**
     * This method highlights the window.
     */
    public void highlight() {
        this.head.highlight();
        this.isHighlighted = true;
        this.raise();
    }

    /**
     * This method unhighlights the window.
     */
    private void unHighlight() {
        this.head.unHighlight();
        this.isHighlighted = false;
    }

    /**
     * This method shows the contents of the body of the window.
     */
    public void showContents() {
        body.showContents();
    }

    /**
     * This method hides the contents of the body of the window.
     */
    public void hideContents() {
        body.hideContents();
    }

    /**
     * This method toggles the body of the window..
     */
    public void toggle() {
        body.toggle();
    }

    public void changeHeadName(String name) {
        this.head.setTitle(name);
    }

    /**
     * This method sets the behaviour, so when its highlighted and clicked, it will be unhighlighted.
     */
    private void setBehaviourHighlight() {
        setOnMouseClicked((event) -> {
            if (isHighlighted) {
                this.unHighlight();
            }
        });
    }

    /**
     * Changes the minMaxButtons appearance in the head.
     */
    public void changeMinMaxButton() {
        this.head.changeMinMaxButton();
    }

    /**
     * Gets the width of the mirror.
     *
     * @return the width of the mirror
     */
    public double getWidth() {
        return this.body.getBodyWidth();
    }

    /**
     * Sets the width of the mirror.
     *
     * @param width
     *         - the new width
     */
    public void setWidth(double width) {
        if (width > head.getHeadMinWidth() + HEAD_MIN_WIDTH_OFFSET) {
            this.body.setBodyWidth(width);
        }
    }

    /**
     * Gets the height of the body.
     *
     * @return the height of the body.
     */
    public double getBodyHeight() {
        return this.body.getBodyHeight();
    }

    /**
     * Sets the height of the body.
     *
     * @param height
     *         - the new height
     */
    public void setBodyHeight(double height) {
        if (height < MIN_BODY_HEIGHT) {
            return;
        }
        this.body.setBodyHeight(height);
    }
}
