package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

const val KEY_CONSUME = "KEY_CONSUME"
const val KEY_PRICE2 = "KEY_PRICE"

class Consume : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consume)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtConsume = findViewById<TextInputEditText>(R.id.input_consume_edit_text)
        val btnConsume = findViewById<Button>(R.id.btn_step2)

        btnConsume.setOnClickListener {
            try {
                val price = intent.getFloatExtra("KEY_PRICE", 0f)
                val consume: Float = edtConsume.text.toString().toFloat()
                val intent = Intent(this, Distance::class.java)
                intent.putExtra(KEY_PRICE2, price)
                intent.putExtra(KEY_CONSUME, consume)
                startActivity(intent)
            } catch (e: NumberFormatException) {
                edtConsume.error = "Por favor, insira um valor válido."
            }

        }

    }
}