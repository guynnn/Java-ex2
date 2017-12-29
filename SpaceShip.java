import java.awt.Image;
import oop.ex2.*;

/**
 * This class represents a general spaceship in the game.
 */
public abstract class SpaceShip{
    /** The health a given spaceship has **/
    public static final int STARTING_HEALTH = 22;
    /** The max energy a spaceship starts with **/
    public static final int STARTING_MAX_ENERGY = 210;
    /** The energy a spaceship starts with **/
    public static final int STARTING_ENERGY = 190;
    /** The turns a ship must not shot after making a shot **/
    public static int FIRE_BREAK = 7;
    /** the amounts of points to be added to the energy and maxEnergy in case of bashing **/
    protected final int BASHING_POINTS = 18;
    /** the amounts of points to be reduced to the maxEnergy in case of colliding with another ship or shot**/
    protected final int HIT_POINTS = 10;
    /** shield energy cost **/
    protected final int SHIELD = 3;
    /** teleport energy cost **/
    protected final int TELEPORT = 140;
    /** fire energy cost **/
    protected final int FIRE = 19;
    /** make the ship to turn right **/
    protected final int RIGHT = -1;
    /** make the ship to turn left **/
    protected final int LEFT = 1;
    /** make the ship to keep straight **/
    protected final int STRAIGHT = 0;
    /** Represents the spaceship location, speed and other physical values **/
    SpaceShipPhysics physics;
    /** The max energy a spaceship could has in a given time **/
    int maxEnergy;
    /** The spaceship current energy **/
    int energy;
    /** The spaceship current health **/
    int health;
    /** Represents in how many turns the spaceship can fire again **/
    int fireBreak;
    /** true if the shield is on, false otherwise **/
    boolean shield;

    /**
     * Creates a new spaceship (only kinds of spaceships because the class is abstract)
     */
    public SpaceShip(){
        physics = new SpaceShipPhysics();
        health = STARTING_HEALTH;
        maxEnergy = STARTING_MAX_ENERGY;
        energy = STARTING_ENERGY;
    }

    /**
     * Does the actions of this ship for this round.
     * This is called once per round by the SpaceWars game driver.
     * @param game the game object to which this ship belongs.
     */
    public abstract void doAction(SpaceWars game);

    /**
     * This method is called every time a collision with this ship occurs 
     */
    public void collidedWithAnotherShip(){
        if (shield){
            maxEnergy += BASHING_POINTS;
            energy += BASHING_POINTS;
        }
        else{
            health--;
            maxEnergy -= HIT_POINTS;
            if (energy > maxEnergy)
                energy = maxEnergy;
        }
    }

    /** 
     * This method is called whenever a ship has died. It resets the ship's 
     * attributes, and starts it at a new random position.
     */
    public void reset(){
        physics = new SpaceShipPhysics();
        health = STARTING_HEALTH;
        maxEnergy = STARTING_MAX_ENERGY;
        energy = STARTING_ENERGY;
        fireBreak = 0;
    }

    /**
     * Checks if this ship is dead.
     * 
     * @return true if the ship is dead. false otherwise.
     */
    public boolean isDead() {
        System.out.println(health);
        return health == 0;
    }

    /**
     * Gets the physics object that controls this ship.
     * 
     * @return the physics object that controls the ship.
     */
    public SpaceShipPhysics getPhysics() {
        return physics;
    }

    /**
     * This method is called by the SpaceWars game object when ever this ship
     * gets hit by a shot.
     */
    public void gotHit() {
        if (shield)
            return;
        health--;
        maxEnergy -= HIT_POINTS;
        if (energy > maxEnergy)
            energy = maxEnergy;
    }

    /**
     * Gets the image of this ship. This method should return the image of the
     * ship with or without the shield. This will be displayed on the GUI at
     * the end of the round.
     * 
     * @return the image of this ship.
     */
    public Image getImage(){
        if (!shield)
            return GameGUI.ENEMY_SPACESHIP_IMAGE;
        return GameGUI.ENEMY_SPACESHIP_IMAGE_SHIELD;

    }

    /**
     * Attempts to fire a shot.
     * @param game the game object.
     */
    public void fire(SpaceWars game) {
        if (energy < FIRE)
            return;
        energy -= FIRE;
        game.addShot(physics);
    }

    /**
     * Attempts to turn on the shield.
     */
    public void shieldOn() {
        if (energy < SHIELD)
            return;
        energy -= SHIELD;
        shield = true;
    }

    /**
     * Attempts to teleport.
     */
    public void teleport() {
        if (energy < TELEPORT)
           return;
        energy -= TELEPORT;
        physics = new SpaceShipPhysics();
    }
}
