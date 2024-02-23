package com.ztktsn.dodo_lab

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Detailed : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        // Bind views from XML layout
        val tvimg: ImageView = findViewById(R.id.img)
        val tvName: TextView = findViewById(R.id.name)
        val tvPrice: TextView = findViewById(R.id.button)
        val tvDescription: TextView = findViewById(R.id.description)

        val pizza: Pizza? = intent.getParcelableExtra("pizza")

        if (pizza != null) {
            // Set the pizza name
            tvName.text = pizza.name

            // Set the pizza image
            tvimg.setImageResource(pizza.image)

            // Set the pizza price
            val priceText = "Price: ${pizza.price} KZT"
            tvPrice.text = priceText

            // Set the pizza description
            tvDescription.text = pizza.description
        }
    }
}