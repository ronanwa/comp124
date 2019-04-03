package methodsPractice;

import comp124graphics.Arc;
import comp124graphics.CanvasWindow;
import comp124graphics.Ellipse;

import java.awt.*;

public class EmojiBuilder {

    private CanvasWindow canvas;

    public static void main(String[] args){
        EmojiBuilder builder = new EmojiBuilder();

        builder.buildBasicSmiley(0, 0);
        builder.buildBasicSmiley(200,200);
        builder.buildBasicSmiley(400,400);
    }

    /**
     * Constructor method used to initialize the instance variable
     */
    public EmojiBuilder(){
        canvas = new CanvasWindow("Emoji Builder", 1000, 800);
    }

    /**
     * Creates a basic smiley face
     * @param x position of the upper left corner
     * @param y position of the upper left corner
     */
    public void buildBasicSmiley(int x, int y){
        //The keyword "this" refers to the object that is receiving the buildBasicSmiley message.
        //
        this.buildFace(x,y,200,200);
        this.buildEyes(x,y,50,90,25,25);
        this.buildBasicMouth(x,y, 50, 50);
        this.buildWink(x,y,50,50);
    }

    private void buildWink(int x, int y, int width, int height){
        Arc mouth = new Arc(x+50, y+50, width, height, 200.0, 140.0);
        mouth.setStrokeColor(new Color(36, 128, 255));
        mouth.setStrokeWidth(4);
        canvas.add(mouth);
        }


    private void buildEyes(int x, int y, int width, int height, int pWidth, int pHeight){
        Ellipse eyeL=new Ellipse(x+100,y+75,width,height);
        eyeL.setFillColor(new Color(100,0,255));
        eyeL.setFilled(true);
        canvas.add(eyeL);
        Ellipse eyeR=new Ellipse(x+200,x+75,width,height);
        eyeR.setFillColor(new Color(100,0,255));
        eyeR.setFilled(true);
        canvas.add(eyeR);
        Ellipse pupilL=new Ellipse(x+105,y+85,pWidth,pHeight);
        pupilL.setFillColor(new Color(196, 196,255));
        pupilL.setFilled(true);
        canvas.add(pupilL);
        Ellipse pupilR=new Ellipse(x+220,y+130,pWidth,pHeight);
        pupilR.setFillColor(new Color(196, 196,255));
        pupilR.setFilled(true);
        canvas.add(pupilR);
    }

    private void buildFace(int x, int y, int width, int height){
        Ellipse face=new Ellipse(x+76,y+40,width,height);
        face.setFillColor(new Color(200,200,0));
        face.setFilled(true);
        canvas.add(face);

    }

    /**
     * Draws a simple arc as a smiley mouth
     * @param x position of the arc
     * @param y position of the arc
     * @param width of the ellipse that the arc is a part of
     * @param height of the ellipse that the arc is a part of
     */



    private void buildBasicMouth(int x, int y, int width, int height){
        Arc mouth = new Arc(x+150, y+150, width, height, 200.0, 140.0);
        mouth.setStrokeColor(new Color(255, 102, 102));
        mouth.setStrokeWidth(4);
        canvas.add(mouth);
    }
}
