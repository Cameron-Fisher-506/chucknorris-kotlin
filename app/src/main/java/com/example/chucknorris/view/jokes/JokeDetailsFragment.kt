package com.example.chucknorris.view.jokes

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.chucknorris.R
import com.example.chucknorris.databinding.JokeDetailsFragmentBinding
import com.example.chucknorris.enum.Status
import com.example.chucknorris.model.models.FavouriteJoke
import com.example.chucknorris.utils.GeneralUtils
import com.example.chucknorris.utils.Resource
import com.example.chucknorris.view.menu.favourites.FavouritesViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class JokeDetailsFragment : Fragment(R.layout.joke_details_fragment) {

    private lateinit var binding: JokeDetailsFragmentBinding
    private lateinit var favouritesViewModel: FavouritesViewModel
    private var isAddedToFavourites: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.binding = JokeDetailsFragmentBinding.bind(view)
        this.favouritesViewModel = ViewModelProviders.of(this).get(FavouritesViewModel::class.java)

        arguments?.let { wireUI(it) }
        attachObservers()
    }

    private fun attachObservers() {
        val findByValueObserver = Observer<Resource<FavouriteJoke>> {
            displayFavouriteJoke()
            when (it.status) {
                Status.SUCCESS -> {
                    isAddedToFavourites = true
                    binding.favouriteImageButton.setImageResource(R.drawable.ic_baseline_favorite_24)
                }
                Status.LOADING -> displayProgressBar()
                else -> {
                    isAddedToFavourites = false
                    binding.favouriteImageButton.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                }
            }
        }
        this.favouritesViewModel.findByValueLiveData.observe(this, findByValueObserver)
    }

    private fun wireUI(bundle: Bundle) {
        val joke = JokeDetailsFragmentArgs.fromBundle(bundle).joke
        favouritesViewModel.findByValue(joke.value)
        with(this.binding)
        {
            Glide.with(this.root)
                .asBitmap()
                .load(joke.iconUrl)
                .into(chuckNorrisImageView)

            jokeTextView.text = joke.value
            favouriteImageButton.setOnClickListener {
                val favouriteJoke = FavouriteJoke().apply {
                    createdAt = joke.createdAt
                    iconUrl = joke.iconUrl
                    updatedAt = joke.updatedAt
                    url = joke.url
                    value = joke.value
                    id = joke.id
                }

                if (isAddedToFavourites) {
                    favouritesViewModel.delete(favouriteJoke)
                    favouritesViewModel.findByValue(favouriteJoke.value)
                } else {
                    favouritesViewModel.insert(favouriteJoke)
                    favouritesViewModel.findByValue(favouriteJoke.value)
                }
            }
        }
    }

    private fun displayProgressBar() {
        with(this.binding)
        {
            chuckNorrisImageView.visibility = View.GONE
            favouriteImageButton.visibility = View.GONE
            jokeTextView.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
        }
    }

    private fun displayFavouriteJoke() {
        with(this.binding) {
            chuckNorrisImageView.visibility = View.VISIBLE
            favouriteImageButton.visibility = View.VISIBLE
            jokeTextView.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
        }
    }
}