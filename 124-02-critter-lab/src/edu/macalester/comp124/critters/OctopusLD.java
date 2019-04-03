package edu.macalester.comp124.critters;

import comp124graphics.Arc;
import comp124graphics.Ellipse;
import comp124graphics.GraphicsGroup;
import comp124graphics.Line;

import java.awt.*;

public class OctopusLD extends Critter {

    @Override
    protected void buildGraphics() {
        // these offsets are designed to be added to the location of initial placement
        // of this Critter, since we use negative x and y values to place parts of it
        // on the graphics GCompound
//        xOffset = 44.0;
//        yOffset = 30.0;
//
        createLeg(50, 120);
        createLeg(60, 150);
        createLeg(70, 120);
//        createLeg( 30,  10,  40,  20);
//        createLeg( 34, -10,  44,   0);
//        createLeg( 30, -30,  40, -20);

        Ellipse body = new Ellipse(50, 50, 50, 100);

        body.setFilled(true);
        body.setFillColor(new Color(100, 255, 100));
        body.setStroked(false);
        getGraphics().add(body);

        Eye leftEye = new Eye(10, 0.5, 0.1, new Color(50, 50, 255));
        Eye midEye = new Eye(10, 0.6, 0.2, new Color(255, 255, 15));
        Eye rightEye = new Eye(10, 0.5, 0.1, new Color(255, 50, 50));
        addEye(leftEye, 60, 80);

        addEye(rightEye, 90, 80);
        addEye(midEye, 75, 75);
    }

    private void createLeg(double x, double y) {


        GraphicsGroup legGroup = new GraphicsGroup(0,0);
        Color color = new Color(100, 255, 100);
        Arc leg1 = new Arc(x, y, 20, 30, 70, 200);
        leg1.setStrokeColor(color);
        leg1.setStrokeWidth(10);
        legGroup.add(leg1);

        Arc leg2 = new Arc(x, y+30, 20, 30, -120, 210);
        leg2.setStrokeColor(color);
        leg2.setStrokeWidth(10);
        legGroup.add(leg2);


        addLeg(new Leg(legGroup, 2));
    }
}
