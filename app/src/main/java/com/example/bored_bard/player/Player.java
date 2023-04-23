package com.example.bored_bard.player;

import androidx.annotation.NonNull;

public class Player {

    String Race;
    String Name;
    String CClass;
    String Hp;
    String level;
    String AC;

    public Player(){

    }
    public Player(String Name, String Race, String CClass, String Hp, String AC){
        this.Name = Name;
        this.Race = Race;
        this.CClass = CClass;
        this.Hp = Hp;
        this.AC = AC;
    }


    public String getRace() {
        return Race;
    }

    public String getName() {
        return Name;
    }

    public String getCClass(){
        return CClass;
    }

    public String getHp() {
        return Hp;
    }

    public String getLevel() {
        return level;
    }

    public String getAC() {
        return AC;
    }



}
