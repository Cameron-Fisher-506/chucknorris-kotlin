package com.example.chucknorris.view.menu.favourites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.chucknorris.R
import com.example.chucknorris.databinding.FavouritesFragmentBinding
import com.example.chucknorris.model.FavouriteJoke
import kotlinx.android.synthetic.main.joke_list_fragment.*


class FavouritesFragment : Fragment(R.layout.favourites_fragment) {

    private lateinit var binding: FavouritesFragmentBinding
    private lateinit var favouritesViewModel: FavouritesViewModel
    private lateinit var favouritesListAdapter: FavouritesListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.binding = FavouritesFragmentBinding.bind(view)
        this.favouritesViewModel = ViewModelProviders.of(this).get(FavouritesViewModel::class.java)

        attachObservers()
        wireUI()
    }

    private fun attachObservers() {
        val cachedJokesObserver = Observer<List<FavouriteJoke>> {
            if (it != null) {
                displayFavouritesRecyclerView()
                this.favouritesListAdapter.updateFavouritesList(it)
            } else {
                displayErrorMessageView()
            }
        }
        this.favouritesViewModel.readAllFavouriteJokes.observe(this, cachedJokesObserver)
    }

    private fun displayFavouritesRecyclerView() {
        with(this.binding)
        {
            favouritesRecyclerView.visibility = View.VISIBLE
            errorMessageTextView.visibility = View.GONE
            favouritesProgressBar.visibility = View.GONE
        }
    }

    private fun displayErrorMessageView() {
        with(this.binding)
        {
            favouritesRecyclerView.visibility = View.GONE
            errorMessageTextView.visibility = View.VISIBLE
            favouritesProgressBar.visibility = View.GONE
        }
    }

    private fun wireUI() {
        this.favouritesListAdapter = FavouritesListAdapter(arrayListOf())
        this.binding.favouritesRecyclerView.layoutManager = GridLayoutManager(context, 1)
        this.binding.favouritesRecyclerView.adapter = this.favouritesListAdapter

        this.binding.refreshLayout.setOnRefreshListener {
            with(this.binding)
            {
                jokesRecyclerView.visibility = View.GONE
                errorMessageTextView.visibility = View.GONE
                progressBar.visibility = View.GONE
            }
        }
        this.binding.refreshLayout.isRefreshing = false
    }
}