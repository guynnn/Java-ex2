import oop.ex2.SpaceShipPhysics;

/**
 * This class represents a runner spaceship in the game.
 */
public class Runner extends SpaceShip {
    // The max angle the ship should be from the closest ship
    private final double MAX_ANGLE = 0.23;
    // The max distance the ship should be from the closest ship
    private final double MAX_DISTANCE = 0.25;

    @Override
    public void doAction(SpaceWars game) {
        // teleport
        SpaceShipPhysics currentClosetShip = game.getClosestShipTo(this).physics;
        if (physics.distanceFrom(currentClosetShip) < MAX_DISTANCE &&
                                                      physics.angleTo(currentClosetShip) < MAX_ANGLE){
            teleport();
        }
        // move
        double angle = physics.angleTo(currentClosetShip);
        int turn = STRAIGHT;
        if (angle < 0)
            turn = LEFT;
        else if (angle > 0)
            turn = RIGHT;
        physics.move(true, turn);
        if (energy < maxEnergy)
            energy++;
    }
}
