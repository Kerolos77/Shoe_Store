package com.udacity.shoestore.screens.shoe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.databinding.ShoeItemLayoutBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.view_model.ShoeViewModel

class ShoeList : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private val viewModel: ShoeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
//        var ListOfShoes: MutableList<Shoe> = viewModel.shoeList.value!!
//        addShoeToList(ListOfShoes)
        viewModel.shoeList.observe(viewLifecycleOwner) { shoeList ->
            addShoeToList(shoeList)
        }

        binding.floatingActionButton.setOnClickListener{view : View ->
            Navigation.findNavController(view).navigate(ShoeListDirections.actionShoeListFragmentToShoeDetail())
        }

        return binding.root
    }
    fun addShoeToList(shoes: List<Shoe>) {
        context?.let { context ->
            val listScreen = binding.shoeList
            shoes.forEach {
                val shoeItem = ShoeItem(context)
                shoeItem.setShoe(it)
                listScreen.addView(shoeItem)
            }
        }
    }
}