package edu.macalester.comp124.critters;

import comp124graphics.Rectangle;

import java.awt.Color;

/**
 * @author Paul Cantrell
 */
public class BoxBot extends Critter {

    private static final Color
            strokeColor = new Color(40, 40, 60),
            fillColor   = new Color(160, 172, 182);


    @Override
    protected void buildGraphics() {
        //
        // NOTE: the way this is drawn with negative values for x and y for parts
        //       of this critter, the initial location should be at least +20, +56
        //
        xOffset = 20.0;
        yOffset = 56.0;

        Rectangle leftLeg  = new Rectangle(-16, 0, 10, 40);
        leftLeg.setStrokeColor(strokeColor);
        leftLeg.setFilled(true);
        leftLeg.setFillColor(fillColor);
        addLeg(new Leg(leftLeg, 2));   // this leg will be animated when running CritterParty

        Rectangle rightLeg = new Rectangle( 6, 0, 10, 40);
        rightLeg.setStrokeColor(strokeColor);
        rightLeg.setFilled(true);
        rightLeg.setFillColor(fillColor);
        addLeg(new Leg(rightLeg, 2));   // this leg will be animated when running CritterParty

        Rectangle body = new Rectangle(-20, -30, 40, 40);
        body.setStrokeColor(strokeColor);
        body.setFilled(true);
        body.setFillColor(fillColor);
        getGraphics().add(body);

        Rectangle head = new Rectangle(-18, -56, 36, 20);
        head.setStrokeColor(strokeColor);
        head.setFilled(true);
        head.setFillColor(fillColor);
        getGraphics().add(head);

        Eye leftEye = new Eye(6, 0.26, 0.18, Color.BLUE);
        Eye rightEye = new Eye(6, 0.26, 0.18, Color.BLUE);
        addEye(leftEye, -10, -46);
        addEye(rightEye, 10, -46);
    }



}
