import oop.ex2.SpaceShipPhysics;

/**
 * This class represents a special spaceship in the game.
 */
public class Special extends SpaceShip{

    // the max distance the ship should be from the closest ship
    private final double MAX_DISTANCE = 0.25;

    @Override
    public void doAction(SpaceWars game) {
        shield = false;
        SpaceShipPhysics currentClosetShip = game.getClosestShipTo(this).physics;
        // move
        double angle = physics.angleTo(currentClosetShip);
        int turn = STRAIGHT;
        if (angle < 0)
            turn = RIGHT;
        else if (angle > 0)
            turn = LEFT;
        physics.move(false, turn);
        // shield
        if (physics.distanceFrom(currentClosetShip) < MAX_DISTANCE / 2)
            shieldOn();
        // fire
        else if (physics.distanceFrom(currentClosetShip) < MAX_DISTANCE && fireBreak == 0){
            fire(game);
            fireBreak = FIRE_BREAK;
        }
        if (fireBreak > 0)
            fireBreak--;
        if (energy < maxEnergy)
            energy++;
    }
}