package com.example.bored_bard.encyclopedia;

import java.util.HashMap;
import java.util.List;

public class abilityScores {
    private List<String> desc;
    private String full_name;
    private String index;
    private String name;
    private List<HashMap<String, String>> skills;
    private String url;


    public abilityScores(){};

    public abilityScores(List<String> desc, String full_name, String index, String name, List<HashMap<String, String>> skills, String url) {
        this.desc = desc;
        this.full_name = full_name;
        this.index = index;
        this.name = name;
        this.skills = skills;
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

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
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

    public String skillsToString() {
        String skillsString = "";

        if (skills.isEmpty()) { return "None";}

        for (HashMap<String,String> i : skills) {
            skillsString += i.get("name") + "\n";
        }
        skillsString = skillsString.trim();
        return skillsString;
    }
    public List<HashMap<String,String>> getSkills() { return skills; }

    public void setSkills(List<HashMap<String,String>> skills) {
        this.skills = skills;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
