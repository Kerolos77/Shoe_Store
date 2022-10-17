package com.udacity.shoestore.screens.shoe_list

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeItemLayoutBinding
import com.udacity.shoestore.models.Shoe

class ShoeItem : LinearLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

        private val binding: ShoeItemLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.shoe_item_layout, this, true)

    fun setShoe(shoe: Shoe) {
        binding.shoe = shoe
    }
}