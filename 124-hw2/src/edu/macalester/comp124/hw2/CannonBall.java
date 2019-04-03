package edu.macalester.comp124.hw2;

import comp124graphics.Ellipse;

/**
 * Represents a cannon ball that follows a parabolic arc based on physics equations.
 */
public class CannonBall extends Ellipse {
    public static final double GRAVITY = -9.8;
    public static final double BALL_RADIUS = 2.5;
    public static double initialXVelocity;
    public static double initialYVelocity;
    public double centerX;
    public double centerY;
    public double maxXBound;
    public double maxYBound;
    public double currYVelocity;
    public double currXVelocity;


    //TODO: Add instance variables. Remember that instance variables may or may not have corresponding constructor parameters. --- DONE

    public CannonBall(double centerX, double centerY, double initialSpeed, double initialAngle, double maxX, double maxY) {
        super(centerX,centerY,(2*BALL_RADIUS),(2*BALL_RADIUS));
        this.centerX=centerX;
        this.centerY=centerY;


        // To compute the initial velocity:
        double initialAngleInRadians = Math.toRadians(initialAngle);
        initialXVelocity = initialSpeed * Math.cos(initialAngleInRadians);
        initialYVelocity = initialSpeed * -Math.sin(initialAngleInRadians);
        // (You'll need to figure out how to use those values.)
        currYVelocity = initialYVelocity;
        currXVelocity = initialXVelocity;

        maxXBound=maxX;
        maxYBound=maxY;
    }

    /**
     * Update the cannon ball's position if it is in bounds
     * @return true if the ball is in within the maxXBound and maxYBound
     */
    public boolean updatePosition(double dt) {
        //TODO: fix me --- DONE
        double newXPosition=centerX+(currXVelocity*dt);
        double newYPosition=centerY+(currYVelocity*dt);
        if (0<newXPosition && newXPosition<maxXBound && 0<newYPosition && newYPosition<maxYBound) {
            this.centerX = newXPosition;
            this.centerY = newYPosition;
            this.currYVelocity = currYVelocity-(GRAVITY*dt);
            return true;
        }
        return false;
    }

    public double getCenterX(){
        return centerX;
    }

    public double getCenterY(){
        return centerY;
    }
}
