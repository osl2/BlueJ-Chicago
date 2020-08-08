package osl2.view.datastructures.nodey;

import javafx.scene.layout.Pane;
import osl2.view.ui.EvanstonWindow;

import java.util.HashMap;
import java.util.Map;

public class ArrowPane extends Pane {
    private Map<GUINode, Arrow> arrows = new HashMap<>();
    private ArrowOverlay overlay;

    public ArrowPane() {
        setPickOnBounds(false);
    }

    public void setOverlay(ArrowOverlay overlay) {
        if (this.overlay != null) clear();
        this.overlay = overlay;
    }

    public void connect(GUINode node) {
        if (!arrows.containsKey(node)) {
            Arrow arrow = new Arrow(overlay,this, node);
            arrows.put(node, arrow);
            overlay.addArrow(arrow);
        }
    }

    public void disconnect(GUINode node) {
        Arrow arrow = arrows.get(node);
        if (arrow != null) {
            arrow.disconnect();
            arrows.remove(node);
            overlay.removeArrow(arrow);
        }
    }

    public void clear() {
        for (GUINode node : arrows.keySet()) {
            disconnect(node);
        }
    }
}