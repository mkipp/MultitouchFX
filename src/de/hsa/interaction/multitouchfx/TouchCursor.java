package de.hsa.interaction.multitouchfx;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 *
 * @author Michael Kipp
 */
public class TouchCursor extends Group {
    
    private int radius;
    private Circle circle;
    private Line lineHor;
    private Line lineVert;

    public TouchCursor(int radius) {
        this.radius = radius;
        circle = new Circle(radius);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(2);
        lineHor = new Line();
        lineHor.setStroke(Color.BLACK);
        lineHor.setStrokeWidth(2);
        lineVert = new Line();
        lineVert.setStroke(Color.BLACK);
        lineVert.setStrokeWidth(2);
        getChildren().addAll(circle, lineHor, lineVert);
    }
    
    public void setCenter(double x, double y) {
        circle.setCenterX(x);
        circle.setCenterY(y);
        lineHor.setStartX(x - radius);
        lineHor.setStartY(y);
        lineHor.setEndX(x + radius);
        lineHor.setEndY(y);
        lineVert.setStartX(x);
        lineVert.setStartY(y - radius);
        lineVert.setEndX(x);
        lineVert.setEndY(y + radius);
    }
}
