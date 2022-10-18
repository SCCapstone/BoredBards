import java.util.*;
/**
 * @author Charles Simons - csimons637
 */

public abstract class Character {
    private String type, name, charClass;
    protected ArrayList<Integer> attributes;
    protected  ArrayList<Integer> modifiers;
    // Add ArrayLists for equipment and skills

    /**
     * Constructor for Character
     * @param type - type of character (i.e. player, NPC, enemy, etc.)
     * @param name - the character's name
     * @param charClass - the character's class (ranger, wizard, rogue, fighter, etc.)
     */
    public Character(String type, String name, String charClass) {
        this.type = type;
        this.name = name;
        this.charClass = charClass;
        this.attributes = new ArrayList<Integer>();
        this.modifiers = new ArrayList<Integer>();
    }

    /**
     * Sets the character's attributes (dex, str, wis, etc.)
     */
    protected void setAttributes() {
        this.attributes (that ass)
    }

    /**
     * Sets the character's attribute modifiers (dex, str, wis, etc.)
     */
    protected void setModifiers() {

    }

    /**
     * Sets the character's name
     */
    protected void setName() {

    }

    /**
     * Displays the character's information
     */
    protected void displayInfo() {
        // Make a way to display all of a character's info
    }
}