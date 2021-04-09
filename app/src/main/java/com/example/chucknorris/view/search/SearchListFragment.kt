package com.example.chucknorris.view.search

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.chucknorris.R
import com.example.chucknorris.databinding.SearchListFragmentBinding
import com.example.chucknorris.model.Jokes
import com.example.chucknorris.view.jokes.JokeListAdapter
import kotlinx.android.synthetic.main.search_list_fragment.*

class SearchListFragment : Fragment(R.layout.search_list_fragment) {
    private lateinit var binding: SearchListFragmentBinding
    private lateinit var searchViewModel: SearchViewModel
    private lateinit var searchListAdapter: SearchListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.binding = SearchListFragmentBinding.bind(view)

        this.searchViewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)

        attachObservers()
        wireUI()
    }

    private fun attachObservers() {
        val jokesBySearchObserver = Observer<Jokes> {
            if (it != null) {
                hideLoading()
                this.searchListAdapter.updateJokesList(it)
            } else {
                //display error message
            }
        }
        this.searchViewModel.jokesBySearch.observe(this, jokesBySearchObserver)
    }

    private fun wireUI() {
        this.binding.searchEditText.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId == EditorInfo.IME_ACTION_DONE || event.action == KeyEvent.ACTION_DOWN || event.action == KeyEvent.KEYCODE_ENTER) {
                showLoading()
                searchViewModel.getJokesBySearch(searchEditText.text.toString())
            }
            false
        }

        this.searchListAdapter = SearchListAdapter(arrayListOf())
        this.binding.searchRecyclerView.layoutManager = GridLayoutManager(context, 1)
        this.binding.searchRecyclerView.adapter = this.searchListAdapter
    }

    private fun showLoading() {
        with(this.binding) {
            loadingProgressBar.visibility = View.VISIBLE
            searchRecyclerView.visibility = View.GONE
        }
    }

    private fun hideLoading() {
        with(this.binding){
            loadingProgressBar.visibility = View.GONE
            searchRecyclerView.visibility = View.VISIBLE
        }
    }
}