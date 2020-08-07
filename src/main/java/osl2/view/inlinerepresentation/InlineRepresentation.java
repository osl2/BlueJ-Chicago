package osl2.view.inlinerepresentation;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * A inline representation for the elements inside an datastructure.
 */
public class InlineRepresentation extends Button {    // TODO: Make this a clickable pane
    private static final Map<Object, Runnable> inlineRepresentationFunctions = new WeakHashMap<>();

    /**
     * Creates a new InlineRepresentation.
     *
     * @param text   The text of the inlinerepresentation.
     * @param action The action which happens, when the InlineRepresentation
     */
    public InlineRepresentation(String text, Runnable action) {
        super(text);
        setOnAction(event -> action.run());
    }

    /**
     * Associates an action to a object.
     *
     * @param value  The object.
     * @param action The action.
     */
    public static void registerInlineAction(Object value, Runnable action) {
        inlineRepresentationFunctions.put(value, action);
    }

    /**
     * Returns a new Inlinerepresentation if the value is a Datastructure. Else just a label with the content.
     *
     * @param value The value which will be added to the visualization.
     * @return A Inlinerepresentation or a Label.
     */
    public static Node get(Object value) {
        String text = ((value == null) ? "null" : value.toString());
        Runnable action = inlineRepresentationFunctions.get(value);
        if (action != null) return new InlineRepresentation(text, action);
        else return new Label(text);
    }
}
