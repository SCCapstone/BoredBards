package com.example.bored_bard.campaign;


// import com.example.bored_bard.<note classes>;

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
    String information;

    /**
     * Constructor for Campaign
     * @param title the user's name for the campaign
     * @param information the Campaign's basic setting and information
     */
    public Campaign(String title, String information) {
        this.title = title;
        this.information = information;
//        this.npcList = npcList;
//        this.playerList = playerList;
    }
    public String getTitle() {

        return title;
    }

    public String getInformation() {

        return information;
    }
    public Campaign(){

    }


 }