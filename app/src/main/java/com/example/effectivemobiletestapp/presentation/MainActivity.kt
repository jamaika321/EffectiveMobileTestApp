package com.example.effectivemobiletestapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.example.effectivemobiletestapp.R
import com.example.feature_homestore.presentation.HomeStoreFragment

class MainActivity : AppCompatActivity() {

    private val fragmentManager: FragmentManager = supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager.beginTransaction()
            .add(R.id.fragment_container_view_tag, HomeStoreFragment())
            .commit()
    }
}