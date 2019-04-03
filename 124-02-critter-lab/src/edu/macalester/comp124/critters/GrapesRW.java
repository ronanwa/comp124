package edu.macalester.comp124.critters;

import comp124graphics.Ellipse;

import java.awt.*;

public class GrapesRW extends Critter {

    private static final Color
            strokeColor = new Color(0,0,0),
            fillColor = new Color(119, 36, 152),
            fillColorMain = new Color (128, 87, 176),
            eyeColor = new Color(11, 255, 0);


    @Override
    protected void buildGraphics() {
        xOffset = 20.0;
        yOffset = 56.0;


        // Right Side
        Ellipse legR1 = new Ellipse(40,0,30,30);
        legR1.setStrokeColor(strokeColor);
        legR1.setFilled(true);
        legR1.setFillColor(fillColor);
        addLeg(new Leg(legR1,2));

        Ellipse legR2 = new Ellipse(50,-20,30,30);
        legR2.setStrokeColor(strokeColor);
        legR2.setFilled(true);
        legR2.setFillColor(fillColor);
        addLeg(new Leg(legR2,2));

        Ellipse legR3 = new Ellipse(45,-40,30,30);
        legR3.setStrokeColor(strokeColor);
        legR3.setFilled(true);
        legR3.setFillColor(fillColor);
        addLeg(new Leg(legR3,2));

        // Left Side
        Ellipse legL1 = new Ellipse(-10,0,30,30);
        legL1.setStrokeColor(strokeColor);
        legL1.setFilled(true);
        legL1.setFillColor(fillColor);
        addLeg(new Leg(legL1,2));

        Ellipse legL2 = new Ellipse(-20,-20,30,30);
        legL2.setStrokeColor(strokeColor);
        legL2.setFilled(true);
        legL2.setFillColor(fillColor);
        addLeg(new Leg(legL2,2));

        Ellipse legL3 = new Ellipse(-15,-40,30,30);
        legL3.setStrokeColor(strokeColor);
        legL3.setFilled(true);
        legL3.setFillColor(fillColor);
        addLeg(new Leg(legL3,2));

        // Main abdomen
        Ellipse body = new Ellipse(0,-40,60,60);
        body.setFilled(true);
        body.setFillColor(fillColorMain);
        getGraphics().add(body);

        // Eye
        Eye mainEye = new Eye(20, 0.26,0.18,eyeColor);
        addEye(mainEye,30,-10);


    }
}
