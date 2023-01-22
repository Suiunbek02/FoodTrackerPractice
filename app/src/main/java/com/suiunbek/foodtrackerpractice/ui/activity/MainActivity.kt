package com.suiunbek.foodtrackerpractice.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import com.suiunbek.foodtrackerpractice.App
import com.suiunbek.foodtrackerpractice.R
import com.suiunbek.foodtrackerpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        showFirstScreen()
    }

//    private fun showFirstScreen() {
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
//        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
//
//        if (!IS_SING_UP_SHOWED){
//
//
//        }else {
//            navGraph.setStartDestination(R.id.noteAppMainFragment)
//
//        }
//
//        navController.graph = navGraph
//    }
//    private companion object{
//
//        val IS_SING_UP_SHOWED = App.preferenceHelper.isSingUpShowed("signUp")
//
//    }
}