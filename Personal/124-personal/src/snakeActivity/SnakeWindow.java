package snakeActivity;

import comp124graphics.CanvasWindow;
import comp124graphics.Ellipse;
import comp124graphics.GraphicsObject;
import comp124graphics.Rectangle;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

/**
 * A class for a simple animation of a "snake".
 * The snake will be created by having a series of shapes that follow each other.
 * You will implement the code related to tracking and moving this snake.
 */
public class SnakeWindow extends CanvasWindow implements MouseListener {

    private static final double SEGMENT_SIZE = 50;

    private Random random;

    private GraphicsObject[] snake;

    /**
     * Create a new snake window
     * @param width - the width of the window
     * @param height - the height of the window
     * @param numberOfSegments - the number of segments for snake.
     */
    public SnakeWindow(int width, int height, int numberOfSegments) {
        super("Snake Window", width, height);

        random = new Random();

        snake = new GraphicsObject[numberOfSegments];

        addMouseListener(this);

        generateSnake(numberOfSegments);
    }

    @Override
    public void mouseClicked(MouseEvent e){
        GraphicsObject object = getElementAt(e.getX(), e.getY());
        if (object != null) {
            if (object instanceof TrickyShapes){
                TrickyShapes newShape = (TrickyShapes)object;
                newShape.doTrick();
            }
        }
    }

    public void mouseEntered (MouseEvent e){

    }

    public void mouseExited(MouseEvent e){

    }

    public void mousePressed (MouseEvent e){

    }

    public void mouseReleased(MouseEvent e){

    }

    /**
     * This method should fill in the array storing the graphical objects of the snake
     * (Note: the array should not be created in this method).
     *
     * For now this should just get random shapes, however, once you get everything working
     * Feel free to customize this to, for example, have a specific snake head and tail.
     */
    protected void generateSnake(int numberOfSegments) {
        //TODO: fill the array with shapes from generateRandomShape()
        for (int i=0; i<numberOfSegments; i++){
            snake[i]=getRandomShape();
            add(snake[i]);
        }
        // !Do not forget to add those shapes to the canvas as well as the array!
    }

    /**
     * This method makes the snake animate.
     * Once you finish making the snake work you can override this method to make the
     * snake do more interesting things.
     * Right now it just kinda slithers around in a circle.
     */
    public void run() {
        int i = 0;
        double step = 0.15;
        double degree = 0;
        double r = Math.min(this.getWidth()/2, this.getHeight()/2);
        r = r - SEGMENT_SIZE;

        while(true) {
            // infinite animation loop!
            // increase the angle for the movement
            degree += step;

            // make the radius change as the snake moves
            double thisR = r+Math.sin(8*degree)*SEGMENT_SIZE;

            // compute x and y values
            double x = Math.sin(degree)*thisR - SEGMENT_SIZE/2 + getWidth()/2;
            double y = Math.cos(degree)*thisR - SEGMENT_SIZE/2 + getHeight()/2;

            // move the head of the snake to this position, and have each segment follow.
            snakeMove(x,y);
            pause(100);

        }

    }

    /**
     * Move the snake. The specified position will become the new position of the first segment.
     * The second segment
     */
    protected void snakeMove(double x, double y) {
        // TODO: make this function implement snake movement.
        boolean condition = true;
        GraphicsObject snakeSegment;
        GraphicsObject prevSegment;
        double newX;
        double newY;

        for (int i=snake.length-1; i>0; i--) {
            newX = snake[i - 1].getPosition().getX();
            newY = snake[i - 1].getPosition().getY();
            snake[i].setPosition(newX, newY);
        }

        snake[0].setPosition(x,y);


        // After this method the first segment should be at position x,y
        // each other segment will be in the position the segment ahead of it was last time.
        // NOTE, you will likely need the getPosition method which returns a pair of doubles
        // you can use <something>.getPosition().getX() to get something's x position and
        // <something>.getPosition.getY() to get its y position.
    }

    /**
     * Create and return a random small graphics object.
     * NOTE: this includes some special shapes (subclasses of graphics group) that are from kluver's section.
     *
     * The new shape will always be in the top left corner.
     *
     */
    protected GraphicsObject getRandomShape() {
        int r = random.nextInt(5);
        if (r == 0) {
            ColorChangingRectangle rectangle = new ColorChangingRectangle(0, 0, SEGMENT_SIZE, SEGMENT_SIZE);
            rectangle.setFilled(true);
            rectangle.setFillColor(getRandomColor());
            return rectangle;
        } else { // r == 1
            PositionChangingEllipse ellipse = new PositionChangingEllipse(0, 0, SEGMENT_SIZE, SEGMENT_SIZE);
            ellipse.setFilled(true);
            ellipse.setFillColor(getRandomColor());
            return ellipse;
        }
    }

    protected Color getRandomColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}
