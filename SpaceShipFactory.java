/**
 * This class have only one static method that creates an array of spaceships to the game.
 */
public class SpaceShipFactory {
    /** Represent the String for a human spaceship **/
    public static final String HUMAN = "h";
    /** Represent the String for a runner spaceship **/
    public static final String RUNNER = "r";
    /** Represent the String for a basher spaceship **/
    public static final String BASHER = "b";
    /** Represent the String for a aggressive spaceship **/
    public static final String AGGRESSIVE = "a";
    /** Represent the String for a drunkard spaceship **/
    public static final String DRUNKARD = "d";
    /** Represent the String for a smart spaceship **/
    public static final String SPECIAL = "s";
    /**
     * Creates an array of spaceship to the game.
     * @param args the arguments given to the program.
     * @return an array of spaceships.
     */
    public static SpaceShip[] createSpaceShips(String[] args) {
        SpaceShip[] ships = new SpaceShip[args.length];
        for (int i = 0; i < args.length; i++) {
            switch(args[i]) {
                case HUMAN : ships[i] = new Human();
                    break;
                case RUNNER : ships[i] = new Runner();
                    break;
                case BASHER : ships[i] = new Basher();
                    break;
                case AGGRESSIVE: ships[i] = new Aggressive();
                    break;
                case DRUNKARD : ships[i] = new Drunkard();
                    break;
                case SPECIAL : ships[i] = new Special();
                    break;
            }
        }
        return ships;
    }
}