package com.example.bored_bard.encyclopedia;

import java.util.HashMap;
import java.util.List;

public class classes {
    private String name;
    private int hit_die;
    private String index;
    private List<String> proficiencies;
    private List<HashMap<String,Object>> proficiency_choices;
    private List<HashMap<String,Object>> saving_throws;
    private HashMap<String, Object> spellcasting;
    private List<String> starting_equipment;
    private List<String> subclasses;

    public classes(){};
    public classes(String name, int hit_die, String index, List<String> proficiencies, List<HashMap<String, Object>> proficiency_choices, List<HashMap<String,Object>> saving_throws, HashMap<String, Object> spellcasting, List<String> starting_equipment, List<String> subclasses) {
        this.name = name;
        this.hit_die = hit_die;
        this.index = index;
        this.proficiencies = proficiencies;
        this.proficiency_choices = proficiency_choices;
        this.saving_throws = saving_throws;
        this.spellcasting = spellcasting;
        this.starting_equipment = starting_equipment;
        this.subclasses = subclasses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHit_die() {
        return hit_die;
    }

    public String getHit_dieAsString() { return Integer.toString(hit_die); }

    public void setHit_die(int hit_die) {
        this.hit_die = hit_die;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public List<String> getProficiencies() {
        return proficiencies;
    }

    public String getProficienciesAsString() {
        String temp = "";
        for (String i : proficiencies) {
            temp += i + "\n";
        }
        temp = temp.trim();
        return temp;
    }

    public void setProficiencies(List<String> proficiencies) {
        this.proficiencies = proficiencies;
    }

    public List<HashMap<String, Object>> getProficiency_choices() {
        return proficiency_choices;
    }

    public String getProficiency_choicesAsString() {
        String temp = "";
        for (HashMap<String,Object> i : proficiency_choices) {
            temp += i.get("desc" + ":\n\n");
            HashMap<String, Object> from = (HashMap<String, Object>) i.get("from");
            List<HashMap<String,Object>> options = (List<HashMap<String,Object>>) from.get("options");
            for (HashMap<String,Object> j : options) {
                HashMap<String,String> item = (HashMap<String, String>) j.get("item");
                temp += item.get("name" + "\n");
            }
        }

        return temp;
    }

    public void setProficiency_choices(List<HashMap<String, Object>> proficiency_choices) {
        this.proficiency_choices = proficiency_choices;
    }

    public List<HashMap<String,Object>> getSaving_throws() {
        return saving_throws;
    }

    public String getSaving_throwsAsString() {
        String temp = "";
        for (HashMap<String,Object> i : saving_throws) {
            temp += i.get("name") + "\n";
        }
        return temp;
    }

    public void setSaving_throws(List<HashMap<String,Object>> saving_throws) {
        this.saving_throws = saving_throws;
    }

    public HashMap<String, Object> getSpellcasting() {
        return spellcasting;
    }

    public void setSpellcasting(HashMap<String, Object> spellcasting) {
        this.spellcasting = spellcasting;
    }

    public List<String> getStarting_equipment() {
        return starting_equipment;
    }

    public void setStarting_equipment(List<String> starting_equipment) {
        this.starting_equipment = starting_equipment;
    }

    public List<String> getSubclasses() {
        return subclasses;
    }

    public void setSubclasses(List<String> subclasses) {
        this.subclasses = subclasses;
    }
}
