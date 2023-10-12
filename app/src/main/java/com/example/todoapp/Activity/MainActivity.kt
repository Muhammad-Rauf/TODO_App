package com.example.todoapp.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
                btnCallList.setOnClickListener {
                    startActivity(Intent(this@MainActivity, CallListActivity::class.java))

                }
                btnBuyList.setOnClickListener {
                    startActivity(Intent(this@MainActivity, BuyListActivity::class.java))
                }
                btnSellList.setOnClickListener {
                    startActivity(Intent(this@MainActivity, SellListActivity::class.java))
                }

        }
    }

}