package com.example.chucknorris.view.search

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.chucknorris.MainActivity
import com.example.chucknorris.R
import com.example.chucknorris.databinding.MenuActivityBinding
import com.example.chucknorris.databinding.SearchActivityBinding
import com.example.chucknorris.view.menu.MenuActivity

class SearchActivity : AppCompatActivity() {
    private lateinit var binding: SearchActivityBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = SearchActivityBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        attachNavController()
        wireUI()
    }

    private fun attachNavController() {
        this.navController = Navigation.findNavController(this, R.id.navHostFragment)
        NavigationUI.setupActionBarWithNavController(this, this.navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(this.navController, null)
    }

    private fun wireUI() {
        this.binding.bottomNavigationView.selectedItemId = R.id.search
        this.binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> startActivity(Intent(this, MainActivity::class.java))
                R.id.menu -> startActivity(Intent(this, MenuActivity::class.java))
            }
            true
        }
    }
}