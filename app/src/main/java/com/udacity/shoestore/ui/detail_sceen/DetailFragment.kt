package com.udacity.shoestore.ui.detail_sceen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.ui.ActivityViewModel


class DetailFragment : androidx.fragment.app.Fragment() {

    private val viewModel: ActivityViewModel by activityViewModels()
    private val binding by lazy {
        FragmentDetailBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.resetShoeItem()

        //Bound viewModel and layout via dataBinding
        binding.activityViewModel = viewModel
        binding.lifecycleOwner = this



        binding.btnAdd.setOnClickListener {

            if (viewModel.addNewShoe()){
                findNavController()
                    .navigate(DetailFragmentDirections.actionDetailFragmentToListFragment())

            } else {
                Snackbar.make(
                    requireView(),
                    "Please fill the fields",
                    Snackbar.LENGTH_LONG)
                    .show()
            }



        }
        binding.btnCancel.setOnClickListener {
            it.findNavController().navigate(
                DetailFragmentDirections.actionDetailFragmentToListFragment()
            )
        }

        return binding.root
    }


}