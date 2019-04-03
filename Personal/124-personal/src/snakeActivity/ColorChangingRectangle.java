package snakeActivity;

import comp124graphics.Rectangle;

import java.awt.*;
import java.util.Random;


public class ColorChangingRectangle extends Rectangle implements TrickyShapes {

    public ColorChangingRectangle(double x, double y, double width, double height){
        super(x, y, width, height);
    }
    public void doTrick(){
        Random random = new Random();
        Color color = new Color(random.nextFloat(), random.nextFloat(),random.nextFloat());
        this.setFillColor(color);
        this.setFilled(true);
    }

}
