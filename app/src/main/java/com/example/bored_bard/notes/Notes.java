package com.example.bored_bard.notes;

import io.realm.RealmObject;

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
