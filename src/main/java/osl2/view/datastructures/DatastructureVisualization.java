package osl2.view.datastructures;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import osl2.Evanston;
import osl2.messaging.datastructures.DatastructureCommunication;
import osl2.messaging.errorHandling.UserError;
import osl2.view.ui.mirror.IMirrorController;

public abstract class DatastructureVisualization<T extends Node> implements DatastructureCommunication {
    private String name;
    private final T contents;
    private IMirrorController mirrorController;

    public DatastructureVisualization(T contents) {
        this.name = "???";
        this.contents = contents;
    }

    public String getName(){
        return name;
    }

    public final Node asNode() { return contents; }
    protected final T getContents() { return contents; }

    public void setMirrorController(IMirrorController mirrorController){
        this.mirrorController = mirrorController;
    }
    public void setName(String name){
        this.name = name;
        if(mirrorController != null){
            mirrorController.setName(name);
        }
    }

    @Override
    public void handleError(UserError userError) {
        showErrorDialog(userError);
        Evanston.getPlayController().pause();
    }

    private void showErrorDialog(UserError userError) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Benutzerfehler");
        alert.setHeaderText(userError.getErrorName());
        String contentText = userError.getErrorContent() + "\n" + "Die fehlerverursachende Methode wurde nicht ausgeführt.";
        alert.setContentText(contentText);
        alert.showAndWait();
    }
}
