import oop.ex2.GameGUI;
import java.awt.*;

/**
 * This class represents a human spaceship in the game.
 */
public class Human extends SpaceShip{

    /**
     * returns the image of the human ship, and displays it to the screen at the end of the round.
     * @return the correct image of this ship (with or without a shield).
     */
    @Override
    public Image getImage() {
        if (!shield)
            return GameGUI.SPACESHIP_IMAGE;
        return GameGUI.SPACESHIP_IMAGE_SHIELD;
    }

    @Override
    public void doAction(SpaceWars game) {
        shield = false;
        // teleport
        if (game.getGUI().isTeleportPressed())
            teleport();
        // move
        boolean acceleration = false;
        if (game.getGUI().isUpPressed())
            acceleration = true;
        int turn = STRAIGHT;
        if (game.getGUI().isLeftPressed())
            turn = LEFT;
        else if (game.getGUI().isRightPressed())
            turn = RIGHT;
        physics.move(acceleration, turn);
        // shield
        if (game.getGUI().isShieldsPressed())
            shieldOn();
        // fire
        if (game.getGUI().isShotPressed() && fireBreak == 0) {
            fire(game);
            fireBreak = FIRE_BREAK;
        }
        if (fireBreak > 0)
            fireBreak--;
        if (energy < maxEnergy)
            energy++;
    }
}
