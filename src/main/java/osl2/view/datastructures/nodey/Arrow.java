package osl2.view.datastructures.nodey;

import javafx.beans.InvalidationListener;
import javafx.beans.binding.NumberExpressionBase;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


public class Arrow extends Group {

    public Arrow(GUINode from, GUINode to, Color color) {
        Line line = new Line();

        NumberExpressionBase endX = to.layoutXProperty().subtract(from.layoutXProperty()).add(to.getBoundsInLocal().getWidth() / 2.0);
        NumberExpressionBase endY = to.layoutYProperty().subtract(from.layoutYProperty()).add(to.getBoundsInLocal().getHeight() / 2.0);

        line.endXProperty().bind(endX);
        line.endYProperty().bind(endY);


        Line arrow1 = new Line();
        Line arrow2 = new Line();

        InvalidationListener updater = o -> {
            final int arrowLength = 10;
            final int arrowWidth = 5;

            double ex = endX.getValue().doubleValue();
            double ey = endY.getValue().doubleValue();
            double sx = 0;
            double sy = 0;

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
        from.boundsInLocalProperty().addListener(updater);
        endX.addListener(updater);
        endY.addListener(updater);
        updater.invalidated(null);

        getChildren().add(line);
        getChildren().add(arrow1);
        getChildren().add(arrow2);
    }
}
