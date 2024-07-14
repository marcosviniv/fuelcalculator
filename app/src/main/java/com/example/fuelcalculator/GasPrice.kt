package com.example.fuelcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

const val KEY_PRICE = "KEY_PRICE"

class GasPrice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_gas_price)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val edtPrice = findViewById<TextInputEditText>(R.id.input_price_edit_text)
        val btnStep1 = findViewById<Button>(R.id.btn_step1)

        btnStep1.setOnClickListener {
            try {
                val price: Float = edtPrice.text.toString().toFloat()
                val intent = Intent(this, Consume::class.java)
                intent.putExtra(KEY_PRICE, price)
                startActivity(intent)
            } catch (e: NumberFormatException) {
                edtPrice.error = "Por favor, insira um valor válido."
            }
        }

    }
}