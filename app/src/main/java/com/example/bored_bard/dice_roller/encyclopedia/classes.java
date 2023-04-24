package com.example.bored_bard.dice_roller.encyclopedia;

import java.util.Map;
import java.util.List;

public class classes {
    private String name;
    private int hit_die;
    private String index;
    private List<Map<String,String>> proficiencies;
    private List<Map<String,Object>> proficiency_choices;
    private List<Map<String,Object>> saving_throws;
    private Map<String, Object> spellcasting;
    private List<Map<String,Object>> starting_equipment;
    private List<Map<String,String>> subclasses;

    public classes(){};
    public classes(String name, int hit_die, String index, List<Map<String,String>> proficiencies, List<Map<String, Object>> proficiency_choices, List<Map<String,Object>> saving_throws, Map<String, Object> spellcasting, List<Map<String,Object>> starting_equipment, List<Map<String,String>> subclasses) {
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

    public List<Map<String,String>> getProficiencies() {
        return proficiencies;
    }

    public String getProficienciesAsString() {
        String temp = "";
        for (Map<String,String> i : proficiencies) {
            temp += i.get("name") + "\n";
        }
        temp = temp.trim();
        return temp;
    }

    public void setProficiencies(List<Map<String,String>> proficiencies) {
        this.proficiencies = proficiencies;
    }

    public List<Map<String, Object>> getProficiency_choices() {
        return proficiency_choices;
    }

    public String getProficiency_choicesAsString() {
        if (proficiency_choices == null) {
            return "N/A";
        }
        String temp = "";

        for (Map<String,Object> i : proficiency_choices) {
            Double choose = (Double) i.get("choose");
            temp += "Choose " + choose.intValue() + " from options listed below:\n\n";
            Map<String, Object> from = (Map<String, Object>) i.get("from");
            List<Map<String, Object>> options = (List<Map<String, Object>>) from.get("options");
            assert options != null;
            for (Map<String, Object> j : options) {
                if (j.get("option_type").equals("choice")) {
                    Map<String, Object> choice = (Map<String, Object>) j.get("choice");
                    assert choice != null;
                    temp += choice.get("desc") + ":\n";
                    Map<String, Object> fromChoice = (Map<String, Object>) choice.get("from");
                    List<Map<String, Object>> optionsFromChoice = (List<Map<String, Object>>) fromChoice.get("options");
                    for (Map<String, Object> k : optionsFromChoice) {
                        Map<String, String> item = (Map<String, String>) k.get("item");
                        assert item != null;
                        temp += item.get("name") + "\n";
                    }
                    temp += "\n";
                } else {
                    Map<String, String> item = (Map<String, String>) j.get("item");
                    assert item != null;
                    temp += item.get("name") + "\n";
                }
            }
            temp += "\n";
        }

        temp = temp.trim();
        return temp;
    }

    public void setProficiency_choices(List<Map<String, Object>> proficiency_choices) {
        this.proficiency_choices = proficiency_choices;
    }

    public List<Map<String,Object>> getSaving_throws() {
        return saving_throws;
    }

    public String getSaving_throwsAsString() {
        String temp = "";
        for (Map<String,Object> i : saving_throws) {
            temp += i.get("name") + "\n";
        }
        temp = temp.trim();
        return temp;
    }

    public void setSaving_throws(List<Map<String,Object>> saving_throws) {
        this.saving_throws = saving_throws;
    }

    public Map<String, Object> getSpellcasting() {
        return spellcasting;
    }

    public String getSpellcastingAsString() {
        if (spellcasting == null) {
            return "N/A";
        }

        String temp = "";

        Map<String,String> spellcasting_ability = (Map<String, String>) spellcasting.get("spellcasting_ability");
        temp += "Ability used to cast spells: " + spellcasting_ability.get("name") + "\n";

        List<Map<String,Object>> info = (List<Map<String, Object>>) spellcasting.get("info");
        for (Map<String,Object> i : info) {
            temp += i.get("name") + ":\n";
            List<String> desc = (List<String>) i.get("desc");
            for (String j : desc) {
                temp += j + "\n";
            }
            temp += "\n";
        }

        return temp;
    }


    public void setSpellcasting(Map<String, Object> spellcasting) {
        this.spellcasting = spellcasting;
    }

    public List<Map<String,Object>> getStarting_equipment() {
        return starting_equipment;
    }

    public String getStartingEquipmentAsString() {
        if (starting_equipment == null) {
            return "N/A";
        }

        String temp = "";

        for (Map<String, Object> i : starting_equipment) {
            Map<String,Object> equipment = (Map<String, Object>) i.get("equipment");
            Double quantity = (Double) i.get("quantity");
            temp += equipment.get("name") + "\n" + "Quantity: " + quantity.intValue() + "\n\n";
        }
        temp = temp.trim();
        return temp;
    }


    public void setStarting_equipment(List<Map<String,Object>> starting_equipment) {
        this.starting_equipment = starting_equipment;
    }

    public List<Map<String,String>> getSubclasses() {
        return subclasses;
    }

    public String getSubclassesAsString() {
        if (subclasses == null) {
            return "N/A";
        }

        String temp = "";

        for (Map<String,String> i : subclasses) {
            temp += i.get("name") + "\n";
        }
        temp = temp.trim();
        return temp;
    }

    public void setSubclasses(List<Map<String,String>> subclasses) {
        this.subclasses = subclasses;
    }
}
