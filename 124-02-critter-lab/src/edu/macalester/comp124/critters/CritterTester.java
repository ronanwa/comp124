package edu.macalester.comp124.critters;

import java.awt.Color;
import java.awt.geom.Point2D;

import comp124graphics.CanvasWindow;
import comp124graphics.GraphicsGroup;
import comp124graphics.Rectangle;


/**
 * Created by shoop on 2/22/16.
 */
public class CritterTester extends CanvasWindow {

    private Critter testCritter;

    public CritterTester() {
        super("Critter Test", 260, 260);

        Rectangle targetBounds = new Rectangle(40, 40, 100, 100);
        targetBounds.setStrokeColor(new Color(0, 0, 0, 0.1f));
        targetBounds.setStrokeWidth(3);
        add(targetBounds);

        testCritter = new BoxBot();
//        testCritter = new RoundBug();  // try these too
//        testCritter = new Mario();

        showCritter();
        run();
    }

    private void showCritter() {
        GraphicsGroup graphics = testCritter.getGraphics();
        graphics.setPosition(40.0 + testCritter.getxOffset(), 40.0 + testCritter.getyOffset());
        add(graphics);
    }

    @SuppressWarnings("InfiniteLoopStatement")
    public void run() {
        testCritter.setSpeed(10);
        Point2D.Double center = testCritter.getGraphics().getPosition();
        double t = 0;
        while(true) {
            testCritter.setGoal(new Point2D.Double(
                center.x + Math.cos(t) * 5 + 5,
                center.y + Math.sin(t) * 5 + 5));
            testCritter.moveTowardsGoal(0.05);

            pause(50);
            t = (t + 0.1) % (Math.PI*2);
        }
    }

    public static void main(String[] args){
        CritterTester test = new CritterTester();
    }
}