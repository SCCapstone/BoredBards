import java.util.ArrayList;
/**
 * @author Charles Simons - csimons637
 */

public abstract class Character {
    private String type, name, charClass, race;
    protected ArrayList<Integer> attributes, ArrayList<Integer> modifiers,
                ArrayList<Equipment> equipment, ArrayList<Abilities> abilities;

    /**
     * Constructor for Character
     * @param type - type of character (i.e. player, NPC, enemy, etc.)
     * @param name - the character's name
     * @param charClass - the character's class (ranger, wizard, rogue, fighter, etc.)
     * @param race - define what race the charcter will be (orc, human, elf, dragonic)
     */
    public Character(String type, String name, String charClass, String race) {
        this.type = type;
        this.name = name;
        this.charClass = charClass;
        this.race = race;
        this.attributes = new ArrayList<Integer>();
        this.modifiers = new ArrayList<Integer>();
        this.equipment = new ArrayList<Equipment>();
        this.abilities = new ArrayList<Abilities>();
    }

    /**
     * Adds the character's equipment
     */
    protected abstract void addEquipment();

    /**
     * Adds the character's skills
     */
    protected abstract void addSkills();

    /**
     * Sets the character's attributes (dex, str, wis, etc.)
     */
    protected void setAttributes(Integer dex, Integer str, Integer wis,
                                 Integer intel, Integer charis, Integer con) {
        // nothing should be here yet
    }

    /**
     * Sets the character's attribute modifiers (dex, str, wis, etc.)
     */
    protected void setModifiers() {
        // new merge conflict here
    }

    /**
     * Sets the character's name
     */
    protected void setName() {

    }

    /**
     * Sets the character's class
     */
    protected void setClass() {

    }

    /**
     * Displays the character's information
     */
    protected void displayInfo() {
        // Make a way to display all of a character's info
    }
    /**
     * Sets the race of the charcter
     */
    protected void setRace(){
    
    }
}
