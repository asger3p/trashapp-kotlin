package dk.itu.trashapp;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

public class TestItemsDB {
    private final Map<String,String> myItemsMap = new HashMap<>();
    private ItemsDB myItemsDB;

    @Before
    public void setUp(){
        myItemsDB = ItemsDB.get();
    }

    @Test
    public void get_WhenItemsDBisCalled_returnsSingleton() {
        ItemsDB test = ItemsDB.get();
        test.addItem("cucumber", "food");
        String expected = "food";
        String actual = test.search("cucumber");
        assertEquals(expected, actual);
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
