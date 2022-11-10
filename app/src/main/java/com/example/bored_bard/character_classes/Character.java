package com.example.bored_bard.character_classes;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import equipment_classes.Equipment;
import ability_classes.Ability;
/**
 * @author Charles Simons - csimons637
 */

public abstract class Character {
    private String type, name, charClass, race;
    protected ArrayList<Integer> attributes, modifiers;
    protected ArrayList<Equipment> equipment; 
    protected ArrayList<Ability> abilities;

    /**
     * Constructor for Character
     * @param type type of character (i.e. player, NPC, enemy, etc.)
     * @param name the character's name
     * @param charClass the character's class (ranger, wizard, rogue, fighter, etc.)
     * @param race define what race the charcter will be (orc, human, elf, dragonic)
     */
    public Character(String type, String name, String charClass, String race) {
        this.type = type;
        this.name = name;
        this.charClass = charClass;
        this.race = race;
        this.attributes = new ArrayList<Integer>();
        this.modifiers = new ArrayList<Integer>();
        this.equipment = new ArrayList<Equipment>();
        this.abilities = new ArrayList<Ability>();
    }

    /**
     * Adds the character's equipment
     */
    protected abstract void addEquipment();

    /**
     * Adds the character's skills
     */
    protected abstract void addAbilities();

    /**
     * Sets the character's attributes (dex, str, wis, etc.)
     */
    protected abstract void setAttributes(Integer strength, Integer dexterity, Integer constitution,
                                        Integer intelligence, Integer wisdom, Integer charisma);

    /**
     * Sets the character's attribute modifiers (dex, str, wis, etc.)
     */
    protected abstract void setModifiers(Integer strengthMod, Integer dexterityMod, Integer constitutionMod,
                                        Integer intelligenceMod, Integer wisdomMod, Integer charismaMod);

    /**
     * Sets the character's name
     */
    protected abstract void setName(String name);

    /**
     * Sets the character's class
     */
    protected abstract void setClass(String charClass);

    /**
     * Sets the race of the charcter
     */
    protected abstract void setRace(String race);

    /**
     * Displays the character's information
     */
    protected abstract void displayInfo();
}
