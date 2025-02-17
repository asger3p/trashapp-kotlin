package dk.itu.trashapp;

import android.content.Context;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ItemsDB {

    private static ItemsDB sItemsDB;
    private final Map<String, String> itemsMap = new HashMap<>();
    private static Context context;

    private ItemsDB() {
        if(context == null) {
            throw new IllegalStateException("context must be set first");
        }
        try {
            fillItemsDB(context, "garbage.txt");
        } catch (IOException ioe) {
             System.out.println(ioe.getMessage());
            }
    }
    public static ItemsDB get() {
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
    public void addItem(String what, String where) {
            itemsMap.put(what, where);
    }

    public static void setContext(Context newContext) {
        context = newContext;
    }

    public void fillItemsDB(Context context, String path) throws IOException {
        try {
        var reader = new BufferedReader(new InputStreamReader(context.getAssets().open(path)));
        String input = reader.readLine();
        while (input != null) {
            String[] item = input.split(", ");
            itemsMap.put(item[0], item[1]);
            input = reader.readLine();
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }

    public String search(String what){
        return itemsMap.getOrDefault(what, "not found");
    }
}
