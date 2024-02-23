package com.ztktsn.dodo_lab

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Detailed : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)


        val tvimg: ImageView = findViewById(R.id.img)
        val tvName: TextView = findViewById(R.id.name)
        val tvPrice: TextView = findViewById(R.id.button)
        val tvDescription: TextView = findViewById(R.id.description)

        val pizza: Pizza? = intent.getParcelableExtra("pizza")

        if (pizza != null) {

            tvName.text = pizza.name

            tvimg.setImageResource(pizza.image)

            val priceText = "${pizza.price} KZT"
            tvPrice.text = priceText

            tvDescription.text = pizza.description
        }
    }
}