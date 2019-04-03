package edu.macalester.comp124.critters;

import comp124graphics.CanvasWindow;
import comp124graphics.GraphicsObject;
import org.reflections.Reflections;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class KLbug extends Critter {

    private static final Color
            strokeColor = new Color(0, 100, 200),
            fillColor   = new Color(69, 42, 0);


    @Override
    protected void buildGraphics() {
        //
        // NOTE: the way this is drawn with negative values for x and y for parts
        //       of this critter, the initial location should be at least +20, +56
        //
        xOffset = 20.0;
        yOffset = 56.0;


        //bottom legs
        comp124graphics.Rectangle leftLeg  = new comp124graphics.Rectangle(-16, 0, 5, 40);
        leftLeg.setStrokeColor(strokeColor);
        leftLeg.setFilled(true);
        leftLeg.setFillColor(fillColor);
        addLeg(new Leg(leftLeg, 1));   // this leg will be animated when running CritterParty

        comp124graphics.Rectangle rightLeg = new comp124graphics.Rectangle( 6, 0, 5, 40);
        rightLeg.setStrokeColor(strokeColor);
        rightLeg.setFilled(true);
        rightLeg.setFillColor(fillColor);
        addLeg(new Leg(rightLeg, 2));   // this leg will be animated when running CritterParty

        comp124graphics.Rectangle middleLeg = new comp124graphics.Rectangle( -5, 0, 5, 40);
        middleLeg.setStrokeColor(strokeColor);
        middleLeg.setFilled(true);
        middleLeg.setFillColor(fillColor);
        addLeg(new Leg(middleLeg, 3));

        //top legs
        comp124graphics.Rectangle leftLegT  = new comp124graphics.Rectangle(-16, -60, 5, 40);
        leftLegT.setStrokeColor(strokeColor);
        leftLegT.setFilled(true);
        leftLegT.setFillColor(fillColor);
        addLeg(new Leg(leftLegT, 1));   // this leg will be animated when running CritterParty

        comp124graphics.Rectangle rightLegT = new comp124graphics.Rectangle( 6, -60, 5, 40);
        rightLegT.setStrokeColor(strokeColor);
        rightLegT.setFilled(true);
        rightLegT.setFillColor(fillColor);
        addLeg(new Leg(rightLegT, 2));   // this leg will be animated when running CritterParty

        comp124graphics.Rectangle middleLegT = new comp124graphics.Rectangle( -5, -60, 5, 40);
        middleLegT.setStrokeColor(strokeColor);
        middleLegT.setFilled(true);
        middleLegT.setFillColor(fillColor);
        addLeg(new Leg(middleLegT, 3));

        //right side legs
        comp124graphics.Rectangle leftLegR  = new comp124graphics.Rectangle(16, 0, 40, 5);
        leftLegR.setStrokeColor(strokeColor);
        leftLegR.setFilled(true);
        leftLegR.setFillColor(fillColor);
        addLeg(new Leg(leftLegR, 2));   // this leg will be animated when running CritterParty

        comp124graphics.Rectangle rightLegR = new comp124graphics.Rectangle( 16, -11, 40, 5);
        rightLegR.setStrokeColor(strokeColor);
        rightLegR.setFilled(true);
        rightLegR.setFillColor(fillColor);
        addLeg(new Leg(rightLegR, 3));   // this leg will be animated when running CritterParty

        comp124graphics.Rectangle middleLegR = new comp124graphics.Rectangle( 16, -22, 40, 5);
        middleLegR.setStrokeColor(strokeColor);
        middleLegR.setFilled(true);
        middleLegR.setFillColor(fillColor);
        addLeg(new Leg(middleLegR, 1));

        //left side legs
        comp124graphics.Rectangle leftLegL  = new comp124graphics.Rectangle(-54, 0, 40, 5);
        leftLegL.setStrokeColor(strokeColor);
        leftLegL.setFilled(true);
        leftLegL.setFillColor(fillColor);
        addLeg(new Leg(leftLegL, 3));   // this leg will be animated when running CritterParty

        comp124graphics.Rectangle rightLegL = new comp124graphics.Rectangle( -54, -11, 40, 5);
        rightLegL.setStrokeColor(strokeColor);
        rightLegL.setFilled(true);
        rightLegL.setFillColor(fillColor);
        addLeg(new Leg(rightLegL, 2));   // this leg will be animated when running CritterParty

        comp124graphics.Rectangle middleLegL = new comp124graphics.Rectangle( -54, -22, 40, 5);
        middleLegL.setStrokeColor(strokeColor);
        middleLegL.setFilled(true);
        middleLegL.setFillColor(fillColor);
        addLeg(new Leg(middleLegL, 1));

        comp124graphics.Rectangle body = new comp124graphics.Rectangle(-20, -30, 40, 40);
        body.setStrokeColor(strokeColor);
        body.setFilled(true);
        body.setFillColor(fillColor);
        getGraphics().add(body);

//        comp124graphics.Rectangle head = new comp124graphics.Rectangle(-18, -20, 36, 20);
//        head.setStrokeColor(strokeColor);
//        head.setFilled(true);
//        head.setFillColor(fillColor);
//        getGraphics().add(head);

        //Eye leftEye = new Eye(20, 0.26, 0.18, Color.RED);
        Eye rightEye = new Eye(20, 0.26, 0.18, Color.RED);
        //addEye(leftEye, -10, -10);
        addEye(rightEye, 0, -10);
    }

}
