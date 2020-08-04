package osl2.view.datastructures;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import osl2.Evanston;
import osl2.messaging.datastructures.DatastructureCommunication;
import osl2.messaging.errorHandling.UserError;
import osl2.view.ui.mirror.IMirrorController;

public abstract class DatastructureVisualization extends HBox implements DatastructureCommunication {

    private String name;

    private IMirrorController mirrorController;


    public String getName(){
        return name;
    }

    public abstract Node asNode();

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
