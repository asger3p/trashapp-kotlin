package dk.itu.trashapp

import android.content.Context
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class ItemsDB private constructor() {
    private val itemsMap: MutableMap<String, String> = HashMap()

    init {
        checkNotNull(context) { "context must be set first" }
        try {
            fillItemsDB(context!!, "garbage.txt")
        } catch (ioe: IOException) {
            println(ioe.message)
        }
    }

    fun listItems(): String {
        var r = ""
        for ((key, value) in itemsMap) {
            r = """$r
$key in: $value"""
        }
        return r
    }

    // Will be used later
    fun addItem(what: String, where: String) {
        itemsMap[what] = where
    }

    fun removeItem(what: String) {
        itemsMap.remove(what)
    }

    fun isPresent(what: String): Boolean {
        return itemsMap[what] != null
    }

    @Throws(IOException::class)
    fun fillItemsDB(context: Context, path: String) {
        try {
            val reader = BufferedReader(InputStreamReader(context.assets.open(path)))
            var input = reader.readLine()
            while (input != null) {
                val item = input.split(", ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                itemsMap[item[0]] = item[1]
                input = reader.readLine()
            }
        } catch (ioe: IOException) {
            println(ioe.message)
        }
    }

    fun search(what: String): String? {
        return itemsMap.getOrDefault(what, "not found")
    }

    companion object {
        private var sItemsDB: ItemsDB? = null
        private var context: Context? = null

        @JvmStatic
        fun get(): ItemsDB {
            if (sItemsDB == null) sItemsDB = ItemsDB()
            return sItemsDB!!
        }


        fun setContext(newContext: Context?) {
            context = newContext
        }
    }
}
