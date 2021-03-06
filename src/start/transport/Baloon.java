package start.transport;
import start.tower.*;
import start.transport.*;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                this.coordinates.setLongitude(this.coordinates.getLongitude() + 2);
                this.coordinates.setHeight(this.coordinates.getHeight() + 4);
                if (this.coordinates.getHeight() > 100)
                    this.coordinates.setLongitude(100);
                WriteToTXT.getWriteToTXT().writeTXT("Baloon#" + this.name + "(" + this.id + "): KEEP YOUR FACE TO THE SUN AND YOU WILL NEVER SEE THE SHADOWS");
                break;
            case "RAIN":
                this.coordinates.setHeight(this.coordinates.getHeight() - 5);
                WriteToTXT.getWriteToTXT().writeTXT("Baloon#" + this.name + "(" + this.id + "): RAIN FALLS AS GENTLY AS MERCY.\n");
                break;
            case "FOG":
                this.coordinates.setHeight(this.coordinates.getHeight() - 3);
                WriteToTXT.getWriteToTXT().writeTXT("Baloon#" + this.name + "(" + this.id + "): FOG IS THE MYSTERY ITSELF!");
                break;
            case "SNOW":
                this.coordinates.setHeight(this.coordinates.getHeight() - 15);
                WriteToTXT.getWriteToTXT().writeTXT("Baloon#" + this.name + "(" + this.id + "): IT'S SNOWING TOO BAD YOU GOT A BALOON :)");
                WriteToTXT.getWriteToTXT().writeTXT("Tower  says: Baloon#" + this.name + "(" + this.id + ")" + " UNREGISTERED FROM THE WEATHER TOWER.");
                break;
            default:
                WriteToTXT.getWriteToTXT().writeTXT("Baloon#" + this.name + "(" + this.id + "): CANT CONNECT THE WEATHER TOWER");
                break;
        }
        if (this.coordinates.getHeight() <= 0)
        {
            WriteToTXT.getWriteToTXT().writeTXT("Baloon#" + this.name + "(" + this.id + ") landing.");
        }
    }
    public	void	registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        WriteToTXT.getWriteToTXT().writeTXT("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " REGISTERED TO THE WEATHER TOWER.");
        weatherTower.register(this);
    }
}

