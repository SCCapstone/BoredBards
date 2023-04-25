package com.example.bored_bard.UI_files;

import com.example.bored_bard.notes.Notes;
/**
 * @author Andrew MacMurray - FrozenDrew
 */
public class User {
    private String email;
    private String password;
    private String username;

    public User(){}

    /**
     *
     * @param email is the email in form example@example.example
     * @param password is the password set by the User must be greater than 6 characters long
     * @param username is the username set by the User which will be user to store their User Data
     */
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
