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
                WriteToTXT.getWriteToTXT().writeTXT("JetPlane#" + this.name + "(" + this.id + "): AHH THE SUN IS BLINDING ME!");
                break;
            case "RAIN":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 5);
                WriteToTXT.getWriteToTXT().writeTXT("JetPlane#" + this.name + "(" + this.id + "): WHO NEEDS WINDSHELD WIPERS FOR RAIN AT THIS SPEED HAHA");
                break;
            case "FOG":
                this.coordinates.setLatitude(this.coordinates.getLatitude() + 1);
                WriteToTXT.getWriteToTXT().writeTXT("JetPlane#" + this.name + "(" + this.id + "): CRAP I CANT SEE ANYTHING IN THIS FOG!");
                break;
            case "SNOW":
                this.coordinates.setHeight(this.coordinates.getHeight() - 12);
                WriteToTXT.getWriteToTXT().writeTXT("JetPlane#" + this.name + "(" + this.id + "): THE SNOW IS FREEZING MY WINDOWS THEY ARE GOING TO CRACK");
                break;
            default:
                WriteToTXT.getWriteToTXT().writeTXT("JetPlane#" + this.name + "(" + this.id + "): ALL HOPE IS LOST I CAN't COUNTACT THE WEATHER TOWER");
                break;
        }
        if (this.coordinates.getHeight() <= 0) {
            WriteToTXT.getWriteToTXT().writeTXT("JetPlane#" + this.name + "(" + this.id + ") landing.");
            WriteToTXT.getWriteToTXT().writeTXT("Tower  says: JetPlane#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.");
        }
    }

    public	void	registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        WriteToTXT.getWriteToTXT().writeTXT("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        this.weatherTower.register(this);
    }
}


