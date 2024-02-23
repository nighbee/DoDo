package com.ztktsn.dodo_lab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ztktsn.dodo_lab.adapter.PizzaAdapter

class MainActivity : AppCompatActivity(), PizzaAdapter.OnPizzaClickListener, PizzaAdapter.OnPriceButtonClickListener {

    private lateinit var pizzaAdapter: PizzaAdapter
    private val pizzaList = listOf(
        Pizza("1", "Meat BBQ", R.drawable.naruto, "Succulent BBQ sauce, tender meat, and melted cheese meld together in this flavorful pizza.", "2500"),
        Pizza("2", "Pepperoni", R.drawable.pepperoni, "Classic and irresistible, our pepperoni pizza is loaded with zesty pepperoni slices and gooey cheese.", "3500"),
        Pizza("3", "Tomato With Olives", R.drawable.smeshariki, "A delightful combination of fresh tomatoes and savory olives makes this pizza a Mediterranean-inspired delight.", "2300"),
        Pizza("4", "Mushrooms With Olives", R.drawable.vay, "Our mushrooms with olives pizza is a delightful blend of earthy mushrooms and briny olives, creating a harmonious combination of flavors.", "2600"),
        Pizza("5", "Mushrooms With Beacon", R.drawable.vetchina, "Indulge in the perfect balance of smoky bacon and savory mushrooms with our mushrooms with bacon pizza. Each bite offers a burst of rich flavors.", "2100"),
        Pizza("6", "Mushrooms", R.drawable.mooshroom, "Our mushroom pizza is a vegetarian delight, featuring a medley of fresh mushrooms that lend their distinct earthy taste to every bite.", "3600")
    )

    private lateinit var filteredList: MutableList<Pizza>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchButton: Button = findViewById(R.id.searchButton)
        searchButton.setOnClickListener {
            performSearch()
        }

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        pizzaAdapter = PizzaAdapter(pizzaList, this, this)
        recyclerView.adapter = pizzaAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    override fun onPizzaClick(pizza: Pizza) {
        val intent = Intent(this, Detailed::class.java)
        intent.putExtra("pizza", pizza)
        startActivity(intent)
    }

    override fun onPriceButtonClick(pizza: Pizza) {
        val intent = Intent(this, Detailed::class.java)
        intent.putExtra("pizza", pizza)
        startActivity(intent)
    }

    private fun performSearch() {
        val searchEditText: EditText = findViewById(R.id.searchEditText)
        val searchText = searchEditText.text.toString().trim()

        filteredList = if (searchText.isNotEmpty()) {
            pizzaList.filter { pizza ->
                pizza.name.contains(searchText, ignoreCase = true)
            }.toMutableList()
        } else {
            pizzaList.toMutableList()
        }

        pizzaAdapter.submitList(filteredList)
    }
}