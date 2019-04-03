package edu.macalester.comp124.critters;

import comp124graphics.*;
import comp124graphics.Rectangle;

import java.awt.*;

public class Khalid extends Critter {
    private static final Color FACE_COLOR = new Color(250, 220, 47);
    private static final Color LEG_COLOR = new Color(250, 220, 47);
    private static final Color MOUTH_COLOR = new Color(0, 0, 0);
    private static final Color COLOR_WHITE = new Color(255, 255, 255);
    private static final Color COLOR = new Color(255, 0, 0);


    @Override
    protected void buildGraphics() {

        generateFace();

        generateBody();

        generateLegs();
    }

    private void generateLegs() {
        Rectangle leg1  = new Rectangle(35, 120, 10, 40);
        leg1.setFilled(true);
        leg1.setFillColor(LEG_COLOR);
        addLeg(new Leg(leg1, 3));

        Rectangle leg2 = new Rectangle( 60, 120, 10, 40);
        leg2.setFilled(true);
        leg2.setFillColor(LEG_COLOR);
        addLeg(new Leg(leg2, 3));
    }

    private void generateBody() {
        Rectangle body = new Rectangle(25, 60, 60, 60);
        body.setFilled(true);
        body.setFillColor(COLOR);
        getGraphics().add(body);


        Rectangle hand1 = new Rectangle(-5, 65, 30, 10);
        hand1.setFilled(true);
        hand1.setFillColor(MOUTH_COLOR);
        getGraphics().add(hand1);


        Rectangle hand2 = new Rectangle(85, 65, 30, 10);
        hand2.setFilled(true);
        hand2.setFillColor(MOUTH_COLOR);
        getGraphics().add(hand2);
    }

    private void generateFace() {
        Ellipse face = new Ellipse(25, 5, 60, 60);
        face.setFilled(true);
        face.setFillColor(FACE_COLOR);
        getGraphics().add(face);

        Line line = new Line(40, 42,65,42);
        line.setStrokeColor(MOUTH_COLOR);
        line.setStrokeWidth(2);
        getGraphics().add(line);

        Ellipse eye1 = new Ellipse(40, 20, 7, 12);
        eye1.setFilled(true);
        eye1.setFillColor(MOUTH_COLOR);
        getGraphics().add(eye1);

        Ellipse eye2= new Ellipse(64, 20, 7, 12);
        eye2.setFillColor(MOUTH_COLOR);
        eye2.setFilled(true);
        getGraphics().add(eye2);

        Ellipse eye3 = new Ellipse(42, 25, 5, 6);
        eye3.setFilled(true);
        eye3.setFillColor(COLOR_WHITE);
        getGraphics().add(eye3);

        Ellipse eye4= new Ellipse(66, 25, 5, 6);
        eye4.setFillColor(COLOR_WHITE);
        eye4.setFilled(true);
        getGraphics().add(eye4);
    }

}
