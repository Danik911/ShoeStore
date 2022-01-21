package com.udacity.shoestore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ActivityViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    var newShoeName = ""
    var newShoeSize = ""
    var newCompanyName = ""
    var newShoeDescription = ""

    init {
        _shoeList.value = mutableListOf()
    }

    fun resetShoeItem(){
        newShoeName = ""
        newShoeSize = ""
        newCompanyName = ""
        newShoeDescription = ""
    }
    fun addNewShoe(): Boolean {

        if (!isValidData()) return false

        addShoe(
            newShoeName,
            newShoeSize.toDouble(),
            newCompanyName,
            newShoeDescription
        )

        return true
    }


    private fun addShoe(name: String, size: Double, company: String, description: String) {
        val shoe = Shoe(name, size, company, description)
        _shoeList.value!!.add(shoe)
    }

    private fun isValidData(): Boolean {

        if (newShoeName.isBlank() ||
            newCompanyName.isBlank() ||
            newShoeSize.isBlank()  ||
            newShoeDescription.isBlank()) {
            return false
        }

        return true
    }


}