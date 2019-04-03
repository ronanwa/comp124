package edu.macalester.comp124.breakout;

import comp124graphics.Rectangle;
import java.awt.*;

public class Brick extends Rectangle{

    public Brick(double x, double y, double width, double height, Color color){
        super(x,y,width,height);
        setFillColor(color);
        setFilled(true);
    }
}
