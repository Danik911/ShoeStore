package com.udacity.shoestore.ui.listing_screen

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentListBinding
import com.udacity.shoestore.ui.ActivityViewModel
import com.udacity.shoestore.ui.detail_sceen.DetailFragment


class ListFragment : Fragment() {

    private val viewModel: ActivityViewModel by activityViewModels()
    private lateinit var binding: FragmentListBinding






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list,
            container,
            false
        )

        binding.fabEditItem.setOnClickListener {
            findNavController()
                .navigate(ListFragmentDirections.actionListFragmentToDetailFragment())

        }

        viewModel.shoeList.observe(viewLifecycleOwner) { shoeList ->

            for (shoe in shoeList) {
                val textView = TextView(context)
                textView.text = shoe.name
                binding.shoeList.addView(textView)
            }
        }

        return binding.root

    }

}