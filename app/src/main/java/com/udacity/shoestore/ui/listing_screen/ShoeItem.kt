package com.udacity.shoestore.ui.listing_screen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.udacity.shoestore.R

class ShoeItem(context: Context?) {

    var view: View = LayoutInflater.from(context).inflate(R.layout.list_item, null, false)
}