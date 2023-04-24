package com.example.bored_bard.player;

import androidx.annotation.NonNull;

public class Player {

    String race;
    String name;
    String cclass;
    String hp;
    String ac;

    public Player(){

    }
    public Player(String name, String race, String cclass, String hp, String ac){
        this.name = name;
        this.race = race;
        this.cclass = cclass;
        this.hp = hp;
        this.ac = ac;
    }


    public String getRace() {
        return race;
    }

    public String getName() {
        return name;
    }

    public String getCclass(){
        return cclass;
    }

    public String getHp() {
        return hp;
    }


    public String getAc() {
        return ac;
    }

    public String toString() {
        String temp = "Race: " + this.getRace() + ", Name: " + this.getName() + ", CClass: " + this.getCclass() + ", HP: " + this.getHp() + ", AC: " + this.getAc();
        return temp;
    }


}
