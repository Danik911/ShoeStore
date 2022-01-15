package com.udacity.shoestore.ui.detail_sceen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: FragmentDetailBinding

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
        viewModel = ViewModelProvider(this)[DetailViewModel::class.java]

        //Set bound viewModel and layout via dataBinding
        binding.detailViewModel =viewModel
        binding.lifecycleOwner = this



        binding.btnAdd.setOnClickListener {
            findNavController()
                .navigate(DetailFragmentDirections.actionDetailFragmentToListFragment())
        }



            return binding.root
    }

}