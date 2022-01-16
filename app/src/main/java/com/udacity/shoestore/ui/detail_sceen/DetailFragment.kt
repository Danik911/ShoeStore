package com.udacity.shoestore.ui.detail_sceen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.databinding.FragmentListBinding
import com.udacity.shoestore.ui.ActivityViewModel
import com.udacity.shoestore.ui.listing_screen.ListFragment


class DetailFragment : androidx.fragment.app.Fragment() {

    private val viewModel: ActivityViewModel by activityViewModels()
    private lateinit var binding: FragmentDetailBinding
    lateinit var shoeItem: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail,
            container,
            false
        )
        //Get the viewModel


        //Set bound viewModel and layout via dataBinding
        binding.activityViewModel =viewModel
        binding.lifecycleOwner = this



        binding.btnAdd.setOnClickListener {
            findNavController()
                .navigate(DetailFragmentDirections.actionDetailFragmentToListFragment())
            addNewItem()


        }



            return binding.root
    }
    private fun addNewItem(){
        viewModel.saveNewItem(
            binding.tvName.toString(),
            binding.tvSize.toString(),
            binding.tvCompany.toString(),
            binding.tvDescription.toString()
        )
    }
    fun addNewItemLayout(view: FragmentListBinding, binding: FragmentDetailBinding) {
        shoeItem = binding.shoeItemsList
        view.shoeList.addView(shoeItem)
    }



}