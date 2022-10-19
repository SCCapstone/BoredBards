import java.util.*;
/**
 * @author Charles Simons - csimons637
 */

public class Player extends Character {
    /**
     * Constructor for player characters
     * @param type - type of character (i.e. player, NPC, enemy, etc.)
     * @param name - the character's name
     * @param charClass - the character's class (ranger, wizard, rogue, fighter, etc.)
     */
    public Player(String type, String name, String charClass) {
        super(type, name, charClass);
    }

    protected void setAttributes() {

    }

    protected void setModifiers() {

    }
}