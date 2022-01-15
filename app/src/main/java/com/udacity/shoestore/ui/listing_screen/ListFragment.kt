package com.udacity.shoestore.ui.listing_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentListBinding


class ListFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val context = activity?.applicationContext
    }

    private lateinit var shoeListLayout: LinearLayout
    private lateinit var shoeItem: ShoeItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentListBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list,
            container,
            false
        )

        binding.fabEditItem.setOnClickListener {
            findNavController()
                .navigate(ListFragmentDirections.actionListFragmentToDetailFragment())
        }


        return binding.root

    }
    fun addNewItem(view: FragmentListBinding) {
        shoeItem = ShoeItem(context)
        view.shoeList.addView(shoeItem.view)
    }

}