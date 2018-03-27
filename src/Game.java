import java.util.ArrayList;

/**
 * Represents the entire game and controls its flow
 */
public class Game {
    //fields
    /**
     * The player playing the game
     */
    private Player player;
    /**
     * The world map
     */
    private Map map;
    /**
     * The list of all existing ports
     */
    private ArrayList<Port> ports;

    //constructors
    /**
     *
     */
    public Game(){
        player = new Player();
        map = new Map();
        ports = new ArrayList<>();
    }

    //methods
}
