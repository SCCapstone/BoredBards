package com.example.bored_bard.notes;

import io.realm.RealmObject;

public class Notes {
    String title;
    String description;
    long createdTime;

    public Notes(){

    }

    public Notes(String title, String description){
//        this.createdTime = createTime;
        this.description = description;
        this.title = title;
    }

    public String getTitle() {

        return title;
    }


    public String getDescription() {

        return description;
    }

//    public long getCreatedTime(){
//        return createdTime;
//    }

}
