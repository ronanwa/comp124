package edu.macalester.comp124.breakout;

import comp124graphics.Rectangle;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;
import java.awt.*;

public class Paddle extends Rectangle implements MouseMotionListener {

    public Paddle (double x, double y, double width, double height){
        super(x,y,width,height);
        setFillColor(new Color(0x00FEFF));
        setFilled(true);
    }

    @Override
    public void mouseDragged(MouseEvent e){

    }

    @Override
    public void mouseMoved(MouseEvent e){
        setPosition(e.getX()-(this.getWidth()/2), getY());
    }
}
