package osl2.view.datastructures.nodey;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;


public class Arrow extends Group {
    private final ArrowPane from;
    private final GUINode to;
    private final ChangeListener updater;

    private void connect() {
        from.localToSceneTransformProperty().addListener(updater);
        to.layoutXProperty().addListener(updater);
        to.layoutYProperty().addListener(updater);
        updater.changed(null, null, null);
    }

    public void disconnect() {
        from.localToSceneTransformProperty().removeListener(updater);
        to.layoutXProperty().removeListener(updater);
        to.layoutYProperty().removeListener(updater);
    }


    public Arrow(ArrowPane from, GUINode to) {
        this.from = from;
        this.to = to;

        Line line = new Line();
        Line arrow1 = new Line();
        Line arrow2 = new Line();

        this.updater = (o, p, q) -> {
            final int arrowLength = 10;
            final int arrowWidth = 5;

            Point2D startPos = from.localToScene(0, 0);
            Point2D endPos = to.localToScene(0, 0);

            double sx = startPos.getX();
            double sy = startPos.getY();
            double ex = endPos.getX();
            double ey = endPos.getY();

            line.setStartX(sx);
            line.setStartY(sy);
            line.setEndX(ex);
            line.setEndY(ey);

            arrow1.setEndX(ex);
            arrow1.setEndY(ey);

            arrow2.setEndX(ex);
            arrow2.setEndY(ey);

            if (ex == sx && ey == sy) {
                // arrow parts of length 0
                arrow1.setStartX(ex);
                arrow1.setStartY(ey);
                arrow2.setStartX(ex);
                arrow2.setStartY(ey);
            } else {
                double factor = arrowLength / Math.hypot(sx-ex, sy-ey);
                double factorO = arrowWidth / Math.hypot(sx-ex, sy-ey);

                double dx = (sx - ex) * factor;
                double dy = (sy - ey) * factor;

                double ox = (sx - ex) * factorO;
                double oy = (sy - ey) * factorO;

                arrow1.setStartX(ex + dx - oy);
                arrow1.setStartY(ey + dy + ox);
                arrow2.setStartX(ex + dx + oy);
                arrow2.setStartY(ey + dy - ox);
            }
        };

        getChildren().add(line);
        getChildren().add(arrow1);
        getChildren().add(arrow2);

        setManaged(false);

        ChangeListener hideListener = new ChangeListener<Scene>() {
            @Override
            public void changed(ObservableValue<? extends Scene> observableValue, Scene scene, Scene t1) {
                setVisible(t1 != null);
            }
        };

        to.sceneProperty().addListener(hideListener);
        from.sceneProperty().addListener(hideListener);

        connect();
    }
}
