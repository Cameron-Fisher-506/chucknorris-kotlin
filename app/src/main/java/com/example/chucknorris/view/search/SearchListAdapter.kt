package com.example.chucknorris.view.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chucknorris.databinding.JokeItemBinding
import com.example.chucknorris.model.models.Joke
import com.example.chucknorris.model.models.ChuckNorrisWithJokes

class SearchListAdapter(private val jokeList: ArrayList<Joke>): RecyclerView.Adapter<SearchListAdapter.SearchViewHolder>() {

    class SearchViewHolder(val binding: JokeItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = JokeItemBinding.inflate(inflater, parent,false)
        return SearchViewHolder(binding)

    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        Glide.with(holder.binding.root)
            .asBitmap()
            .load(jokeList[position].iconUrl)
            .into(holder.binding.chuckNorrisImageView)

        holder.binding.jokeTextView.text = jokeList[position].value

        holder.binding.layoutContainer.setOnClickListener(View.OnClickListener {
            val action = SearchListFragmentDirections.actionSearchListFragmentToJokeDetailsFragment2(jokeList[position])
            Navigation.findNavController(it).navigate(action)
        })
    }

    override fun getItemCount() = jokeList.size

    fun updateJokesList(chuckNorrisWithJokes: ChuckNorrisWithJokes)
    {
        this.jokeList.clear()
        this.jokeList.addAll(chuckNorrisWithJokes.jokes)
        notifyDataSetChanged()
    }
}