package com.example.fuelcalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class Result : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val price = intent.getFloatExtra("KEY_PRICE", 0f)
        val consume = intent.getFloatExtra("KEY_CONSUME", 0f)
        val distance = intent.getFloatExtra("KEY_DISTANCE", 0f)

        val result = distance / consume * price

        val formattedResult = "$%.2f".format(result)
        val tvResult = findViewById<TextView>(R.id.tv_result)
        tvResult.text = formattedResult

        val tvPrice = findViewById<TextView>(R.id.tv_price)
        tvPrice.text = price.toString()
        val tvDistance = findViewById<TextView>(R.id.tv_distance)
        tvDistance.text = distance.toString()

        val btnReturn = findViewById<Button>(R.id.btn_return)

        btnReturn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


        }

    }
}