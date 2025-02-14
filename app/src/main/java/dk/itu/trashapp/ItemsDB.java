package dk.itu.trashapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ItemsDB {

    private static ItemsDB sItemsDB;
    private final Map<String, String> itemsMap = new HashMap<>();

    private ItemsDB() throws IOException {
        fillItemsDB();
    }
    public static ItemsDB get() throws IOException {
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
    public void addItem(String what, String where) throws IOException {
        if(!search(what).equals("not found")){
            String item = "\n" + what + ", " + where;
            var writer = new BufferedWriter(new FileWriter("assets/garbage.txt", true));
            writer.write(item);
            itemsMap.put(what, where);
        } else {
            return;
        }
    }

    public void fillItemsDB() throws IOException {
        var reader = new BufferedReader(new FileReader("assets/garbage.txt"));
        while(!reader.readLine().isEmpty()) {
            String input = reader.readLine();
            String[] item = input.split(", ");
            itemsMap.put(item[0], item[1]);
        }
    }

    public String search(String what){
        return itemsMap.getOrDefault(what, "not found");
    }
}
