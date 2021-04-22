package com.example.chucknorris.view.jokes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chucknorris.databinding.JokeItemBinding
import com.example.chucknorris.model.models.Joke
import com.example.chucknorris.model.models.ChuckNorrisWithJokes

class JokeListAdapter(private val jokeList: ArrayList<Joke>) :
    RecyclerView.Adapter<JokeListAdapter.JokeViewHolder>() {

    class JokeViewHolder(val binding: JokeItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = JokeItemBinding.inflate(inflater, parent, false)
        return JokeViewHolder(binding)

    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        Glide.with(holder.binding.root)
            .asBitmap()
            .load(jokeList[position].iconUrl)
            .into(holder.binding.chuckNorrisImageView)

        holder.binding.jokeTextView.text = jokeList[position].value

        holder.binding.layoutContainer.setOnClickListener(View.OnClickListener {
            val action =
                JokeListFragmentDirections.actionJokeListFragmentToJokeDetailsFragment(jokeList[position])
            Navigation.findNavController(it).navigate(action)
        })
    }

    override fun getItemCount() = jokeList.size

    fun updateJokesList(jokes: List<Joke>) {
        this.jokeList.clear()
        this.jokeList.addAll(jokes)
        notifyDataSetChanged()
    }
}