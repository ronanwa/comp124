package comp124.weatherWrapper;

import comp124graphics.CanvasWindow;
import comp124graphics.GraphicsObject;
import comp124graphics.GraphicsText;

import java.awt.*;

public class TemperatureWidget extends WeatherWidget {

    public TemperatureWidget (OpenWeatherConnection connection) {
        super(connection);
        draw();
    }

    protected void draw(){
        // Adds weather conditions
        String currentWeather = getCurrentWeather()+"";
        GraphicsObject weatherDisplay = new GraphicsText(currentWeather, 240, 500);
        Font f0 = new Font("SanSerif", Font.PLAIN, 70);
        ((GraphicsText) weatherDisplay).setFont(f0);
        add(weatherDisplay);

        // Adds temperature in degrees
        String temp = String.format("%.1f", getCurrentTemperature())+"\u2109";
        GraphicsObject temperatureDisplay = new GraphicsText(temp, 290, 400);
        Font f1 = new Font("SanSerif", Font.BOLD, 80);
        ((GraphicsText) temperatureDisplay).setFont(f1);
        add(temperatureDisplay);

        // Adds weather icon
        GraphicsObject icon = getWeatherIcon();
        icon.setPosition(240, 60);
        add(icon);
    }

    public static void main(String[] args) {
        OpenWeatherConnection conn = new OpenWeatherConnection(WeatherProgram.API_KEY, 44.9, -93.0);
        // saint paul

        CanvasWindow cw = new CanvasWindow("Temperature Widget", 800, 600);
        cw.setBackground(new Color(123, 218, 255));
        TemperatureWidget tw = new TemperatureWidget(conn);
        cw.add(tw);
        System.out.println(tw.getCurrentTemperature());

    }
}
