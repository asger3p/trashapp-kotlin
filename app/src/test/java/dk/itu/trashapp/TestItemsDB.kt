package dk.itu.trashapp;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.io.IOException;

public class TestItemsDB {
    private ItemsDB myItemsDB;

    @Before
    public void setUp() throws IOException {
        myItemsDB = ItemsDB.get();
    }

    @Test
    public void get_MultipleCalls_ReturnsSameInstance() throws IOException{
        ItemsDB instance1 = ItemsDB.get();
        ItemsDB instance2 = ItemsDB.get();
        assertSame(instance1, instance2);
      }

    @Test
    public void addItem_WhenAddingItem_ItemDBIsUpdated() throws IOException {
        String what = "bottle";
        String where = "recycling";
        myItemsDB.addItem(what, where);
        assertEquals(where, myItemsDB.search(what));
    }

    @Test
    public void search_WhenParamNotInDB_ReturnsNotFound(){
        String searchResult = myItemsDB.search("");
        assertEquals("not found", searchResult);
    }

    @Test
    public void search_WhenKeyExists_ReturnsNotFound() throws IOException{
        myItemsDB.addItem("carrot", "food");
        String searchResult = myItemsDB.search("carrot");
        assertEquals("food", searchResult);
    }

}
