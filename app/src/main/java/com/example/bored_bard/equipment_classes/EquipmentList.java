package com.example.bored_bard.equipment_classes;

import java.util.ArrayList;

/**
 * @author Charles Simons - csimons637
 */
public class EquipmentList {
    private ArrayList<Equipment> items = new ArrayList<Equipment>();

    /**
     * Gets an item from the list of items
     * @param index - Index of the item to be retrieved
     * @return - The item specified by 'index'
     */
    public Equipment getItem(int index) {
        Equipment item = items.get(index);
        return item;
    }

    /**
     * Returns an equipment list for the user to select from
     * @return - A list of equipment
     */
    public ArrayList<String> displayEquipment() {
        ArrayList<String> display = new ArrayList<String>();
        for (Equipment e : items) {
            display.add(e.getName());
        }
        return display; // doesn't print the list, just creates and populates it
    }
}
