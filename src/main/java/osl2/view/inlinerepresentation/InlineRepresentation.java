package osl2.view.inlinerepresentation;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import osl2.datastructures.EvanstonDatastructure;

import java.util.Map;
import java.util.WeakHashMap;

public class InlineRepresentation extends Button {    // TODO: Make this a clickable pane
    private static final Map<Object, Runnable> inlineRepresentationFunctions = new WeakHashMap<>();

    public InlineRepresentation(String text, Runnable action) {
        super(text);
        setOnAction(event -> action.run());
    }

    public static void registerInlineAction(Object value, Runnable action) {
        inlineRepresentationFunctions.put(value, action);
    }

    public static Node get(Object value) {
        String text = ((value == null) ? "null" : value.toString());
        Runnable action = inlineRepresentationFunctions.get(value);
        if (action != null) return new InlineRepresentation(text, action);
        else return new Label(text);
    }
}
