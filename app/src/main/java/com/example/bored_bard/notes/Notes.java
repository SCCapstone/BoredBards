package com.example.bored_bard.notes;

import io.realm.RealmObject;

public class Notes {
    String title;
    String description;


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
