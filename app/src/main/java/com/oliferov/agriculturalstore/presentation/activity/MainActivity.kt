package com.oliferov.agriculturalstore.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.oliferov.agriculturalstore.R
import com.oliferov.agriculturalstore.databinding.ActivityMainBinding
import com.oliferov.agriculturalstore.presentation.fragment.StartFragment

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, StartFragment.newInstance())
            .commit()
    }
}