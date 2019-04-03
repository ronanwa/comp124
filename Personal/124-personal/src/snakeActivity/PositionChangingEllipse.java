package snakeActivity;

import comp124graphics.Ellipse;

import java.awt.*;
import java.util.Random;

public class PositionChangingEllipse extends Ellipse implements TrickyShapes {

    public PositionChangingEllipse(double x, double y, double width, double height){
        super(x, y, width, height);
    }

    public void doTrick(){
        Random random = new Random();
        double newX = random.nextDouble()*800;
        double newY = random.nextDouble()*600;
        this.setPosition(newX, newY);
    }

}
