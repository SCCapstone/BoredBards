package com.example.bored_bard.encyclopedia;

import java.util.HashMap;
import java.util.List;

public class equipment {

    private List<String> desc;
    private HashMap<String, String> cost;
    private String index;
    private String name;
    private HashMap<String, String> equipment_category;
    private HashMap<String, String> gear_category;
    private String url;
    private float weight;


    public equipment(){};
    public equipment(List<String> desc, HashMap<String, String> cost, String index, String name, HashMap<String, String> equipment_category, HashMap<String, String> gear_category, String url, float weight) {
        this.desc = desc;
        this.cost = cost;
        this.index = index;
        this.name = name;
        this.equipment_category = equipment_category;
        this.gear_category = gear_category;
        this.url = url;
        this.weight = weight;
    }

    public String getDesc() {
        String descString = "";
        if (desc == null) {return "N/A";}
        for (String i : desc) {
            descString += i + "\n\n";
        }
        descString = descString.trim();
        return descString;
    }

    public void setDesc(List<String> desc) {
        this.desc = desc;
    }

    public HashMap<String, String> getCost() {
        return cost;
    }

    public String getCostString() {
        if (cost == null) { return "N/A";}
        else { return cost.get("quantity") + " " + cost.get("unit"); }
    }

    public void setCost(HashMap<String, String> cost) {
        this.cost = cost;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<String, String> getequipment_category() {
        return equipment_category;
    }

    public String getequipment_categoryAsString() {
        if (equipment_category != null) { return equipment_category.get("name"); }
        else { return "No Equipment Category"; }
    }

    public void setequipment_category(HashMap<String, String> equipment_category) {
        this.equipment_category = equipment_category;
    }

    public HashMap<String, String> getgear_category() {
        return gear_category;
    }

    public String getgear_categoryAsString() {
        if (gear_category != null) { return gear_category.get("name"); }
        else { return "No Gear Category"; }
    }

    public void setgear_category(HashMap<String, String> gear_category) {
        this.gear_category = gear_category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getWeight() {
        return weight;
    }

    public String getWeightAsString() {
        return String.valueOf(weight);
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
