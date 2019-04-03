package edu.macalester.comp124.breakout;

import comp124graphics.Ellipse;

public class Ball extends Ellipse{

    public static final double RADIUS=10;

    public Ball(double x, double y){
        super(x,y,RADIUS,RADIUS);
        setFilled(true);
    }
}
