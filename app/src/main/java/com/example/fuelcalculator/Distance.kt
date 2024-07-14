package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

const val KEY_PRICE3 = "KEY_PRICE"
const val KEY_CONSUME2 = "KEY_CONSUME"
const val KEY_DISTANCE = "KEY_DISTANCE"

class Distance : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distance)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtDistance = findViewById<TextInputEditText>(R.id.input_distance_edit_text)
        val btnDistance = findViewById<Button>(R.id.btn_step3)

        btnDistance.setOnClickListener {
            try {
                val price = intent.getFloatExtra("KEY_PRICE", 0f)
                val consume = intent.getFloatExtra("KEY_CONSUME", 0f)
                val distance: Float = edtDistance.text.toString().toFloat()

                val intent = Intent(this, Result::class.java)
                intent.putExtra(KEY_PRICE3, price)
                intent.putExtra(KEY_CONSUME2, consume)
                intent.putExtra(KEY_DISTANCE, distance)
                startActivity(intent)

            } catch (e: NumberFormatException) {
                edtDistance.error = "Por favor, insira um valor válido."
            }

        }

    }
}