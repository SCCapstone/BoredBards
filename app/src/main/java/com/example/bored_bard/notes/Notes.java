package com.example.bored_bard.notes;

import io.realm.RealmObject;
/**
 * @author Andrew MacMurray - FrozenDrew
 */
public class Notes {
    String title;
    String description;
    String key;

    String id;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Notes(){

    }
    /**
     * Constructor for Campaign
     * @param title the user's name for the Note
     * @param description the information about the Note
     * @param id the Notes specific Id used to keep track of the Note in the database
     */
    public Notes(String title, String description, String id){

        this.description = description;
        this.title = title;
        this.id = id;
    }

    public String getTitle() {

        return title;
    }


    public String getDescription() {

        return description;
    }

    public String getId(){
        return id;
    }




}
