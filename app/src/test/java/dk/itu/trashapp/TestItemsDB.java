package dk.itu.trashapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestItemsDB {

    @Test
    public void searchReturnsNotFoundWhenParamNotInDB(){
        ItemsDB myItemsDB = new ItemsDB();
        assertEquals("not found", myItemsDB.search(""));
    }
}
