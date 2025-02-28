package dk.itu.trashapp

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 * Use the [SearchUIFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchUIFragment : Fragment() {
    private lateinit var itemsDB: ItemsDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        itemsDB = ItemsDB.get()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val v = inflater.inflate(R.layout.fragment_ui, container, false)

        val itemWhat: TextView = v.findViewById(R.id.what_text)
        val itemWhere: TextView = v.findViewById(R.id.where_text)

        val whereButton: Button = v.findViewById(R.id.where_button)
        whereButton.setOnClickListener {
            val what = itemWhat.text.toString().trim()
            itemWhat.setBackgroundColor(Color.parseColor("#FFFFFF"))
            itemWhere.text = itemsDB.search(what)
            itemWhat.onEditorAction(EditorInfo.IME_ACTION_DONE);
            itemWhere.onEditorAction(EditorInfo.IME_ACTION_DONE);
        }

        return v
    }

}