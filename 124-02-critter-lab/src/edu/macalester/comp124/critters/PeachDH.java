package edu.macalester.comp124.critters;

import comp124graphics.*;
import comp124graphics.Rectangle;

import java.awt.Color;

public class PeachDH extends Critter{
    private static final Color strokeColor = new Color(255, 160, 190);
    private static final Color fillColor = strokeColor;

    @ Override // ask someone to explain this
    protected void buildGraphics(){
        Rectangle leftLeg  = new Rectangle(30, 90, 10, 20);
        leftLeg.setStrokeColor(strokeColor);
        leftLeg.setFilled(true);
        leftLeg.setFillColor(fillColor);
        addLeg(new Leg(leftLeg, 4));

        Rectangle rightLeg  = new Rectangle(40, 90, 10, 20);
        rightLeg.setStrokeColor(strokeColor);
        rightLeg.setFilled(true);
        rightLeg.setFillColor(fillColor);
        addLeg(new Leg(rightLeg, 4));

        Image peach = CritterUtils.loadCritterImage("peach.png");
        getGraphics().add(peach);
    }
}
