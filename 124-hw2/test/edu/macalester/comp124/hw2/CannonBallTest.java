package edu.macalester.comp124.hw2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CannonBallTest {

    @Test
    public void testBasicUpdatePosition() {
        CannonBall ball = new CannonBall(100, 100, 100, 45, 1100, 600);

        ball.updatePosition(0.1);
        assertEquals(107.071, ball.getCenterX(), 0.001);
        assertEquals(92.9289, ball.getCenterY(), 0.001);

        ball.updatePosition(0.1);
        assertEquals(114.142, ball.getCenterX(), 0.001);
        assertEquals(85.9558, ball.getCenterY(), 0.001);

        ball.updatePosition(0.1);
        assertEquals(121.213, ball.getCenterX(), 0.001);
        assertEquals(79.0807, ball.getCenterY(), 0.001);


        // Added Test Methods
        ball.updatePosition(0.9);
        assertEquals(184.8528, ball.getCenterX(), 0.001);
        assertEquals(18.0871, ball.getCenterY(), 0.001);

        // Returns false, centerY is outside of the Y boundary
        ball.updatePosition(0.1);
        assertEquals(191.9238, ball.getCenterX(), 0.001);
        assertEquals(12.1921, ball.getCenterY(), 0.001);

        ball.updatePosition(0.3);
        assertEquals(191.9238, ball.getCenterX(), 0.001);
        assertEquals(12.1921, ball.getCenterY(), 0.001);

    }

    //TODO: Add more test methods --- DONE
}
