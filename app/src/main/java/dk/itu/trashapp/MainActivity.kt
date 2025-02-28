package dk.itu.trashapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var itemsDB: ItemsDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        itemsDB = ItemsDB.get()
        setUpFragments()
    }

    private fun setUpFragments(){
        val fm = supportFragmentManager
        var fragmentUI : Fragment? = fm.findFragmentById(R.id.container_ui)
        if(fragmentUI == null) {
            fragmentUI = SearchUIFragment()
            fm.beginTransaction()
                .add(R.id.container_ui, fragmentUI)
                .commit()
        }
    }
}