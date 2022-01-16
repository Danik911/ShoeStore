package com.udacity.shoestore.ui

import android.widget.EditText
import androidx.databinding.InverseMethod
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ActivityViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val _shoeItem = MutableLiveData<Shoe>()
    val shoeItem: LiveData<Shoe>
        get() = _shoeItem

    private val _shoeName = MutableLiveData<String>()
    val shoeName: LiveData<String>
        get() = _shoeName

    init {
        _shoeName.value = "Nike"
        _shoeItem.value = Shoe("", "0.0", "", "")
        _shoeList.value = mutableListOf()
    }

    fun saveNewItem(name: String, size: String, company: String, description: String) {
        val newItem = Shoe(
            name,
            size,
            company,
            description
        )
        _shoeItem.value = newItem
        newItem.let { shoeList.value?.add(it) }
    }

}