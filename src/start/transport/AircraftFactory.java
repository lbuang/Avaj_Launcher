package start.transport;

import start.transport.*;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        String ft_string = type.toLowerCase();
        if(ft_string.equals("helicopter"))
        {
            return new Helicopter(name, coordinates);
        }
        else if(ft_string.equals("jetplane"))
        {
            return new JetPlane(name, coordinates);
        }
        else if(ft_string.equals("baloon"))
        {
            return new Baloon(name, coordinates);
        }
        else
        {
            System.out.println("Unknown Type: " + type);
            return null;
        }

    }
}
