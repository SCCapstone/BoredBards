package com.example.bored_bard.dice_roller.encyclopedia;

public class defaultCollectionNameClass {
    private String[] Names;


    public defaultCollectionNameClass(){};
    public defaultCollectionNameClass(String[] Names) {
        this.Names = Names;
    }

    public String[] getNames() {
        return Names;
    }

    public void setNames(String[] Names) {
        this.Names = Names;
    }
}
