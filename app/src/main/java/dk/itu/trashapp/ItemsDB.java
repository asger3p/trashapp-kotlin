package dk.itu.trashapp;

import java.util.ArrayList;
import java.util.List;

public class ItemsDB {
    private List<Item> ItemsDB = new ArrayList<>();

    public ItemsDB() { }

    public String listItems() {
        String r = "";
        for(Item i: ItemsDB)
            r = r + "\n" + i.toString();
        return r;
    }

    // Will be used later
    public void addItem(String what, String where){
        ItemsDB.add(new Item(what, where));
    }

    public void fillItemsDB() {
        ItemsDB.add(new Item("carrot", "food"));
    }
    public String search(String what){
        for (Item item: ItemsDB){
            if(item.getWhat().equals(what)){
                return item.getWhere();
            }
        }
        return "not found";
    }
}
