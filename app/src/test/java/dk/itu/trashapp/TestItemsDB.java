package dk.itu.trashapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestItemsDB {

    @Test
    public void searchReturnsNotFoundWhenParamNotInDB(){
        ItemsDB myItemsDB = new ItemsDB();
        assertEquals("not found", myItemsDB.search(""));
    }

    @Test
    public void searchReturnsValueWhenKeyExists(){
        ItemsDB testItemsDB = new ItemsDB();
        testItemsDB.addItem("carrot", "food");
        assertEquals("food", testItemsDB.search("carrot"));
    }
}
