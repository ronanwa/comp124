package edu.macalester.comp124.hw2;

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

import comp124graphics.CanvasWindow;
import comp124graphics.Line;
import comp124graphics.Rectangle;

import javax.swing.*;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

/**
 * The main game class to run the game popping bubbles.
 */
public class BubbleBlitz extends CanvasWindow {

    private Random random;
    private Cannon cannon;
    private BubbleManager bubbleManager;
    private String angle;
    private String initVelocity;

    public static final int WINDOW_PADDING = 30;
    public static final Color SKY_COLOR = new Color(188, 217, 255);
    public static final Color GROUND_COLOR = new Color(122, 181, 107);
    public static final double SPEED = 100;


    public static void main(String[] args) {
        BubbleBlitz game = new BubbleBlitz();
        game.run();


    }

    public BubbleBlitz() {
        super("BubbleBlitz", 800, 600);
        random = new Random();
        bubbleManager = new BubbleManager(this);
    }

    public void run() {
        resetGame();
    }

    /**
     * Resets the canvas by removing everything and redrawing new bubbles and a new random placement for the cannon.
     */
    public void resetGame() {
        bubbleManager.removeAllBubbles();
        removeAll();
        createBackground();
        bubbleManager.generateBubbles();
        createCannon(random.nextDouble() * (getWidth() - WINDOW_PADDING) + WINDOW_PADDING, getHeight() - WINDOW_PADDING, 90);
        newRound();
    }

    // Starts a new round
    public void newRound() {
        while (checkBubbles()) {
            loadCannon();
        }
        JOptionPane.showMessageDialog(null, "You won!");
        int again = JOptionPane.showConfirmDialog(null, "Play again?");
        if (again == JOptionPane.YES_OPTION){
            run();
        }
    }

    // Check if there are bubbles left to pop
    public boolean checkBubbles(){
        if (bubbleManager.getNumberOfBubbles()>0){
            return true;
        }
        return false;
    }

    // Loads the cannon
    public void loadCannon(){
        angle = JOptionPane.showInputDialog("Enter an angle: ");
        int angleInt = Integer.parseInt(angle);
        cannon.updateCannon(angleInt);
        initVelocity = JOptionPane.showInputDialog("Enter an initial velocity: ");
        int initVelocityInt = Integer.parseInt(initVelocity);

        double ballInitialCenterX = cannon.getX2();
        double ballInitialCenterY = cannon.getY2();

        CannonBall newCannonBall = new CannonBall(ballInitialCenterX, ballInitialCenterY, initVelocityInt, angleInt, 800, 600);
        add(newCannonBall);
        fireCannon(newCannonBall);
    }

    // Fires cannon balls
    public void fireCannon(CannonBall newCannonBall){
        boolean ballIsInMotion = true;
        while (ballIsInMotion) {
            double oldX = newCannonBall.getCenterX();
            double oldY = newCannonBall.getCenterY();
            ballIsInMotion = newCannonBall.updatePosition(0.1);
            popBubble(newCannonBall);
            Line tracer = new Line(oldX, oldY, newCannonBall.getCenterX(), newCannonBall.getCenterY());
            tracer.setStrokeColor(Color.BLACK);
            add(tracer);
            pause(10);
        }
        remove(newCannonBall);
    }

    // Pops the bubbles that come in contact with the cannon ball
    public void popBubble(CannonBall newCannonBall){
        bubbleManager.testHit(newCannonBall);
    }

    /**
     * Creates a cannon.
     * @param centerX The anchor position of the cannon
     * @param centerY The anchor position of the cannon
     * @param angleDegrees The direction of the cannon
     */
    private void createCannon(double centerX, double centerY, double angleDegrees) {
        cannon = new Cannon(centerX, centerY, angleDegrees);
        add(cannon);
    }


    /**
     * Creates the sky and ground background
     */
    private void createBackground() {
        Rectangle sky = new Rectangle(0, 0, getWidth(), getHeight());
        sky.setFillColor(SKY_COLOR);
        sky.setFilled(true);
        add(sky);

        Rectangle ground = new Rectangle(0, getHeight()- WINDOW_PADDING, getWidth(), WINDOW_PADDING);
        ground.setFilled(true);
        ground.setFillColor(GROUND_COLOR);
        ground.setStroked(false);
        add(ground);
    }

}
