package com.example.bored_bard.UI_files;

import com.example.bored_bard.notes.Notes;

public class User {
    private String email;
    private String password;
    private String username;

    public User(){}
    public User(String email, String password, String username){
        this.email = email;
        this.password = password;
        this.username = username;
        //Add notes to user information.
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){

        return password;
    }

    public String getUsername(){

        return username;
    }



}
