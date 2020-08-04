package osl2.view.ui.window;

import javafx.scene.Node;
import osl2.view.ui.draggable.Draggable;
import osl2.view.ui.draggable.Floormat;
import osl2.view.ui.mirror.IMirrorController;

/**
 * The MovableWindow class is window with two parts, which extends a draggable, so that its movable in the mainspace.
 */
public class MovableWindow extends Draggable {
    private final MovableWindowBody body;
    private boolean isHighlight;

    public MovableWindow(Floormat floormat, Node title, Node contents, IMirrorController controller) {
        super(floormat);
        body = new MovableWindowBody(this, title, contents);
        body.getHead().linkBtnToController(controller);
        getChildren().add(body);
        setBehaviourHighlight();
        isHighlight = false;
    }

    /**
     * This method highlights the window.
     */
    public void highlight(){
        this.isHighlight = true;
        this.body.getHead().highlight();
        this.raise();
    }

    /**
     * This method unhighlights the window.
     */
    private void unHighlight(){
        this.body.getHead().unHighlight();
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

    public void changeHeadName(String name){
        this.body.getHead().setTitle(name);
    }

    /**
     * This method sets the behaviour, so when its highlighted and clicked, it will be unhighlighted.
     */
    private void setBehaviourHighlight(){

        setOnMouseClicked((event) ->{
            if(isHighlight) {
                this.unHighlight();
                this.isHighlight = false;
            }
        });

    }
}
