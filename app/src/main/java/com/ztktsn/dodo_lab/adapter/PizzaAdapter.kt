package com.ztktsn.dodo_lab.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ztktsn.dodo_lab.Pizza
import com.ztktsn.dodo_lab.databinding.ItemPizzaBinding

class PizzaAdapter(
    private var pizzaList: List<Pizza>,
    private val onPizzaClickListener: OnPizzaClickListener?,
    private val onPriceButtonClickListener: OnPriceButtonClickListener?
) : RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder>() {

    private var filteredList: List<Pizza> = pizzaList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPizzaBinding.inflate(inflater, parent, false)
        return PizzaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val pizza = filteredList[position]
        holder.bind(pizza)
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    fun submitList(list: List<Pizza>) {
        pizzaList = list
        filteredList = list
        notifyDataSetChanged()
    }

    fun filter(query: String) {
        filteredList = if (query.isNotBlank()) {
            val lowercaseQuery = query.toLowerCase()
            pizzaList.filter { pizza ->
                pizza.name.toLowerCase().contains(lowercaseQuery)
            }
        } else {
            pizzaList
        }
        notifyDataSetChanged()
    }

    interface OnPizzaClickListener {
        fun onPizzaClick(pizza: Pizza)
    }

    interface OnPriceButtonClickListener {
        fun onPriceButtonClick(pizza: Pizza)
    }

    inner class PizzaViewHolder(private val binding: ItemPizzaBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val pizza = filteredList[adapterPosition]
                onPizzaClickListener?.onPizzaClick(pizza)
            }

            binding.price.setOnClickListener {
                val pizza = filteredList[adapterPosition]
                onPriceButtonClickListener?.onPriceButtonClick(pizza)
            }
        }

        fun bind(pizza: Pizza) {
            binding.img.setImageResource(pizza.image)
            binding.name.text = pizza.name
            binding.description.text = pizza.description
            binding.price.text = pizza.price
        }
    }
}