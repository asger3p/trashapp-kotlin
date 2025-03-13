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
import androidx.lifecycle.ViewModelProvider

/**
 * A simple [Fragment] subclass.
 * Use the [SearchUIFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchUIFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val v = inflater.inflate(R.layout.fragment_ui, container, false)
        val viewModel = ViewModelProvider(requireActivity())[TrashViewModel::class.java]

        val itemWhat: TextView = v.findViewById(R.id.what_text)
        val itemWhere: TextView = v.findViewById(R.id.where_text)

        val findItems: Button = v.findViewById(R.id.find_button)
        val addItem: Button = v.findViewById(R.id.add_button)
        val deleteItem: Button = v.findViewById(R.id.delete_button)

        addItem.setOnClickListener {
            activity?.let { fragmentActivity ->
                viewModel.onAddItemClick(
                    itemWhat,
                    itemWhere,
                    fragmentActivity
                )
            }
        }

        // deleting a thing
        deleteItem.setOnClickListener {
            activity?.let { fragmentActivity ->
                viewModel.onDeleteItemClick(itemWhat, fragmentActivity)
            }
        }

        // finding a thing
        findItems.setOnClickListener {
            viewModel.onFindItemClick(itemWhat, itemWhere)
        }

        return v
    }
}