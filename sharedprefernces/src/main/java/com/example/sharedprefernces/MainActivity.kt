package com.example.sharedprefernces

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.restoreButton
import kotlinx.android.synthetic.main.activity_main.saveButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        saveButton.setOnClickListener {
            val editor = getSharedPreferences("data", Context.MODE_PRIVATE).edit()
            editor.putString("name","Tom")
            editor.putInt("age",28)
            editor.putBoolean("married",false)
            editor.apply()
        }

        restoreButton.setOnClickListener {
            val prefs = getSharedPreferences("data",Context.MODE_PRIVATE)
            val name = prefs.getString("name","")
            val age = prefs.getInt("age", 0)
            val married = prefs.getBoolean("married",false)
            Log.d(tag,"name is $name")
            Log.d(tag,"age is $age")
            Log.d(tag,"married id $married")
        }
    }

    companion object {
        const val tag = "MainActivity"
    }
}
