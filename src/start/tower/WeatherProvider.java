package start.tower;


import java.util.*;
import start.transport.*;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = null;
    private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider()
    {
        weatherProvider = this;
    }

    public static WeatherProvider getProvider()
    {
        if(weatherProvider == null)
        {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String	getCurrentWeather(Coordinates coordinates) {
        Random random = new Random();
        int randomNumber = 0;
        randomNumber = random.nextInt(4);
        return (weather[randomNumber]);
    }
}
