package com.example.bored_bard.encyclopedia;

import java.util.List;
import java.util.Map;

public class Monsters {

    private String name;
    private List<Map<String,Object>> armor_class;
    private String hit_points;
    private String charisma;
    private String constitution;
    private String dexterity;
    private String intelligence;
    private String strength;
    private String wisdom;
    private Map<String,String> senses;

    public Monsters(){};
    public Monsters(String name, List<Map<String, Object>> armor_class, String hit_points, String charisma, String constitution, String dexterity, String intelligence, String strength, String wisdom, Map<String,String> senses) {
        this.name = name;
        this.armor_class = armor_class;
        this.hit_points = hit_points;
        this.charisma = charisma;
        this.constitution = constitution;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
        this.strength = strength;
        this.wisdom = wisdom;
        this.senses = senses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Map<String, Object>> getArmor_class() {
        return armor_class;
    }

    public String getArmor_classAsString() {
        String temp = "";
        for (Map<String,Object> i : this.armor_class) {
            switch (i.get("type").toString()) {
                case ("natural"):
                case ("dex"): {
                    temp += i.get("value");
                    break;
                }
                case ("armor"): {
                    List<Map<String,Object>> armor = (List<Map<String, Object>>) i.get("armor");
                    for (Map<String,Object> j : armor) {
                        temp += j.get("name") + ": " + i.get("value");
                    }

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

    public String getHit_points() {
        return hit_points;
    }

    public void setHit_points(String hit_points) {
        this.hit_points = hit_points;
    }

    public String getCharisma() {
        return charisma;
    }

    public void setCharisma(String charisma) {
        this.charisma = charisma;
    }

    public String getConstitution() {
        return constitution;
    }

    public void setConstitution(String constitution) {
        this.constitution = constitution;
    }

    public String getDexterity() {
        return dexterity;
    }

    public void setDexterity(String dexterity) {
        this.dexterity = dexterity;
    }

    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getWisdom() {
        return wisdom;
    }

    public void setWisdom(String wisdom) {
        this.wisdom = wisdom;
    }

    public Map<String, String> getSenses() {
        return senses;
    }

    public void setSenses(Map<String, String> senses) {
        this.senses = senses;
    }
}
