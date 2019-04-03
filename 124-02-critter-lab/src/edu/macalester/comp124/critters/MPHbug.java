package edu.macalester.comp124.critters;

import comp124graphics.*;
import comp124graphics.Rectangle;

import java.awt.*;

public class MPHbug extends Critter {

    private static final Color strokeColor = new Color(150, 100, 155);
    private static final Color fillColor = strokeColor;

    @Override
    protected void buildGraphics() {

        comp124graphics.Rectangle leftLeg  = new comp124graphics.Rectangle(-16, 0, 5, 40);
        leftLeg.setStrokeColor(strokeColor);
        leftLeg.setFilled(true);
        leftLeg.setFillColor(fillColor);
        addLeg(new Leg(leftLeg, 1));

        comp124graphics.Rectangle rightLeg = new comp124graphics.Rectangle( 6, 0, 5, 40);
        rightLeg.setStrokeColor(strokeColor);
        rightLeg.setFilled(true);
        rightLeg.setFillColor(fillColor);
        addLeg(new Leg(rightLeg, 2));

        Ellipse headL = new Ellipse(-25, -25, 25, 25);
        headL.setFilled(true);
        headL.setFillColor(new Color(200, 13, 12));
        getGraphics().add(headL);

        Ellipse headM = new Ellipse(-13, -40, 25, 25);
        headM.setFilled(true);
        headM.setFillColor(new Color(50, 103, 12));
        getGraphics().add(headM);

        Ellipse headR = new Ellipse(0, -25, 25, 25);
        headR.setFilled(true);
        headR.setFillColor(new Color(50, 13, 212));
        getGraphics().add(headR);

        Eye leftEye = new Eye(8.5, 0.16, 0.18, Color.GREEN);
        addEye(leftEye, -13, -12);

        Eye rightEye = new Eye(8.5, 0.16, 0.18, Color.RED);
        addEye(rightEye, 12, -12);

        Eye middleEye = new Eye(8.5, 0.16, 0.18, Color.BLUE);
        addEye(middleEye, -1, -27);
    }



    }
