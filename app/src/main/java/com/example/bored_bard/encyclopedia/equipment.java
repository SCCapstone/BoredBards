package com.example.bored_bard.encyclopedia;

import java.util.HashMap;
import java.util.List;

public class equipment {

    private List<String> desc;
    private HashMap<String, String> cost;
    private String index;
    private String name;
    private HashMap<String, String> equipmentCategory;
    private HashMap<String, String> gearCategory;
    private String url;
    private int weight;


    public equipment(){};
    public equipment(List<String> desc, HashMap<String, String> cost, String index, String name, HashMap<String, String> equipmentCategory, HashMap<String, String> gearCategory, String url, int weight) {
        this.desc = desc;
        this.cost = cost;
        this.index = index;
        this.name = name;
        this.equipmentCategory = equipmentCategory;
        this.gearCategory = gearCategory;
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

    public HashMap<String, String> getEquipmentCategory() {
        return equipmentCategory;
    }

    public String getEquipmentCategoryAsString() {
        if (equipmentCategory != null) { return equipmentCategory.get("name"); }
        else { return "No Equipment Category"; }
    }

    public void setEquipmentCategory(HashMap<String, String> equipmentCategory) {
        this.equipmentCategory = equipmentCategory;
    }

    public HashMap<String, String> getGearCategory() {
        return gearCategory;
    }

    //TODO: figure out why Gear and Equipment variables are returning as null
    public String getGearCategoryAsString() {
        if (gearCategory != null) { return gearCategory.get("name"); }
        else { return "No Gear Category"; }
    }

    public void setGearCategory(HashMap<String, String> gearCategory) {
        this.gearCategory = gearCategory;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getWeight() {
        return weight;
    }

    public String getWeightAsString() {
        return String.valueOf(weight);
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
