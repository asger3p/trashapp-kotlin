package dk.itu.trashapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity() {

    private lateinit var itemsDB: ItemsDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ItemsDB.setContext(this@MainActivity)
        itemsDB = ItemsDB.get()
        setUpFragments()
    }

    private fun setUpFragments(){
        val fm = supportFragmentManager
        var fragmentUI : Fragment? = fm.findFragmentById(R.id.container_ui)
        var fragmentList : Fragment? = fm.findFragmentById(R.id.container_list)
        if(fragmentUI == null && fragmentList == null) {
            fragmentUI = SearchUIFragment()
            fragmentList = ListFragment()
            fm.beginTransaction()
                .add(R.id.container_ui, fragmentUI)
                .add(R.id.container_list, fragmentList)
                .commit()
        }
    }
}