package osl2.view.datastructures.nodey;

import javafx.scene.layout.Pane;
import osl2.view.ui.EvanstonWindow;

import java.util.HashMap;
import java.util.Map;

public class ArrowPane extends Pane {
    private Map<GUINode, Arrow> arrows = new HashMap<>();

    public ArrowPane() {
        setPickOnBounds(false);
    }

    public void connect(GUINode node) {
        if (!arrows.containsKey(node)) {
            Arrow arrow = new Arrow(this, node);
            arrows.put(node, arrow);
            EvanstonWindow.getInstance().getArrowOverlay().addArrow(arrow);
        }
    }

    public void disconnect(GUINode node) {
        Arrow arrow = arrows.get(node);
        if (arrow != null) {
            arrow.disconnect();
            arrows.remove(node);
            EvanstonWindow.getInstance().getArrowOverlay().removeArrow(arrow);
        }
    }

    public void clear() {
        for (GUINode node : arrows.keySet()) {
            disconnect(node);
        }
    }
}
