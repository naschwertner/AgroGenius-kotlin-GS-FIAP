package com.example.gs_agrogenius

import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.gs_agrogenius.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    companion object {
        const val THEME_KEY = "current_theme"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedPreferences = getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE)
        val isDarkTheme = sharedPreferences.getBoolean(THEME_KEY, false)

        // Configura o tema atual antes de chamar super.onCreate() e setContentView()
        if (isDarkTheme) {
            setTheme(R.style.Theme_GSAgroGenius)
        } else {
            setTheme(R.style.Theme_GSAgroGenius_Purple)
        }

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = binding.appBarMain.toolbar
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_previsao, R.id.nav_irrigacao
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                val sharedPreferences = getSharedPreferences("APP_PREFERENCES", Context.MODE_PRIVATE)
                val isDarkTheme = sharedPreferences.getBoolean(THEME_KEY, false)

                if (isDarkTheme) {
                    setTheme(R.style.Theme_GSAgroGenius)
                    sharedPreferences.edit().putBoolean(THEME_KEY, false).apply()
                } else {
                    setTheme(R.style.Theme_GSAgroGenius_Purple)
                    sharedPreferences.edit().putBoolean(THEME_KEY, true).apply()
                }

                recreate()

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
