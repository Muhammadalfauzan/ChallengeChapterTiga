package com.example.challengechaptertiga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.challengechaptertiga.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding                                                      : ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
       super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)
       setContentView(binding.root)

       val navHostFragment =
           supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
       val navController = navHostFragment.navController

        appBarConfiguration = AppBarConfiguration(navController.graph)
       setupActionBarWithNavController(
           navController = navController,
           configuration = AppBarConfiguration(navController.graph)
       )
   }

    override fun onSupportNavigateUp(): Boolean {

     val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    }



      /*  val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)*/

    }

   /* override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }*/


