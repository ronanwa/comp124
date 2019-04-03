package edu.macalester.comp124.critters;

import comp124graphics.*;

import comp124graphics.Rectangle;

import java.awt.Color;


public class KSCritter extends Critter {
    private static final Color
        bodyColor = new Color(255,0,100),
        outlineColor = new Color(0,0,0);


    @Override
    protected void buildGraphics() {

        xOffset = 44.0;
        yOffset = 50.0;

        createLeg(-30,  10, -40,  20);
        createLeg(-30, -10, -44,   0);
        createLeg(-30, -30, -40, -20);
        createLeg( 30,  10,  40,  20);
        createLeg( 34, -10,  44,   0);
        createLeg( 30, -30,  40, -20);

        Line leftleg = new Line(-15,-20,-25,-35);
        leftleg.setStrokeWidth(3);
        leftleg.setStrokeColor(outlineColor);
        getGraphics().add(leftleg);

        Line rightleg = new Line(15,-20, 25,-35);
        rightleg.setStrokeWidth(3);
        rightleg.setStrokeColor(outlineColor);
        getGraphics().add(rightleg);

        Ellipse body = new Ellipse(-25,-15,50,100);
        body.setStrokeColor(outlineColor);
        body.setFilled(true);
        body.setFillColor(bodyColor);
        getGraphics().add(body);

        Ellipse thorax = new Ellipse(-25,-45,50,100);
        thorax.setStrokeColor(outlineColor);
        thorax.setFilled(true);
        thorax.setFillColor(bodyColor);
        getGraphics().add(thorax);

        Ellipse tail = new Ellipse(-37,75,75,25);
        tail.setStrokeColor(outlineColor);
        tail.setFilled(true);
        tail.setFillColor(bodyColor);
        getGraphics().add(tail);

        Ellipse leftclaw = new Ellipse(-50,-75,30,45);
        leftclaw.setStrokeColor(outlineColor);
        leftclaw.setFilled(true);
        leftclaw.setFillColor(bodyColor);
        getGraphics().add(leftclaw);

        Ellipse rightclaw = new Ellipse(20,-75,30,45);
        rightclaw.setStrokeColor(outlineColor);
        rightclaw.setFilled(true);
        rightclaw.setFillColor(bodyColor);
        getGraphics().add(rightclaw);

        Eye leftEye = new Eye(6, 0.46, 0.05, Color.BLACK);
        Eye rightEye = new Eye(6, 0.46, 0.05, Color.BLACK);
        addEye(leftEye, -10, -55);
        addEye(rightEye, 10, -55);

        //Just to make committing work

    }

    private void createLeg(double x0, double y0, double x1, double y1){
        //Structure taken from Paul Cantrell's Roundbug

        GraphicsGroup legGroup = new GraphicsGroup(0,0);
        Line legLine0 = new Line(0, -2, x0, y0-1);
        legLine0.setStrokeColor(bodyColor);
        legGroup.add(legLine0);

        Line legLine1 = new Line(x0, y0-1, x1, y1);
        legLine1.setStrokeColor(bodyColor);
        legGroup.add(legLine1);

        Line legLine2 = new Line(x1, y1, x0, y0+1);
        legLine2.setStrokeColor(bodyColor);
        legGroup.add(legLine2);

        Line legLine3 = new Line(x0, y0+1, 0, 5);
        legLine3.setStrokeColor(bodyColor);
        legGroup.add(legLine3);

        addLeg(new Leg(legGroup, 4));
    }
}
