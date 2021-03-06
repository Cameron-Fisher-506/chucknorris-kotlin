package com.example.chucknorris.view.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.chucknorris.R
import com.example.chucknorris.databinding.JokeListFragmentBinding
import com.example.chucknorris.enum.Status
import com.example.chucknorris.model.models.Joke
import com.example.chucknorris.utils.Resource

class JokeListFragment : Fragment(R.layout.joke_list_fragment) {
    private lateinit var binding: JokeListFragmentBinding
    private lateinit var jokeViewModel: JokeViewModel
    private lateinit var jokeListAdapter: JokeListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.binding = JokeListFragmentBinding.bind(view)

        this.jokeViewModel = ViewModelProviders.of(this).get(JokeViewModel::class.java)

        this.jokeViewModel.getRandomJokes(true)
        attachObservers()
        wireUI()
    }

    private fun attachObservers() {
        val randomJokesObserver = Observer<Resource<List<Joke>>> {
            when (it.status) {
                Status.SUCCESS -> {
                    displayJokesRecyclerView()
                    it.data?.let { data -> this.jokeListAdapter.updateJokesList(data) }
                }
                Status.ERROR -> displayErrorMessage()
                Status.LOADING -> displayProgressBar()
            }
        }
        this.jokeViewModel.randomJokesLiveData.observe(this, randomJokesObserver)
    }

    private fun displayErrorMessage() {
        with(this.binding)
        {
            jokesRecyclerView.visibility = View.GONE
            progressBar.visibility = View.GONE
            errorMessageTextView.visibility = View.VISIBLE
        }
    }

    private fun displayJokesRecyclerView() {
        with(this.binding)
        {
            jokesRecyclerView.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
            errorMessageTextView.visibility = View.GONE
        }
    }

    private fun displayProgressBar() {
        with(this.binding)
        {
            jokesRecyclerView.visibility = View.GONE
            errorMessageTextView.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
        }
    }

    private fun wireUI() {
        this.jokeListAdapter = JokeListAdapter(arrayListOf())
        with(this.binding) {
            jokesRecyclerView.layoutManager = GridLayoutManager(context, 1)
            jokesRecyclerView.adapter = jokeListAdapter

            refreshLayout.setOnRefreshListener {
                displayProgressBar()
                jokeViewModel.getRandomJokes(true)
                refreshLayout.isRefreshing = false
            }
        }
    }
}