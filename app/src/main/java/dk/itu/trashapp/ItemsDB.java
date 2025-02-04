package dk.itu.trashapp;

import java.util.ArrayList;
import java.util.List;

public class ItemsDB {

    private static ItemsDB sItemsDB;
    private List<Item> itemsDB = new ArrayList<>();

    public ItemsDB() {
        fillItemsDB();
    }
    public static ItemsDB get(){
        if(sItemsDB==null) sItemsDB = new ItemsDB();
        return sItemsDB;
    }

    public String listItems() {
        String r = "";
        for(Item i: itemsDB)
            r = r + "\n" + i.toString();
        return r;
    }

    // Will be used later
    public void addItem(String what, String where){
        itemsDB.add(new Item(what, where));
    }

    public void fillItemsDB() {
        itemsDB.add(new Item("carrot", "food"));
    }
    public String search(String what){
        for (Item item: itemsDB){
            if(item.getWhat().equals(what)){
                return item.getWhere();
            }
        }
        return "not found";
    }
}
