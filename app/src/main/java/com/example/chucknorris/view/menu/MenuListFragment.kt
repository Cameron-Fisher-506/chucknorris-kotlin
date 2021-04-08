package com.example.chucknorris.view.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.chucknorris.R
import com.example.chucknorris.databinding.MenuListFragmentBinding

class MenuListFragment : Fragment(R.layout.menu_list_fragment) {

    private lateinit var binding: MenuListFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.binding = MenuListFragmentBinding.bind(view)

        wireUI()
    }

    private fun wireUI() {
        this.binding.favouritesConstraintLayout.setOnClickListener {
            val action = MenuListFragmentDirections.actionMenuListFragmentToFavouritesFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

}