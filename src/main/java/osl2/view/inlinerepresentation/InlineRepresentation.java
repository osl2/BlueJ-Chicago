package osl2.view.inlinerepresentation;

import javafx.scene.Node;
import javafx.scene.control.Label;
import osl2.datastructures.EvanstonDatastructure;

import java.util.Map;
import java.util.WeakHashMap;

public class InlineRepresentation extends Label {    // TODO: Make this a clickable pane
    private static final Map<EvanstonDatastructure, InlineRepresentation> inlineRepresentations = new WeakHashMap<>();

    public InlineRepresentation(EvanstonDatastructure datastructure) {
        super(datastructure.toString());
    }

    public static Node get(Object value) {
        if (value instanceof EvanstonDatastructure) {
            EvanstonDatastructure key = (EvanstonDatastructure) value;
            if (inlineRepresentations.containsKey(key)) {
                return inlineRepresentations.get(key);
            } else {
                InlineRepresentation repr = new InlineRepresentation(key);
                inlineRepresentations.put(key, repr);
                return repr;
            }
        }
        return new Label(((value == null) ? "null" : value.toString()));
    }
}
