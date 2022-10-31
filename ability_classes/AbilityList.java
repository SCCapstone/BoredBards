package ability_classes;
import java.util.ArrayList;
/**
 * @author Charles Simons - csimons637
 */
public class AbilityList {
    private ArrayList<Ability> abilities = new ArrayList<Ability>();

    /**
     * Gets an ability from the list of abilities
     * @param index - Index of the ability to be retrieved
     * @return - The ability specified by 'index'
     */
    public Ability getAbility(int index) {
        Ability ability = abilities.get(index);
        return ability;
    }

    /**
     * Returns an ability list for the user to select from
     * @return - A list of abilities
     */
    public ArrayList<String> displayEquipment() {
        ArrayList<String> display = new ArrayList<String>();
        for (Ability a : abilities) {
            display.add(a.getName());
        }
        return display; // doesn't print the list, just creates and populates it
    }
}
