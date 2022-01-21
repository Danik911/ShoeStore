package com.udacity.shoestore.ui.listing_screen

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentListBinding
import com.udacity.shoestore.ui.ActivityViewModel
import kotlinx.android.synthetic.main.list_item.view.*


class ListFragment : Fragment() {

    private val viewModel: ActivityViewModel by activityViewModels()
    private val binding by lazy {
        FragmentListBinding.inflate(layoutInflater)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        viewModel.shoeList.observe(viewLifecycleOwner) {
            binding.shoeList.removeAllViews()
            for (shoe in it) {
                addShoe(shoe.name)
            }
        }

        binding.fabEditItem.setOnClickListener {
            it.findNavController().navigate(
               ListFragmentDirections.actionListFragmentToDetailFragment()
            )
        }

        setHasOptionsMenu(true)


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_list_fragment, menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.mi_logout ->
                findNavController().navigate(ListFragmentDirections.actionListFragmentToLoginFragment())
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addShoe(shoeName: String) {
        val view = layoutInflater.inflate(R.layout.list_item, null)
        view.tv_item_name.text = shoeName
        binding.shoeList.addView(view.tv_item_name)
    }

}