import oop.ex2.SpaceShipPhysics;

/**
 * This class represents a basher spaceship in the game.
 */
public class Basher extends SpaceShip{
    // The max distance the ship should be from the closest ship
    protected final double MAX_DISTANCE = 0.19;

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
        physics.move(true, turn);
        // shield
        if (physics.distanceFrom(currentClosetShip) <= MAX_DISTANCE)
            shieldOn();
        if (energy < maxEnergy)
            energy++;
    }
}
