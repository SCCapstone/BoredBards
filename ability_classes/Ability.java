package ability_classes;
import java.util.ArrayList;
/**
 * @author Charles Simons - csimons367
 */
public class Ability {
    String name;
    String type; // spell, physical (pickpocketing, forgery, etc.)
    String effect; // damage, sleep, charmed, etc.
    ArrayList<String> characteristics; // concentration, ritual, cantrip, etc.
    
    /**
     * Builds an ability from the list
     * @param name The ability's name
     * @param type The ability's type (i.e. spell, physical, etc.)
     * @param effect The ability's main effect (i.e. intimidation, charmed, 2d6 damage, etc.)
     * @param characteristics A list of the ability's characteristics (i.e. concentration, ritual, cantrip, etc.)
     */
    public Ability(String name, String type, String effect, ArrayList<String> characteristics) {
        this.characteristics = new ArrayList<String>();
        this.name = name;
        this.type = type;
        this.effect = effect;
    }

    /**
     * Gets the ability's name
     * @return ability's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the ability's type
     * @return ability's type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Gets the ability's damage
     * @return ability's damage
     */
    public String getEffect() {
        return this.effect;
    }

    /**
     * Gets the ability's list of characteristics
     * @return List of ability's characteristics
     */
    public ArrayList<String> getCharacteristics() {
        return this.characteristics;
    }

    /**
     * Converts the ability's details into a String
     * @return String representation of the ability's basic details (name, type and effect)
     */
    public String toString() {
        String ability;
        ability = this.name + ": " + this.type + ": " + this.effect;
        return ability;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public void setCharacteristics(ArrayList<String> characteristics) {
        this.characteristics = characteristics;
    }

}
