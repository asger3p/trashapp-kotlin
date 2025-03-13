package dk.itu.trashapp

import dk.itu.trashapp.ItemsDB.Companion.get
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.IOException

class TestItemsDB {
  /*  private var myItemsDB: ItemsDB? = null

    @Before
    @Throws(IOException::class)
    fun setUp() {
        myItemsDB = get()
    }

    @Test
    @Throws(IOException::class)
    fun get_MultipleCalls_ReturnsSameInstance() {
        val instance1 = get()
        val instance2 = get()
        Assert.assertSame(instance1, instance2)
    }

    @Test
    @Throws(IOException::class)
    fun addItem_WhenAddingItem_ItemDBIsUpdated() {
        val what = "bottle"
        val where = "recycling"
        myItemsDB!!.addItem(what, where)
        Assert.assertEquals(where, myItemsDB!!.search(what))
    }

    @Test
    fun search_WhenParamNotInDB_ReturnsNotFound() {
        val searchResult = myItemsDB!!.search("")
        Assert.assertEquals("not found", searchResult)
    }

    @Test
    @Throws(IOException::class)
    fun search_WhenKeyExists_ReturnsNotFound() {
        myItemsDB!!.addItem("carrot", "food")
        val searchResult = myItemsDB!!.search("carrot")
        Assert.assertEquals("food", searchResult)
    }

    */
}
