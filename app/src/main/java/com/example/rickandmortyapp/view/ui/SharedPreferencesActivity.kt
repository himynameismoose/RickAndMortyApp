@file:Suppress("DEPRECATION")

package com.example.rickandmortyapp.view.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.view.ui.PreferenceHelper.clearValues
import com.example.rickandmortyapp.view.ui.PreferenceHelper.customPreference
import com.example.rickandmortyapp.view.ui.PreferenceHelper.defaultPreference
import com.example.rickandmortyapp.view.ui.PreferenceHelper.password
import com.example.rickandmortyapp.view.ui.PreferenceHelper.userId
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SharedPreferencesActivity : AppCompatActivity(), View.OnClickListener {

    private val customPrefName = "User_data"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shared_preferences_activity)

        val btnSave = findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener(this)
        val btnClear = findViewById<Button>(R.id.btnClear)
        btnClear.setOnClickListener(this)
        val btnShow = findViewById<Button>(R.id.btnShow)
        btnShow.setOnClickListener(this)
        val btnShowDefault = findViewById<Button>(R.id.btnShowDefault)
        btnShowDefault.setOnClickListener(this)

        val defaultPrefs = defaultPreference(this)
        defaultPrefs.userId = 1234
        defaultPrefs.password = "Birdperson"

        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val editor = sharedPreference.edit()
        editor.putString("username","Mr. Meeseeks")
        editor.putLong("l",100L)
        editor.apply()
    }

    override fun onClick(view: View?) {
        val prefs = customPreference(this, customPrefName)
        val inPassword = findViewById<EditText>(R.id.inPassword)
        val inUserId = findViewById<EditText>(R.id.inUserId)
        when (view?.id) {
            R.id.btnSave -> {
                prefs.password = inPassword.text.toString()
                prefs.userId = inUserId.text.toString().toInt()
            }
            R.id.btnClear -> {
                prefs.clearValues
            }
            R.id.btnShow -> {
                inUserId.setText(prefs.userId.toString())
                inPassword.setText(prefs.password)
            }
            R.id.btnShowDefault -> {
                val defaultPrefs = defaultPreference(this)
                inUserId.setText(defaultPrefs.userId.toString())
                inPassword.setText(defaultPrefs.password)
            }
        }
    }
}

object PreferenceHelper {

    private const val USER_ID = "USER_ID"
    private const val USER_PASSWORD = "PASSWORD"

    fun defaultPreference(context: Context): SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

    fun customPreference(context: Context, name: String): SharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)

    private inline fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) {
        val editMe = edit()
        operation(editMe)
        editMe.apply()
    }

    var SharedPreferences.userId
        get() = getInt(USER_ID, 0)
        set(value) {
            editMe {
                it.putInt(USER_ID, value)
            }
        }

    var SharedPreferences.password
        get() = getString(USER_PASSWORD, "")
        set(value) {
            editMe {
                it.putString(USER_PASSWORD, value)
            }
        }

    @Suppress("UNUSED_PARAMETER")
    var SharedPreferences.clearValues
        get() = { }
        set(value) {
            editMe {
                it.clear()
            }
        }
}
