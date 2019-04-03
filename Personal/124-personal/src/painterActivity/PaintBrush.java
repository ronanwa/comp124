package painterActivity;

import comp124graphics.CanvasWindow;
import comp124graphics.Ellipse;
import java.awt.geom.Point2D;
import java.awt.*;


public class PaintBrush {
    double brushRadius;
    Color brushColor;
    CanvasWindow canvas;
    public static final double DEFAULT_BRUSH_RADIUS = 20;
    public static final Color DEFAULT_BRUSH_COLOR = Color.BLACK;

    public PaintBrush(double brushRadius, Color brushColor, CanvasWindow canvas){
        brushRadius = brushRadius;
        brushColor = brushColor;
        canvas = canvas;
    }

    public void apply(double x, double y){

        Ellipse paint=new Ellipse(x,y,50,50);
    }

}
