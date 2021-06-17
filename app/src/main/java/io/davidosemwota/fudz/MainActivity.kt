package io.davidosemwota.fudz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.davidosemwota.fudz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}