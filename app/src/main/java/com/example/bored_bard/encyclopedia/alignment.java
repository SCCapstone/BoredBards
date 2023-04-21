package com.example.bored_bard.encyclopedia;

public class alignment {
    private String abbreviation;
    private String desc;
    private String index;
    private String name;
    private String url;

    public alignment(){};

    public alignment(String abbreviation, String desc, String index, String name, String url) {
        this.abbreviation = abbreviation;
        this.desc = desc;
        this.index = index;
        this.name = name;
        this.url = url;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
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
