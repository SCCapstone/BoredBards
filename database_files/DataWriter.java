//json libraries
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
// java libraries
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileReader;
import java.text.ParseException;
/**
 * @author Charles Simons -csimons637 and Caroline Barrineau - CarolineBarrineau
 */
public class DataWriter extends DataConstants {
    public static JSONObject getUser(User user) {
        JSONObject userDetails = new JSONOBject(); // This is the JSONObject that will store each
                                                   // user's information while writing to the database
        // The rest of the code will retrieve each user's name, email, password, etc. and then put
        // them into the users.json file in the proper order and format
    }

    public static void writeUsers() {
        // will write the list of users or append a new user to the list
    }

    public static JSONObject getItem(Item item) {
        JSONObject itemDetails = new JSONObject(); // This is the JSONObject that will store each
                                                   // item's information while writing to the database
        // The rest of the code will retrieve each item's information and then put it into the
        // items.json file in the proper order and format
    }

    public static  void writeItems() {
        // will write the list of items or add a new item to the list
    }

    public static JSONObject getAbility(Ability ability) {
        JSONObject abilityDetails = new JSONObject(); // This is the JSONObject that will store each
                                                    // ability's information while writing to the database
        // The rest of the code will retrieve each ability's information and then put it into the
        // abilities.json file in the proper order and format
    }

    public static  void writeAbilities() {
        // will write the list of abilities or add a new ability to the list
    }

}