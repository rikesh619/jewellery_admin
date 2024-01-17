package com.brjewels.admin.android.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.brjewels.admin.android.R
import com.brjewels.admin.android.databinding.ActivityDashboardBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.ref.WeakReference

class DashboardActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tabBar : BottomNavigationView = binding.bottomNavigationView
        val navController = findNavController(R.id.nav_host_fragment_activity_dashboard)

        navController.addOnDestinationChangedListener{navController , destination , _ ->
            val weakSelf = WeakReference(this)

            when(destination.id){
                R.id.nav_categories ->{

                }

                R.id.nav_products -> {

                }

                R.id.nav_profile -> {

                }
            }

        }

        tabBar.setupWithNavController(navController)
    }
}