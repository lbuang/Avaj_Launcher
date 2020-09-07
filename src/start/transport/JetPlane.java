package start.transport;
import start.tower.*;

public class JetPlane extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        String weather = this.weatherTower.getWeather(this.coordinates);
        switch (weather) {
            case "SUN":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 10);
                this.coordinates.setHeight(this.coordinates.getHeight() + 2);
                if (this.coordinates.getHeight() > 100)
                    this.coordinates.setHeight(100);
                WriteToTXT.getWriteToTXT().writeTXT("JetPlane#" + this.name + "(" + this.id + "): IT'S SUNNY AND YOU'RE FUNNY!");
                break;
            case "RAIN":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                WriteToTXT.getWriteToTXT().writeTXT("JetPlane#" + this.name + "(" + this.id + "): RAIN DROP, DROP TOP!");
                break;
            case "FOG":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                WriteToTXT.getWriteToTXT().writeTXT("JetPlane#" + this.name + "(" + this.id + "): FOGGY FOG CAN'T SEE A THING!");
                break;
            case "SNOW":
                this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                WriteToTXT.getWriteToTXT().writeTXT("JetPlane#" + this.name + "(" + this.id + "): JOHN SNOW GAME OF THRONES CALLED THEY WANT THEIR SNOW BACK!!");
                break;
            default:
                WriteToTXT.getWriteToTXT().writeTXT("JetPlane#" + this.name + "(" + this.id + "): CAN'T CONNECT TO THE WEATHER TOWER");
                break;
        }
        if (this.coordinates.getHeight() <= 0) {
            WriteToTXT.getWriteToTXT().writeTXT("JetPlane#" + this.name + "(" + this.id + ") landing.");
            WriteToTXT.getWriteToTXT().writeTXT("Tower  says: JetPlane#" + this.name + "(" + this.id + ")" + " UNREGISTERED FROM THE WEATHER TOWER.");
        }
    }

    public	void	registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        WriteToTXT.getWriteToTXT().writeTXT("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " REGISTERED TO THE WEATHER TOWER.");
        this.weatherTower.register(this);
    }
}


