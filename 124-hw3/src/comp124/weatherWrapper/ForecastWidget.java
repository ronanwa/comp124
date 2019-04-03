package comp124.weatherWrapper;

import comp124graphics.GraphicsObject;
import comp124graphics.GraphicsText;
import comp124graphics.Image;
import net.aksingh.owmjapis.HourlyForecast;

import java.awt.*;
import java.text.DecimalFormat;

public class ForecastWidget extends WeatherWidget {


    // This is used to format decimal numbers based on the number of digits you want to display
    // e.g. System.out.println(df.format(4.555555)); will print 4.5;
    private final DecimalFormat df = new DecimalFormat("#0.0");

    ForecastWrapper[] newWrapper = getForecastArray();
    private GraphicsText date;
    private GraphicsText weather;
    private Image icon;
    private GraphicsText temperature;
    private GraphicsText minTemp;
    private GraphicsText maxTemp;

    // Fonts
    Font f0 = new Font("SanSerif", Font.PLAIN, 40);
    Font f1 = new Font("SanSerif", Font.BOLD, 55);
    Font f2 = new Font("SanSerif", Font.BOLD, 55);
    Font f3 = new Font("SanSerif", Font.PLAIN, 40);

    public ForecastWidget(OpenWeatherConnection connection){
        super(connection);
        draw();
    }

    /**
     * creates all forecast boxes
     */
    public void createForecastBoxes(){
        int xValue = 20;
        int yValue = 600;
        for(int i=0; i<newWrapper.length-1; i++){
            add(new ForecastBox(newWrapper[i], xValue, yValue, 20, 40));
            if(xValue > 780) {
                xValue = -10;
                yValue = 660;
            }
            xValue+=30;
        }
    }

    protected void draw(){
        createForecastBoxes();

        // Adds initial weather conditions
        weather = new GraphicsText(newWrapper[0].getPredictedWeather()+"", 250, 500);
        weather.setFont(f0);
        add(weather);

        // Adds initial temperature in degrees
        temperature = new GraphicsText(String.format("%.1f", newWrapper[0].getPredictedTemperature())+"\u2109", 310, 400);
        temperature.setFont(f1);
        add(temperature);

        // Adds weather icon
        icon = getWeatherIcon();
        icon.setPosition(240, 100);
        add(icon);

        // Adds date
        date = new GraphicsText(newWrapper[0].getPredictionTime()+"", 50, 100);
        date.setFont(f2);
        add(date);

        // Adds min temperature
        minTemp = new GraphicsText(String.format("%.1f", newWrapper[0].getPredictedMinTemperature())+"\u2109", 270, 445);
        minTemp.setFont(f3);
        add(minTemp);

        // Adds max temperature
        maxTemp = new GraphicsText(String.format("%.1f", newWrapper[0].getPredictedMaxTemperature())+"\u2109", 410, 445);
        maxTemp.setFont(f3);
        add(maxTemp);
    }


    /**
     * Given x,y coordinates, this returns the forecastbox at that position if it exists
     * @param x pos to check
     * @param y pos to check
     * @return null if not over a forecast box
     */
    private ForecastBox getBoxAt(int x, int y){
        GraphicsObject obj = getElementAt(x, y);
        if (obj != null && obj instanceof ForecastBox){
            return (ForecastBox)obj;
        }
        return null;
    }

    /**
     * Updates the currently displayed forecast information depending on which ForecastBox is located at x,y.
     * Should be called from a mouseMoved event in WeatherProgram.
     * If there is not a ForecastBox at that position the display does not change.
     * @param x
     * @param y
     */
    public void updateSelection(int x, int y){
        ForecastBox box = getBoxAt(x, y);
        if (box != null) {
            remove(weather);
            remove(temperature);
            remove(date);
            remove(minTemp);
            remove(maxTemp);
            remove(icon);

            weather = new GraphicsText(box.getForecast().getPredictedWeather(), 250, 500);
            weather.setFont(f0);

            temperature = new GraphicsText(String.format("%.1f", box.getForecast().getPredictedTemperature())+"\u2109", 310, 400);
            temperature.setFont(f1);

            icon = box.getForecast().getWeatherIcon();
            icon.setPosition(240, 100);

            date = new GraphicsText(box.getForecast().getPredictionTime()+"", 50, 100);
            date.setFont(f2);

            minTemp = new GraphicsText(String.format("%.1f", box.getForecast().getPredictedMinTemperature())+"\u2109", 270, 445);
            minTemp.setFont(f3);

            maxTemp = new GraphicsText(String.format("%.1f", box.getForecast().getPredictedMaxTemperature())+"\u2019", 410, 445);
            maxTemp.setFont(f3);

            add(weather);
            add(temperature);
            add(date);
            add(minTemp);
            add(maxTemp);
            add(icon);


        }
    }

}
