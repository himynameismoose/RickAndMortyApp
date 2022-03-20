package com.example.rickandmortyapp.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // View Characters button
        val buttonClick = findViewById<Button>(R.id.view_characters_button)
        buttonClick.setOnClickListener {
            val intent = Intent(this, CharacterListActivity::class.java)
            startActivity(intent)
        }

        // Shared Preferences
        val buttonClick2 = findViewById<Button>(R.id.shared_preferences_button)
        buttonClick2.setOnClickListener {
            val intent = Intent(this, SharedPreferencesActivity::class.java)
            startActivity(intent)
        }
    }
}