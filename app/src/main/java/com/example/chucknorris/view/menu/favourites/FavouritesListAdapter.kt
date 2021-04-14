package com.example.chucknorris.view.menu.favourites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chucknorris.databinding.JokeItemBinding
import com.example.chucknorris.model.models.FavouriteJoke
import com.example.chucknorris.model.models.Joke

class FavouritesListAdapter(private val favourites: ArrayList<FavouriteJoke>) :
    RecyclerView.Adapter<FavouritesListAdapter.ViewHolder>() {

    class ViewHolder(val binding: JokeItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = JokeItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.binding.root)
            .asBitmap()
            .load(favourites[position].iconUrl)
            .into(holder.binding.chuckNorrisImageView)

        holder.binding.jokeTextView.text = favourites[position].value

        holder.binding.layoutContainer.setOnClickListener {
            val joke = Joke().apply {
                createdAt = favourites[position].createdAt
                iconUrl = favourites[position].iconUrl
                updatedAt = favourites[position].updatedAt
                url = favourites[position].url
                value = favourites[position].value
            }
            val action =
                FavouritesFragmentDirections.actionFavouritesFragmentToFavouritesDetailsFragment(joke)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount() = favourites.size

    fun updateFavouritesList(favourites: List<FavouriteJoke>) {
        this.favourites.clear()
        this.favourites.addAll(favourites)
        notifyDataSetChanged()
    }
}