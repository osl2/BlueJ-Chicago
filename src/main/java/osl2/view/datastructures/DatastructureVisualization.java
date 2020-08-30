package osl2.view.datastructures;

import javafx.scene.Node;
import osl2.messaging.datastructures.DatastructureCommunication;
import osl2.messaging.error_handling.UserError;
import osl2.view.ui.EvanstonWindow;
import osl2.view.ui.localisation.LanguageController;
import osl2.view.ui.mirror.IMirrorController;

/**
 * The abstract class for all visualization.
 *
 * @param <T>
 *         The contents of the visualization.
 */
public abstract class DatastructureVisualization<T extends Node> implements DatastructureCommunication {
    private final T contents;
    private final LanguageController languageController;
    private String name;
    private IMirrorController mirrorController;

    /**
     * Creates a new visualization.
     *
     * @param contents
     *         The contents of the visualisation.
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
     * @param name
     *         The name.
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
     * @param mirrorController
     *         The MirrorController.
     */
    public void setMirrorController(IMirrorController mirrorController) {
        this.mirrorController = mirrorController;
    }

    @Override
    public void handleError(UserError userError) {
        EvanstonWindow.getInstance().showErrorDialog(userError);
    }
}
