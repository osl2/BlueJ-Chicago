package osl2.view.datastructures.sequential;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import osl2.view.datastructures.DatastructureVisualization;

/**
 * The visualisation class for a sequential datastructure like map or array. With two rows.
 */
public abstract class GUISequential extends DatastructureVisualization<HBox> {
    private final GUISequentialEntry head;

    /**
     * Creates a new sequential visualisation.
     *
     * @param firstRowLabel
     *         The name of the first row.
     * @param secondRowLabel
     *         The name of the second row
     */
    protected GUISequential(String firstRowLabel, String secondRowLabel) {
        super(new HBox());
        getContents().setSpacing(10);
        head = new GUISequentialEntry(new Label(firstRowLabel), new Label(secondRowLabel));
        clearElements();    // This will insert the head
    }

    /**
     * Clears all elements and sets the head new.
     */
    protected void clearElements() {
        getContents().getChildren().clear();
        getContents().getChildren().add(head);
    }

    /**
     * Puts an element at index i with a value for the first row.
     *
     * @param i
     *         The index.
     * @param value
     *         The value.
     */
    protected void putElement(int i, Node value) {
        Label label = new Label("" + i);
        label.setMaxWidth(Double.MAX_VALUE);
        label.setAlignment(Pos.CENTER);
        putElement(i + 1, value, label);
    }

    /**
     * Puts an element with values for both rows at an index.
     *
     * @param i
     *         The index.
     * @param above
     *         The value for the row above.
     * @param below
     *         The value for the row below.
     */
    protected void putElement(int i, Node above, Node below) {
        while (getContents().getChildren().size() - 1 <= i) {
            getContents().getChildren().add(new GUISequentialEntry(above, below));
        }
        getContents().getChildren().set(i + 1, new GUISequentialEntry(above, below));
    }

    /**
     * Removes an element at an index.
     *
     * @param i
     *         The index, where the element should be removed.
     */
    protected void removeElement(int i) {
        if (i >= 0 && i < getContents().getChildren().size() - 1) {
            getContents().getChildren().remove(i + 1);
        }
    }

    /**
     * The Class for a entry in a sequential datastructure.
     */
    private class GUISequentialEntry extends VBox {

        /**
         * Creates a new entry.
         *
         * @param above
         *         The value for the first row.
         * @param below
         *         The value for the second row.
         */
        public GUISequentialEntry(Node above, Node below) {
            setSpacing(5);
            getChildren().add(above);
            getChildren().add(below);
        }
    }
}
