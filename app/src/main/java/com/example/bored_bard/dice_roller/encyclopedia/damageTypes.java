package com.example.bored_bard.dice_roller.encyclopedia;

import java.util.List;

public class damageTypes {

    private List<String> desc;
    private String index;
    private String name;
    private String url;

    public damageTypes(){};
    public damageTypes(List<String> desc, String index, String name, String url) {
        this.desc = desc;
        this.index = index;
        this.name = name;
        this.url = url;
    }

    public String getDesc() {
        String descString = "";

        for (String i : desc) {
            descString += i + "\n\n";
        }
        descString = descString.trim();
        return descString;
    }

    public void setDesc(List<String> desc) {
        this.desc = desc;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
