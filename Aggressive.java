import oop.ex2.SpaceShipPhysics;

/**
 * This class represents a aggressive spaceship in the game.
 */
public class Aggressive extends SpaceShip {

    // The max angle the ship should be from the closest ship
    private final double MAX_ANGLE = 0.21;

    @Override
    public void doAction(SpaceWars game) {
        SpaceShipPhysics currentClosetShip = game.getClosestShipTo(this).physics;
        //move
        double angle = physics.angleTo(currentClosetShip);
        int turn = STRAIGHT;
        if (angle < 0)
            turn = RIGHT;
        else if (angle > 0)
            turn = LEFT;
        physics.move(true, turn);
        // fire
        if (physics.angleTo(currentClosetShip) < MAX_ANGLE && fireBreak == 0){
            fire(game);
            fireBreak = FIRE_BREAK;
        }
        if (fireBreak > 0)
            fireBreak--;
        if (energy < maxEnergy)
            energy++;
    }
}
