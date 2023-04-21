package com.example.bored_bard.notes;

import io.realm.RealmObject;

public class Notes {
    String title;
    String description;
    String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Notes(){

    }

    public Notes(String title, String description){

        this.description = description;
        this.title = title;
    }

    public String getTitle() {

        return title;
    }


    public String getDescription() {

        return description;
    }



}
