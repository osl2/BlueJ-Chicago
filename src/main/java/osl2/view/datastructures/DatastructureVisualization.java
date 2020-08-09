package osl2.view.datastructures;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import osl2.Evanston;
import osl2.messaging.datastructures.DatastructureCommunication;
import osl2.messaging.errorHandling.UserError;
import osl2.view.inlinerepresentation.InlineRepresentation;
import osl2.view.ui.localisation.LanguageController;
import osl2.view.ui.mirror.IMirrorController;

import java.util.LinkedList;

/**
 * The abstract class for all visualization.
 *
 * @param <T> The contents of the visualization.
 */
public abstract class DatastructureVisualization<T extends Node> implements DatastructureCommunication {
    private final T contents;
    private String name;
    private IMirrorController mirrorController;
    private LanguageController languageController;

    /**
     * Creates a new visualization.
     *
     * @param contents The contents of the visualisation.
     */
    public DatastructureVisualization(T contents) {
        this.name = "???";
        this.contents = contents;
        this.languageController = LanguageController.getLanguageController();
    }

    /**
     * Returns the name of the datastructure which is visualized.
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name for the visualisation.
     *
     * @param name The name.
     */
    public void setName(String name) {
        this.name = name;
        if (mirrorController != null) {
            mirrorController.setName(name);
        }
    }

    /**
     * Returns the contents of the visualization.
     *
     * @return The contents as nodes.
     */
    public final Node asNode() {
        return contents;
    }

    /**
     * Returns the Contents.
     *
     * @return Returns the contents.
     */
    protected final T getContents() {
        return contents;
    }

    /**
     * Sets the MirrorController for this Visualisation.
     *
     * @param mirrorController The MirrorController.
     */
    public void setMirrorController(IMirrorController mirrorController) {
        this.mirrorController = mirrorController;
    }

    @Override
    public void handleError(UserError userError) {
        showErrorDialog(userError);
    }

    /**
     * Shows the error in an errorpane.
     *
     * @param userError The error of the datastructure.
     */
    private void showErrorDialog(UserError userError) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(languageController.getMessage("UserError"));
        alert.setHeaderText(userError.getErrorName());
        String contentText = userError.getErrorContent() + "\n" + languageController.getMessage("ErrorSkipped");
        alert.setContentText(contentText);
        alert.showAndWait();
    }

}
