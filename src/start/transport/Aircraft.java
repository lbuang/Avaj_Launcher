package start.transport;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    private  static long idCounter = 0;

    // Constructor
    protected Aircraft (String name, Coordinates coordinates){

        this.idCounter = nextId();
        this.id = this.idCounter;
        this.name = name;
        this.coordinates = coordinates;
    }
    private long nextId(){ ++idCounter; return (idCounter); }

    //Add
    public Coordinates getCoordinates()
    {
        return this.coordinates;
    }
}
