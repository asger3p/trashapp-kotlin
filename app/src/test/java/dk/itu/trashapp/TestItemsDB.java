package dk.itu.trashapp;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class TestItemsDB {

    private ItemsDB myItemsDB;

    @Before
    public void setUp(){
    myItemsDB = new ItemsDB();
    }

    @Test
    public void search_WhenParamNotInDB_ReturnsNotFound(){

        String searchResult = myItemsDB.search("");
        assertEquals("not found", searchResult);
    }

    @Test
    public void search_WhenKeyExists_ReturnsNotFound(){
        myItemsDB.addItem("carrot", "food");
        String searchResult = myItemsDB.search("carrot");
        assertEquals("food", searchResult);
    }
}
