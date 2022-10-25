package equipment_classes;
import java.util.ArrayList;
/**
 * @author Charles Simons - csimons367
 */
public class Equipment {
    String name;
    String type; // i.e. weapon, armor, utility, etc.
    String damage; // 2d4, 1d8, 2d6, etc.
    ArrayList<String> characteristics; // stuff like one-handed, finesse, thrown, etc

    /**
     * Builds an item from the list
     * @param name - The item's name
     * @param type - The item's type (i.e. weapon, armor, utility, etc.)
     * @param damage - The item's damage (if applicable; i.e. 2d4, 1d8, 2d6, etc.)
     * @param characteristics - A list of the item's characteristics (i.e. one-handed, finesse, thrown, etc.)
     */
    public Equipment(String name, String type, String damage, ArrayList<String> characteristics) {
        this.characteristics = new ArrayList<String>();
        this.name = name;
        this.type = type;
        this.damage = damage;
        this.characteristics = characteristics;
    }

    /**
     * Gets the item's name
     * @return - Item's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the item's type
     * @return - Item's type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Gets the item's damage
     * @return - Item's damage
     */
    public String getDamage() {
        return this.damage;
    }

    /**
     * Gets the item's list of characteristics
     * @return - List of item's characteristics
     */
    public ArrayList<String> getCharacteristics() {
        return this.characteristics;
    }
}