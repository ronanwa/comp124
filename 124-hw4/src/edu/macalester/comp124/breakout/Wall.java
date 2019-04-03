package edu.macalester.comp124.breakout;

import comp124graphics.Rectangle;
import java.awt.*;

public class Wall extends Rectangle{

    public Wall(double x, double y, double width, double height) {
        super(x,y,width,height);
        setFillColor(Color.RED);
        setFilled(true);
    }
}
