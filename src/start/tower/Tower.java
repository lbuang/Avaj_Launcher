package start.tower;

import java.util.*;
import start.transport.*;

public class Tower {
    private ArrayList<Flyable> observers = new ArrayList<>();
    private ArrayList<Flyable> landNotification = new ArrayList<>();


    public void register(Flyable flyable)
    {
        if(!observers.contains(flyable))
        {
            this.observers.add(flyable);
        }
    }

    public void unregister(Flyable flyable)
    {
        this.observers.remove(flyable);
    }

    protected void conditionsChanged()
    {
        for (Flyable flyable : observers) {
            flyable.updateConditions();
            if(flyable.getCoordinates().getHeight() <= 0)
                landNotification.add(flyable);
        }
        observers.removeAll(landNotification);
    }
}

