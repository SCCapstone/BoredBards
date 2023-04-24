package com.example.bored_bard.encyclopedia;

import java.util.List;
import java.util.Map;

public class Monsters {

    private String name;
    private String desc;
    private List<Map<String,Object>> armor_class;
    private int hit_points;
    private int charisma;
    private int constitution;
    private int dexterity;
    private int intelligence;
    private int strength;
    private int wisdom;

    public Monsters(){};
    public Monsters(String name, String desc, List<Map<String, Object>> armor_class, int hit_points, int charisma, int constitution, int dexterity, int intelligence, int strength, int wisdom) {
        this.name = name;
        this.desc = desc;
        this.armor_class = armor_class;
        this.hit_points = hit_points;
        this.charisma = charisma;
        this.constitution = constitution;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.strength = strength;
        this.wisdom = wisdom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Map<String, Object>> getArmor_class() {
        return armor_class;
    }

    public String getArmor_classAsString() {
        String temp = "";
        for (Map<String,Object> i : this.armor_class) {
            switch (i.get("type").toString()) {
                case ("natural"): {
                    temp += i.get("value");
                    break;
                }
                case ("dex"): {
                    temp += i.get("value");
                    break;
                }
                case ("armor"): {
                    Map<String,String> armor = (Map<String, String>) i.get("armor");
                    temp += armor.get("name") + ": " + i.get("value");
                    break;
                }
                case ("spell"): {
                    Map<String,String> spell = (Map<String, String>) i.get("spell");
                    temp += spell.get("name") + ": " + i.get("value");
                    break;
                }
                default: {
                    temp += "10";
                    break;
                }

            }
            temp += "\n";
        }

        temp = temp.trim();
        return temp;
    }


    public void setArmor_class(List<Map<String, Object>> armor_class) {
        this.armor_class = armor_class;
    }

    public int getHit_points() {
        return hit_points;
    }

    public void setHit_points(int hit_points) {
        this.hit_points = hit_points;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }
}
