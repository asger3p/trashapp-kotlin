package dk.itu.trashapp;

import java.util.HashMap;
import java.util.Map;

public class ItemsDB {

    private static ItemsDB sItemsDB;
    private final Map<String, String> itemsMap = new HashMap<>();

    private ItemsDB() {
        fillItemsDB();

    }
    public static ItemsDB get(){
        if(sItemsDB==null) sItemsDB = new ItemsDB();
        return sItemsDB;
    }


    public String listItems() {
        String r = "";
        for (HashMap.Entry <String, String> item: itemsMap.entrySet()) {
            r = r + "\n" + item.getKey() + " in: " + item.getValue();
        }
        return r;
    }

    // Will be used later
    public void addItem(String what, String where){
        itemsMap.put(what, where);
    }

    public void fillItemsDB() {
        itemsMap.put("carrot", "food");
    }
    public String search(String what){
        return itemsMap.getOrDefault(what, "not found");
    }
}
