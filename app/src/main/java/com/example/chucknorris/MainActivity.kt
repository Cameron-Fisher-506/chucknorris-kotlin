package com.example.chucknorris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.chucknorris.databinding.ActivityMainBinding
import com.example.chucknorris.view.menu.MenuActivity
import com.example.chucknorris.view.search.SearchActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
        attachNavController()
        wireUI()
    }

    private fun attachNavController() {
        this.navController = Navigation.findNavController(this, R.id.fragmentContainer)
        NavigationUI.setupActionBarWithNavController(this, this.navController)
    }

    private fun wireUI() {
        this.binding.bottomNavigationView.selectedItemId = R.id.home
        this.binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.search -> startActivity(Intent(this, SearchActivity::class.java))
                R.id.menu -> startActivity(Intent(this, MenuActivity::class.java))
            }
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(this.navController, null)
    }
}