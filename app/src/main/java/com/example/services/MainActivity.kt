package com.example.services

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.services.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListener()
    }

    private fun setupListener() {
        binding.btnStartService.setOnClickListener {
            startService(Intent(this@MainActivity, MyService::class.java))

        }

        binding.btnStopService.setOnClickListener {
            stopService(Intent(this@MainActivity, MyService::class.java))

        }

        binding.btnStartIntentService.setOnClickListener {
            val intent = Intent(this@MainActivity, MyIntentService::class.java).apply {
                action = MY_ACTION
                putExtra(INT_EXTRA, 5)
            }
            startService(intent)
        }

        binding.btnTest.setOnClickListener {
            Toast.makeText(
                this,
                "test",
                Toast.LENGTH_SHORT
            ).show()
        }

        }
    }