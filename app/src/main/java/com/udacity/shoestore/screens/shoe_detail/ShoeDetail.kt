package com.udacity.shoestore.screens.shoe_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.view_model.ShoeViewModel
import kotlinx.android.synthetic.main.fragment_shoe_detail.*

class ShoeDetail :Fragment() {
    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: ShoeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.cancelButton.setOnClickListener { view: View ->
            cancel()
            findNavController().navigateUp()
//            view.findNavController().navigate(ShoeDetailDirections.actionShoeDetailToShoeListFragment())
        }
        binding.saveButton.setOnClickListener { view: View ->
            save()
            findNavController().navigateUp()
//            view.findNavController().navigate(ShoeDetailDirections.actionShoeDetailToShoeListFragment())
        }
        return binding.root
    }

    private fun cancel() {
        binding.apply {
            shoe_name_EditText.text=null
            shoe_company_EditText.text=null
            shoe_size_EditText.text=null
            shoe_description_EditText.text=null
        }
    }
    private fun save() {
        val shoe:Shoe= Shoe(
            binding.shoeNameEditText.text.toString(),
            binding.shoeSizeEditText.text.toString().toDouble(),
            binding.shoeCompanyEditText.text.toString(),
            binding.shoeDescriptionEditText.text.toString())
        viewModel.addShoe(shoe)
    }
}