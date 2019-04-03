package edu.macalester.comp124.critters;

import comp124graphics.Ellipse;
import comp124graphics.GraphicsGroup;
import comp124graphics.Line;
import comp124graphics.Rectangle;

import java.awt.*;

public class Zazu_Critters extends Critter {
    private static final Color
            strokeColor = new Color(40, 40, 60),
            backlegColor = new Color(108, 74, 4),
            frontlegColor = new Color(168, 113, 7),
            bodyColor   = new Color(223, 148, 21),
            neckColor = new Color (132, 108, 10),
            headColor = new Color(223, 178, 15);

    @Override
    protected void buildGraphics() {
        xOffset = 20.0;
        yOffset = 56.0;


        comp124graphics.Rectangle backleftLeg  = new comp124graphics.Rectangle(-10, 0, 5, 10);
        backleftLeg.setStrokeColor(strokeColor);
        backleftLeg.setFilled(true);
        backleftLeg.setFillColor(backlegColor);
        addLeg(new Leg(backleftLeg, 2));   // this leg will be animated when running CritterParty

        comp124graphics.Rectangle backrightLeg = new comp124graphics.Rectangle( 0, 0, 5, 10);
        backrightLeg.setStrokeColor(strokeColor);
        backrightLeg.setFilled(true);
        backrightLeg.setFillColor(backlegColor);
        addLeg(new Leg(backrightLeg, 4));   // this leg will be animated when running CritterParty


        comp124graphics.Rectangle body = new comp124graphics.Rectangle(-12, -8, 25, 15);
        body.setStrokeColor(strokeColor);
        body.setFilled(true);
        body.setFillColor(bodyColor);
        getGraphics().add(body);

        comp124graphics.Rectangle neck = new comp124graphics.Rectangle(-3, -20, 5, 10);
        neck.setStrokeColor(strokeColor);
        neck.setFilled(true);
        neck.setFillColor(neckColor);
        getGraphics().add(neck);


        comp124graphics.Rectangle frontleftLeg  = new comp124graphics.Rectangle(-13, 0, 5, 15);
        frontleftLeg.setStrokeColor(strokeColor);
        frontleftLeg.setFilled(true);
        frontleftLeg.setFillColor(frontlegColor);
        addLeg(new Leg(frontleftLeg, 4));   // this leg will be animated when running CritterParty

        comp124graphics.Rectangle frontrightLeg = new comp124graphics.Rectangle( 5, 0, 5, 15);
        frontrightLeg.setStrokeColor(strokeColor);
        frontrightLeg.setFilled(true);
        frontrightLeg.setFillColor(frontlegColor);
        addLeg(new Leg(frontrightLeg, 2));   // this leg will be animated when running CritterParty


        Ellipse head = new Ellipse(-18, -25, 36, 20);
        head.setStrokeColor(strokeColor);
        head.setFilled(true);
        head.setFillColor(headColor);
        getGraphics().add(head);

        Eye leftEye = new Eye(6, 0.26, 0.18, Color.GREEN);
        Eye rightEye = new Eye(6, 0.26, 0.18, Color.GREEN);
        addEye(leftEye, -10, -26);
        addEye(rightEye, 10, -26);
    }



}
