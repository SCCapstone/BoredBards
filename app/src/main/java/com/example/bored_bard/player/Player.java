package com.example.bored_bard.player;
/**
 * @author Andrew MacMurray - FrozenDrew
 */
public class Player {

    String race;
    String name;
    String cclass;
    String hp;
    String ac;


    public Player(){

    }
    /**
     * Constructor for Player
     * @param name is the name of the Player's Character
     * @param race is the race of the Player's Character example: Human, Orc, Elf... so on
     * @param cclass is the Class of the Player's Character example: Mage, Fighter, Cleric .. so on
     * @param hp is the Base Health Points that the Player's Character starts with
     * @param ac is the Base Armor Class that the Player's Character starts with
     */
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
