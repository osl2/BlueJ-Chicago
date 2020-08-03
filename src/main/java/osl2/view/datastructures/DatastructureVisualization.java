package osl2.view.datastructures;

import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import osl2.Evanston;
import osl2.messaging.datastructures.DatastructureCommunication;
import osl2.messaging.errorHandling.UserError;

public abstract class DatastructureVisualization extends HBox implements DatastructureCommunication {
    public abstract String getName();

    public abstract Node asNode();

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
