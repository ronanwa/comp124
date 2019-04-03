package edu.macalester.comp124.critters;

import comp124graphics.Ellipse;
import comp124graphics.GraphicsGroup;
import comp124graphics.Line;

import java.awt.*;

/**
 * @author Paul Cantrell
 */
public class RoundBug extends Critter {

    @Override
    protected void buildGraphics() {
        // these offsets are designed to be added to the location of initial placement
        // of this Critter, since we use negative x and y values to place parts of it
        // on the graphics GCompound
        xOffset = 44.0;
        yOffset = 30.0;

        createLeg(-30,  10, -40,  20);
        createLeg(-30, -10, -44,   0);
        createLeg(-30, -30, -40, -20);
        createLeg( 30,  10,  40,  20);
        createLeg( 34, -10,  44,   0);
        createLeg( 30, -30,  40, -20);

        Ellipse body = new Ellipse(-25, -25, 50, 50);
        body.setFilled(true);
        body.setFillColor(new Color(158, 103, 12));
        getGraphics().add(body);

        Eye leftEye = new Eye(10, 0.46, 0.18, Color.GREEN);
        Eye rightEye = new Eye(10, 0.46, 0.18, Color.GREEN);
        addEye(leftEye, -18, 10);
        addEye(rightEye, 18, 10);
    }

    private void createLeg(double x0, double y0, double x1, double y1) {
        GraphicsGroup legGroup = new GraphicsGroup(0,0);
        Color color = new Color(95, 62, 7);
        Line legLine0 = new Line(0, -2, x0, y0-1);
        legLine0.setStrokeColor(color);
        legGroup.add(legLine0);

        Line legLine1 = new Line(x0, y0-1, x1, y1);
        legLine1.setStrokeColor(color);
        legGroup.add(legLine1);

        Line legLine2 = new Line(x1, y1, x0, y0+1);
        legLine2.setStrokeColor(color);
        legGroup.add(legLine2);

        Line legLine3 = new Line(x0, y0+1, 0, 5);
        legLine3.setStrokeColor(color);
        legGroup.add(legLine3);


        addLeg(new Leg(legGroup, 4));
    }
}
