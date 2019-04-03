package edu.macalester.comp124.critters;

import comp124graphics.Arc;
import comp124graphics.Ellipse;
import comp124graphics.Rectangle;

import java.awt.*;

public class MPCritter extends Critter{

    private static final Color
            strokeColor = new Color(105,5,50),
            fillColor   = new Color(245,180,228);


    @Override
    protected void buildGraphics() {

        xOffset = 20.0;
        yOffset = 56.0;

        comp124graphics.Ellipse leftLeg  = new comp124graphics.Ellipse(-16, 0, 10, 10);
        leftLeg.setStrokeColor(strokeColor);
        leftLeg.setFilled(true);
        leftLeg.setFillColor(fillColor);
        addLeg(new Leg(leftLeg, 2));   // this leg will be animated when running CritterParty

        comp124graphics.Ellipse rightLeg = new comp124graphics.Ellipse( 6, 0, 10, 10);
        rightLeg.setStrokeColor(strokeColor);
        rightLeg.setFilled(true);
        rightLeg.setFillColor(fillColor);
        addLeg(new Leg(rightLeg, 2));   // this leg will be animated when running CritterParty

        comp124graphics.Ellipse leftArm  = new comp124graphics.Ellipse(-23, -25, 10, 10);
        leftArm.setStrokeColor(strokeColor);
        leftArm.setFilled(true);
        leftArm.setFillColor(fillColor);
        addLeg(new Leg(leftArm, 2));

        comp124graphics.Ellipse rightArm = new comp124graphics.Ellipse(13, -25, 10, 10);
        rightArm.setStrokeColor(strokeColor);
        rightArm.setFilled(true);
        rightArm.setFillColor(fillColor);
        addLeg(new Leg(rightArm, 2));

        comp124graphics.Ellipse body = new comp124graphics.Ellipse(-20, -30, 40, 40);
        body.setStrokeColor(strokeColor);
        body.setFilled(true);
        body.setFillColor(fillColor);
        getGraphics().add(body);

        comp124graphics.Ellipse leftEar = new Ellipse(-9, -90, 7, 50);
        leftEar.setStrokeColor(strokeColor);
        leftEar.setFilled(true);
        leftEar.setFillColor(fillColor);
        getGraphics().add(leftEar);

        comp124graphics.Ellipse rightEar = new Ellipse(1, -90, 7, 50);
        rightEar.setStrokeColor(strokeColor);
        rightEar.setFilled(true);
        rightEar.setFillColor(fillColor);
        getGraphics().add(rightEar);

        comp124graphics.Ellipse head = new Ellipse(-18, -56, 36, 36);
        head.setStrokeColor(strokeColor);
        head.setFilled(true);
        head.setFillColor(fillColor);
        getGraphics().add(head);

        comp124graphics.Arc mouth2 = new Arc(-7, -37, 7, 7, 200.0, 140.0);
        mouth2.setStrokeColor(strokeColor);
        getGraphics().add(mouth2);

        comp124graphics.Arc mouth1 = new Arc(0, -37, 7, 7, 200.0, 140.0);
        mouth1.setStrokeColor(strokeColor);
        getGraphics().add(mouth1);

        Eye leftEye = new Eye(6, 0.26, 0.18, Color.PINK);
        Eye rightEye = new Eye(6, 0.26, 0.18, Color.PINK);
        addEye(leftEye, -10, -46);
        addEye(rightEye, 10, -46);
    }
}
