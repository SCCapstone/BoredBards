package com.example.bored_bard.encyclopedia;

public class abiliyScores<T> {
    private String description[];
    private String fullName;
    private String index;
    private String name;
    private T[] skills;

    public String[] getDescription() {
        return description;
    }

    public void setDescription(String[] description) {
        this.description = description;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public T[] getSkills() {
        return skills;
    }

    public void setSkills(T[] skills) {
        this.skills = skills;
    }
}
