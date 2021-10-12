package com.bilgehankalay.unitconverterapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bilgehankalay.unitconverterapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.metersButton.setOnClickListener {
            val intent = Intent(this,MetersActivity::class.java)
            startActivity(intent)
        }
        binding.temperatureButton.setOnClickListener {
            val intent = Intent(this,TemperatureActivity::class.java)
            startActivity(intent)
        }
    }
}