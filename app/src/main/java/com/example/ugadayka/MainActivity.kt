package com.example.ugadayka

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.ugadayka.databinding.ActivityMainBinding
import com.example.ugadayka.ui.MainFragment
import com.example.ugadayka.ui.MainViewModel
import com.example.ugadayka.ui.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val provider = ViewModelProvider(this, MainViewModelFactory(application))[MainViewModel::class.java]
        val mainFragment = MainFragment(provider)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, mainFragment)
                .commitNow()
        }
        onBackPressed()

    }

    private var back_pressed: Long = 0

    override fun onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            super.onBackPressed()
        } else {
            Toast.makeText(baseContext, "Нажмите еще раз, чтобы выйти", Toast.LENGTH_SHORT).show()
        }
        back_pressed = System.currentTimeMillis()
    }
}