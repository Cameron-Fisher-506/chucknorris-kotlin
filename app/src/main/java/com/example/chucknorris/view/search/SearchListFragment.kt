package com.example.chucknorris.view.search

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.example.chucknorris.R
import com.example.chucknorris.databinding.SearchListFragmentBinding
import com.example.chucknorris.enum.Status
import com.example.chucknorris.model.models.Jokes
import com.example.chucknorris.utils.Resource
import kotlinx.android.synthetic.main.search_list_fragment.*

class SearchListFragment : Fragment(R.layout.search_list_fragment) {
    private lateinit var binding: SearchListFragmentBinding
    private lateinit var searchViewModel: SearchViewModel
    private lateinit var searchListAdapter: SearchListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        this.binding = SearchListFragmentBinding.bind(view)

        this.searchViewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)

        this.searchViewModel.getJokesBySearch("Animal")
        attachObservers()
        wireUI()
    }

    private fun attachObservers() {
        val jokesBySearchObserver = Observer<Resource<Jokes>> {
            when (it.status){
                Status.SUCCESS -> {
                    hideLoading()
                    it.data?.let { data -> this.searchListAdapter.updateJokesList(data) }
                }
                Status.ERROR -> showLoadingError()
                Status.LOADING -> showLoading()
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
            errorTextView.visibility = View.GONE
        }
    }

    private fun hideLoading() {
        with(this.binding){
            loadingProgressBar.visibility = View.GONE
            searchRecyclerView.visibility = View.VISIBLE
            errorTextView.visibility = View.GONE
        }
    }

    private fun showLoadingError(){
        with(this.binding){
            loadingProgressBar.visibility = View.GONE
            searchRecyclerView.visibility = View.GONE
            errorTextView.visibility = View.VISIBLE
        }
    }
}