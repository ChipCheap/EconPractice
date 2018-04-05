package application.model;

/**
 * Represents a Tuple of coordinates
 */
public class Tuple {
    //fields
    /**
     * The coordinates of the tuple
     */
    private final int X, Y;

    //constructors
    /**
     * Creates a new tuple with the given x, y - coordinates
     * @param x The x-coordinate to initialize the tuple with
     * @param y The y-coordinate to initialize the tuple with
     */
    public Tuple(int x, int y){
        this.X = x;
        this.Y = y;
    }

    //methods
    //helper functions
    /**
     * Wraps the x-coordinate around if needed
     * @param x The x-coordinate to be wrapped
     * @param xSize The size of the map
     * @return xSize - |x| if x is negative, else just x, which completes the wrap around
     */
    public static int wrapCoordinates(int x, int xSize){
        int xTemp = x;
        while(xTemp < 0){
            xTemp += xSize;
        }
        return xTemp % xSize;
    }

    /**
     * Calculates the number of steps in squares between two tuple
     * @param tuple1 First tuple
     * @param tuple2 Second tuple
     * @return The absolute of the difference between the x and y coordinates added together
     */
    public static int calculateDistance(Tuple tuple1, Tuple tuple2){
        return Math.abs((tuple1.getX() - tuple2.getX())) + Math.abs((tuple1.getY() - tuple2.getY()));
    }

    /**
     * Creates a new tuple of the given tuple and this object
     * @param tuple The other tuple to be added
     * @return Adds the two x and y coordinates together and creates a tuple out of those values
     */
    public Tuple addTuple(Tuple tuple){return new Tuple(getX() + tuple.getX(), getY() + tuple.getY());}

    /**
     * Works the same as the {@link #addTuple(Tuple)}, just with coordinates
     * Creates a new tuple of the given coordinates and this object
     * @param x The x-coordinate to be added
     * @param y The y-coordinate to be added
     * @return Adds the two x and y coordinates together and creates a tuple out of those values
     */
    public Tuple addCoordinates(int x, int y){return new Tuple(getX() + x, getY() + y);}

    //getters
    /**
     * Returns the x-coordinate
     * @return The x-coordinate of the tuple
     */
    public int getX() {return X;}

    /**
     * Returns the y-coordinate
     * @return The y-coordinate of the tuple
     */
    public int getY() {return Y;}

    /**
     * Compares this tuple with another one and determines whether both are equal
     * @param tuple The other tuple to compare to
     * @return True if both x and y-coordinates are the same
     */
    public boolean equals(Tuple tuple){return X == tuple.getX() && Y == tuple.getY();}

    /**
     * Returns a string of the coordinates
     * @return String in the form of "(x, y)"
     */
    public String toString() {return "(" + X + ", " + Y + ")";}
}
