package start.transport;

import start.tower.*;

public interface Flyable {
    public void updateConditions();

    public void registerTower(WeatherTower weatherTower);

    public Coordinates getCoordinates();
}
