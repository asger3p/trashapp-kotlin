package dk.itu.trashapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dk.itu.trashapp.ItemsDB.Companion.get
import java.util.Locale

class addItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_additem)

        itemsDB = get()

        val whatItemText = findViewById<TextView>(R.id.what_text)
        val whereItemText = findViewById<TextView>(R.id.where_text)

        val addItemButton = findViewById<Button>(R.id.add_item_button)

        addItemButton.setOnClickListener { view: View? ->
            val whatText = whatItemText.text.toString().trim { it <= ' ' }
                .lowercase(Locale.getDefault())
            val whereText = whereItemText.text.toString().trim { it <= ' ' }
                .lowercase(Locale.getDefault())
            if ((!whatText.isEmpty()) && (!whereText.isEmpty())) {
                itemsDB!!.addItem(whatText, whereText)

                whatItemText.text = ""
                whereItemText.text = ""
            } else Toast.makeText(
                this@addItemActivity,
                R.string.empty_toast,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    companion object {
        private var itemsDB: ItemsDB? = null
    }
}
