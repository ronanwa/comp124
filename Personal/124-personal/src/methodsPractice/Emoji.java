package methodsPractice;

import comp124graphics.Arc;
import comp124graphics.CanvasWindow;
import comp124graphics.Ellipse;
import comp124graphics.GraphicsText;
import comp124graphics.Rectangle;

import java.awt.*;

public class Emoji {

    public static void main(String[] args){

        CanvasWindow canvas = new CanvasWindow("Emoji", 400, 400);

        Rectangle background=new Rectangle(0,0,400,400);
        background.setFillColor(new Color(163,255, 235));
        background.setFilled(true);
        canvas.add(background);

        Ellipse face=new Ellipse(76,40,200,200);
        face.setFillColor(new Color(200,200,0));
        face.setFilled(true);
        canvas.add(face);

        Arc mouth = new Arc(150.0, 150.0, 50, 50, 200.0, 140.0);
        mouth.setStrokeColor(new Color(255, 102, 102));
        mouth.setStrokeWidth(4);
        canvas.add(mouth);

        Ellipse eyeL=new Ellipse(100,75,50,90);
        eyeL.setFillColor(new Color(100,0,255));
        eyeL.setFilled(true);
        canvas.add(eyeL);

        Ellipse eyeR=new Ellipse(200,75,50,90);
        eyeR.setFillColor(new Color(100,0,255));
        eyeR.setFilled(true);
        canvas.add(eyeR);

        Ellipse pupilL=new Ellipse(105,85,25,25);
        pupilL.setFillColor(new Color(196, 196,255));
        pupilL.setFilled(true);
        canvas.add(pupilL);

        Ellipse pupilR=new Ellipse(220,130,25,25);
        pupilR.setFillColor(new Color(196, 196,255));
        pupilR.setFilled(true);
        canvas.add(pupilR);

        GraphicsText gText=new GraphicsText("ymmud",160,70);
        canvas.add(gText);
    }
}
