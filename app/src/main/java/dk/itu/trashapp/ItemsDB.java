package dk.itu.trashapp;

import java.util.ArrayList;
import java.util.List;

public class ItemsDB {
    private List<Item> ItemsDB = new ArrayList<>();

    public ItemsDB() { }

    public String listItems() {
        String r = "";
        for(Item i: ItemsDB)
            r = r + "\n Buy " + i.toString();
        return r;
    }

    // Will be used later
    public void addItem(String what, String where){
        ItemsDB.add(new Item(what, where));
    }

    public void fillItemsDB() {
        ItemsDB.add(new Item("carrot", "food"));
    }
}
