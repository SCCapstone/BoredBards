import java.util.ArrayList;
import equipment_classes.Equipment;
import ability_classes.Ability;
/**
 * @author Charles Simons - csimons637
 */

public class Player extends Character {
    private String type, name, charClass, race;
    protected ArrayList<Integer> attributes, modifiers;
    protected ArrayList<Equipment> equipment; 
    protected ArrayList<Ability> abilities;

    /**
     * Constructor for player characters
     * @param type - type of character (i.e. player, NPC, enemy, etc.)
     * @param name - the character's name
     * @param charClass - the character's class (ranger, wizard, rogue, fighter, etc.)
     * @param race - define what race the charcter will be (orc, human, elf, dragonic)
     */
    public Player(String type, String name, String charClass, String race) {
        super(type, name, charClass, race);
    }

    /**
     * Adds the NPC's list of equipment from the database
     */
    protected void addEquipment() {
        // database pending
    }

    /**
     * Adds the NPC's list of abilities from the database
     */
    protected void addAbilities() {
        // database pending
    }

    public ArrayList<Ability> getAbilities() {
        return this.abilities;
    }

    public ArrayList<Equipment> getEquipment() {
        return this.equipment;
    }

	protected void setAttributes(Integer strength, Integer dexterity, Integer constitution,
                                Integer intelligence, Integer wisdom, Integer charisma) {
        this.attributes.add(strength); // 0th
        this.attributes.add(dexterity); // 1st
        this.attributes.add(constitution); // 2nd
        this.attributes.add(intelligence); // 3rd
        this.attributes.add(wisdom); // 4th
        this.attributes.add(charisma); // 5th
    }

    protected void setModifiers(Integer strengthMod, Integer dexterityMod, Integer constitutionMod,
                                Integer intelligenceMod, Integer wisdomMod, Integer charismaMod) {
        this.modifiers.add(strengthMod); // 0th
        this.modifiers.add(dexterityMod); // 1st
        this.modifiers.add(constitutionMod); // 2nd
        this.modifiers.add(intelligenceMod); // 3rd
        this.modifiers.add(wisdomMod); // 4th
        this.modifiers.add(charismaMod); // 5th
    }

    /**
     * Sets the character's name
     */
    protected void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the character's class
     */
    protected void setClass(String charClass) {
        this.charClass = charClass;
    }

    /**
     * Sets the race of the charcter
     */
    protected void setRace(String race){
        this.race = race;
    }

    /**
     * Displays the character's information
     */
    protected void displayInfo() {
        // Make a way to display all of a character's info
    }
}
