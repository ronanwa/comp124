package comp124.weatherWrapper;

import comp124graphics.CanvasWindow;
import comp124graphics.GraphicsObject;
import comp124graphics.GraphicsText;

import java.awt.*;

public class WindWidget extends WeatherWidget{
    public WindWidget(OpenWeatherConnection connection) {
        super(connection);
        draw();
    }

    protected void draw(){
        // Adds current wind direction
        GraphicsObject northIndicator = new GraphicsText("N", 383, 160);
        Font f0 = new Font("SanSerif", Font.PLAIN, 40);
        ((GraphicsText) northIndicator).setFont(f0);
        add(northIndicator);

        // Adds current wind direction
        String currentWindDirection = "Wind Direction: "+getCurrentWindDirection();
        GraphicsObject windDirectionDisplay = new GraphicsText(currentWindDirection, 265, 450);
        Font f1 = new Font("SanSerif", Font.PLAIN, 40);
        ((GraphicsText) windDirectionDisplay).setFont(f1);
        add(windDirectionDisplay);

        // Adds current wind speed
        String currentWindSpeed = String.format("%.1f", getCurrentWindSpeed());
        GraphicsObject windSpeedDisplay = new GraphicsText(currentWindSpeed, 350, 300);
        Font f2 = new Font("SanSerif", Font.BOLD, 70);
        ((GraphicsText) windSpeedDisplay).setFont(f2);
        add(windSpeedDisplay);
    }

    public static void main(String[] args) {
        OpenWeatherConnection conn = new OpenWeatherConnection(WeatherProgram.API_KEY, 44.9, -93.0);
        // saint paul

        CanvasWindow cw = new CanvasWindow("Wind Widget", 800, 600);
        cw.setBackground(new Color(123, 218, 255));
        WindWidget ww = new WindWidget(conn);
        cw.add(ww);
    }
}
