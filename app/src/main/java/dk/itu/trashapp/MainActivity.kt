package dk.itu.trashapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ItemsDB.setContext(this@MainActivity)
        itemsDB = ItemsDB.get()


        val items = findViewById<TextView>(R.id.items)
        val inputText = findViewById<EditText>(R.id.edit_text)
        val listItems = findViewById<Button>(R.id.where_button)

        listItems.setOnClickListener {
            items.setBackgroundColor(Color.parseColor("#FFFFFF"))
            val a = "Trash List:" + "\n" + itemsDB!!.search(
                inputText.text.toString().trim { it <= ' ' }
                    .lowercase(Locale.getDefault()))
            items.text = a
        }

        val addItem = findViewById<Button>(R.id.goTo_addItem_button)

        addItem.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                addItemActivity::class.java
            )
            startActivity(intent)
        }
    }

    companion object {
        private var itemsDB: ItemsDB? = null
    }
}