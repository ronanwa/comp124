package edu.macalester.comp124.critters;

import java.awt.Color;
import comp124graphics.*;

public class Critter_EFugi extends Critter {

    @Override
    protected void buildGraphics(){

        xOffset = 0.0;
        yOffset = 0.0;

        Line leg1 = new Line(30,5,30,15);
        leg1.setStrokeColor(new Color(100,0,200));
        addLeg(new Leg(leg1, 2.0));

        Line leg2 = new Line(30,45,30,55);
        leg2.setStrokeColor(new Color(100,0,200));
        addLeg(new Leg(leg2, 2.0));

        Line leg3 = new Line(5,30,15,30);
        leg3.setStrokeColor(new Color(100,0,200));
        addLeg(new Leg(leg3, 2.0));

        Line leg4 = new Line(45,30,55,30);
        leg1.setStrokeColor(new Color(100,0,200));
        addLeg(new Leg(leg4, 2.0));

        Rectangle body = new Rectangle(15, 15, 30, 30);
        body.setStrokeColor(new Color(200,0 ,250));
        body.setFillColor(new Color (255,0 ,200));
        body.setFilled(true);
        getGraphics().add(body);

        Eye eye = new Eye(5, 0.5, 0.25, new Color(0,200, 100));
        addEye(eye, 30, 30);


    }

}
