import java.util.ArrayList;
/**
 * @author Charles Simons - csimons637
 */

public abstract class Character {
    private String type, name, charClass, race;
    protected ArrayList<Integer> attributes, modifiers;
    protected ArrayList<Equipment> equipment; 
    protected ArrayList<Abilities> abilities;

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
    protected void setAttributes(Integer strength, Integer dexterity, Integer constitution,
                                 Integer intelligence, Integer wisdom, Integer charisma) {
        this.attributes.add(strength);
        this.attributes.add(dexterity);
        this.attributes.add(constitution);
        this.attributes.add(intelligence);
        this.attributes.add(wisdom);
        this.attributes.add(charisma);
    }

    /**
     * Sets the character's attribute modifiers (dex, str, wis, etc.)
     */
    protected void setModifiers(Integer strengthMod, Integer dexterityMod, Integer constitutionMod,
                                Integer intelligenceMod, Integer wisdomMod, Integer charismaMod) {
        this.modifiers.add(strengthMod);
        this.modifiers.add(dexterityMod);
        this.modifiers.add(constitutionMod);
        this.modifiers.add(intelligenceMod);
        this.modifiers.add(wisdomMod);
        this.modifiers.add(charismaMod);
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
