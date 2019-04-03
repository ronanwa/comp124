package comp124.weatherWrapper;

import comp124graphics.CanvasWindow;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class WeatherProgram extends CanvasWindow {

    public static final String API_KEY = "ce6188508c5a09dd00252b0d1fd3cd0e";

    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 800;

    // of which index in the array is the widget that is currently displayed.
    public WeatherWidget[] widgetArray;
    public int index = 0;

    public WeatherProgram(){
        super("Weather Display", WINDOW_WIDTH, WINDOW_HEIGHT);

        OpenWeatherConnection conn = new OpenWeatherConnection(API_KEY, 44.9, -93.0);// saint paul

        widgetArray = new WeatherWidget[3];
        widgetArray[0] = new WindWidget(conn);
        widgetArray[1] = new TemperatureWidget(conn);
        widgetArray[2] = new ForecastWidget(conn);
        add(widgetArray[0], 150, 150);
        setBackground(new Color(153, 204, 255));

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                removeAll();
                if (index < widgetArray.length - 1)
                    index++;
                else
                    index = 0;
                add(widgetArray[index]);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                if(index==2){
                    ForecastWidget fw = (ForecastWidget)widgetArray[2];
                    fw.updateSelection(e.getX(), e.getY());
                }
            }
        });
    }


    public static void main(String[] args){
        WeatherProgram prog = new WeatherProgram();
    }
}
