package osl2.view.datastructures.nodey;

import javafx.scene.layout.Pane;
import osl2.view.ui.EvanstonWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * The Arrowpane is the place where an arrow starts.
 */
public class ArrowPane extends Pane {
    private Map<GUINode, Arrow> arrows = new HashMap<>();
    private ArrowOverlay overlay;

    /**
     * Creates a new Arrowpane.
     */
    public ArrowPane() {
        setPickOnBounds(false);
    }

    /**
     * Sets the overlay for this ArrowPane.
     * @param overlay The overlay.
     */
    public void setOverlay(ArrowOverlay overlay) {
        if (this.overlay != null) clear();
        this.overlay = overlay;
    }

    /**
     * Connects the ArrowPane to a node.
     * @param node The node.
     */
    public void connect(GUINode node) {
        if (!arrows.containsKey(node)) {
            Arrow arrow = new Arrow(overlay,this, node);
            arrows.put(node, arrow);
            overlay.addArrow(arrow);
        }
    }

    /**
     * Disconnects the ArrowPane from a node.
     * @param node The node.
     */
    public void disconnect(GUINode node) {
        Arrow arrow = arrows.get(node);
        if (arrow != null) {
            arrow.disconnect();
            arrows.remove(node);
            overlay.removeArrow(arrow);
        }
    }

    /**
     * Disconnects the ArrowPane from all nodes.
     */
    public void clear() {
        GUINode[] nodeArr = arrows.keySet().toArray(new GUINode[]{});
        for (GUINode node : nodeArr) {
            disconnect(node);
        }
    }
}