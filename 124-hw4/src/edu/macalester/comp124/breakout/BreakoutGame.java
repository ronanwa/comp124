package edu.macalester.comp124.breakout;

import comp124graphics.CanvasWindow;
import comp124graphics.GraphicsObject;
import comp124graphics.GraphicsText;
import java.awt.*;
import java.sql.Array;

/**
 * Main program for the breakout game.
 *
 */
public class BreakoutGame extends CanvasWindow {

    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 1000;

    private Array[] wall = new Array[32];
    private double dy=-5;
    private double dx=-5;
    private int bricksRemaining=32;
    private int lives=5;
    private static final double RADIUS=10;
    private static final int INIT_Y=750;
    private static final int INIT_X=400;

    public BreakoutGame() {
        super("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);
        add(new Wall(0,0,8,1000));
        add(new Wall(794,0,8,1000));
        add(new Wall(0,0,800,8));
        Paddle paddle = new Paddle(350,790,150,13);
        add(paddle);
        addMouseMotionListener(paddle);
        createBrickWall();
        Ball ball = new Ball(INIT_X,INIT_Y);
        add(ball);
        run(ball);

    }

    public void run(Ball ball){
        for (int i=0; i<5; i++){
            runTurn(ball);
            if (bricksRemaining==0) {
                printYouWin();
            } else if (bricksRemaining>0 && lives>0){
                printLives();
            } else if (lives==0 && bricksRemaining>0){
                printGameOver();
            }
        }
    }

    private void runTurn(Ball ball){
        ball.setPosition(INIT_X,INIT_Y);
        dx=-5;
        dy=-5;
        ball.move(dx,dy);
        moveBall(ball);
    }

    private void createBrickWall(){
        int x=16;
        int y=100;
        Color color = Color.BLUE;
        for (int i=0; i<wall.length; i++){
            add(new Brick(x,y,90,20,color));
            x+=96;
            if(x>780 && y==100) {
                y+=25;
                x=16;
                color=Color.GREEN;
            } else if(x>780 && y==125){
                y+=25;
                x=16;
                color=Color.YELLOW;
            } else if(x>780 && y==150){
                y+=25;
                x=16;
                color=Color.PINK;
            }
        }
    }

    private void moveBall(Ball ball){
        while (ball.getY()<806){
            ball.move(dx,dy);
            checkIntersection(ball);
            pause(5);
            if (bricksRemaining==0){
                return;
            }
        }
        lives--;
    }

    private void checkIntersection(Ball ball){
        double x=ball.getX();
        double y=ball.getY();
        double constant=8;
        GraphicsObject top=getElementAt((x+RADIUS)+constant,y+constant);
        GraphicsObject right=getElementAt(x+RADIUS*2+constant,y+RADIUS+constant);
        GraphicsObject left=getElementAt(x+constant,y+RADIUS+constant);
        GraphicsObject bottom=getElementAt(x+RADIUS+constant,y+RADIUS*2+constant);

        if(top!=null) {
            dy=-dy;
            if (top instanceof Brick) {
                remove(top);
                bricksRemaining--;
            }
        } else if (right!=null){
            dx=-dx;
            if(right instanceof Brick){
                remove(right);
                bricksRemaining--;
            }
        } else if(left!=null){
            dx=-dx;
            if(left instanceof Brick){
                remove(left);
                bricksRemaining--;
            }
        } else if (bottom!=null){
            dy=-dy;
            if(bottom instanceof Brick){
                remove(bottom);
                bricksRemaining--;
            }
        }
    }

    private void printLives(){
        GraphicsText livesText;
        if(lives>1){
            livesText = new GraphicsText(lives+" Lives Left",325,500);
        } else {
            livesText = new GraphicsText(lives+" Life Left",325,500);
        }
        livesText.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        add(livesText);
        pause(3000);
        remove(livesText);
    }

    private void printGameOver(){
        GraphicsText gameOver= new GraphicsText("Game over", 300, 500);
        gameOver.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        add(gameOver);
    }

    private void printYouWin(){
        GraphicsText youWin=new GraphicsText("You Win!",250,500);
        youWin.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        youWin.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        add(youWin);
    }

    public static void main(String[] args){
        BreakoutGame prog = new BreakoutGame();
    }
}
