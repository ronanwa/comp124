package edu.macalester.comp124.critters;


import comp124graphics.Arc;
import comp124graphics.Line;
import comp124graphics.Ellipse;

import java.awt.*;


public class ASbug extends Critter{

    protected void buildGraphics(){
        //body
            //half-circle, rectangle, waves at bottom
        //eyes
        //mouth
        //x0, y0 = topLeft head rectangle point
        //x1, y1 = Left head to body point
        //x2, y2 =  Left bottom of rect
        int x0 = 0;
        int y0 = 0;
        int y1 = y0 + 17;
        int y2 = y0 + 50;
        int width = 37;

        Arc head = new Arc(x0, y0, width, width, 0, 180);
        head.setStrokeWidth(2);
        getGraphics().add(head);

        Line leftBody = new Line(x0, y1, x0, y2);
        leftBody.setStrokeWidth(2);
        getGraphics().add(leftBody);

        Line rBody = new Line(x0 + width, y2, x0 + width, y1);
        rBody.setStrokeWidth(2);
        getGraphics().add(rBody);

        Eye lEye = new Eye(6, .5, .25, Color.blue);
        Eye rEye = new Eye(6, .5, .25, Color.blue);
        addEye(lEye, x0 + 10, y0 + 15);
        addEye(rEye, x0 + 28, y0 + 15);

        Ellipse mouth = new Ellipse(x0 + 17, y0+25, 4, 4);
        mouth.setStrokeWidth(2);
        getGraphics().add(mouth);


        Arc b1 = new Arc(x0, y2-5, 12, 12, 180, 150);
        Arc b2 = new Arc(x0 + 12, y2-5, 12, 12, 200, 130);
        Arc b3 = new Arc(x0+24, y2-5, 12, 12, 200, 150);
        b1.setStrokeWidth(2);
        b2.setStrokeWidth(2);
        b3.setStrokeWidth(2);
        getGraphics().add(b1);
        getGraphics().add(b2);
        getGraphics().add(b3);

    }
}
