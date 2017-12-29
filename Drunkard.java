import java.util.Random;

/**
 * This class represents a drunkard spaceship in the game.
 */
public class Drunkard extends SpaceShip{

    // the success rate of the firing
    private final double FIRE_RATE = 0.8;
    @Override
    public void doAction(SpaceWars game) {
        // move
        Random random = new Random();
        int turn = random.nextInt(3) - 1; // -1 <= turn <= 1
        physics.move(true, turn);
        // fire
        int shot = random.nextInt(101); // 0 <= shot <= 100
        // make it FIRE_RATE% that the drunkard will make a fire
        if (fireBreak == 0 && shot >= (100 - FIRE_RATE)){
            fire(game);
            fireBreak = FIRE_BREAK;
        }
        if (fireBreak > 0)
            fireBreak--;
        if (energy < maxEnergy)
            energy++;
    }
}
