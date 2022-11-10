package com.example.bored_bard;

import com.example.bored_bard.character_classes.*;

import java.util.ArrayList;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

/**
 * @author Charles Simons - csimons637
 */

 public class Campaign {
    String title;
    String setting;
    ArrayList<NPC> npcList;
    ArrayList<Player> playerList;

    /**
     * Constructor for Campaign
     * @param title the user's name for the campaign
     * @param setting the Campaign's setting
     * @param npcList a list of non-player characters in the Campaign
     * @param playerList a list of player characters in the Campaign
     */
    public Campaign(String title, String setting, ArrayList<NPC> npcList, ArrayList<Player> playerList) {
        this.title = title;
        this.setting = setting;
        this.npcList = npcList;
        this.playerList = playerList;
    }

    /**
     * Adds a new character to the Campaign "from scratch"
     * @param type character's type (NPC, player, etc.)
     * @param name character's name
     * @param charClass character's class
     * @param race character's race
     */
    public void addNewPlayer(String type, String name, String charClass, String race,
                             Integer strength, Integer dexterity, Integer constitution, Integer intelligence, Integer wisdom, Integer charisma,
                             Integer strengthMod, Integer dexterityMod, Integer constitutionMod, Integer intelligenceMod, Integer wisdomMod, Integer charismaMod) {
        // player attributes will need to be set by the UI, when added
        // users will enter the values manually, since we don't have a pdf scanner option (yet)
        Player p = new Player(type, name, charClass, race); // this only creates the base chracter; no attributes, modifiers, etc.
        p.setAttributes(strengthMod, dexterityMod, constitutionMod, intelligenceMod, wisdomMod, charismaMod);
        p.setModifiers(strengthMod, dexterityMod, constitutionMod, intelligenceMod, wisdomMod, charismaMod);
        this.playerList.add(p);
    }

    /**
     * Adds an existing player character to the Campaign
     * @param p the existing player character to be added
     */
    public void addPlayer(Player p) {
        this.playerList.add(p);
    }
 }