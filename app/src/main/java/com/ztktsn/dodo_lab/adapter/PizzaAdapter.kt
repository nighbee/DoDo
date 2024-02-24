import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ztktsn.dodo_lab.Pizza
import com.ztktsn.dodo_lab.Combo
import com.ztktsn.dodo_lab.MainActivity
import com.ztktsn.dodo_lab.databinding.ItemComboBinding
import com.ztktsn.dodo_lab.databinding.ItemPizzaBinding

class PizzaAdapter(
    private var pizzaList: List<Pizza>,
    private var comboList: List<Combo>,
    private val onPizzaClickListener: OnPizzaClickListener?,
    private val onComboClickListener: OnComboClickListener?,
    private val onPriceButtonClickListener: OnPriceButtonClickListener?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var filteredList: List<Any> = pizzaList + comboList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            ITEM_TYPE_PIZZA -> {
                val binding = ItemPizzaBinding.inflate(inflater, parent, false)
                PizzaViewHolder(binding)
            }
            ITEM_TYPE_COMBO -> {
                val binding = ItemComboBinding.inflate(inflater, parent, false)
                ComboViewHolder(binding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PizzaViewHolder -> {
                val pizza = filteredList[position] as Pizza
                holder.bind(pizza)
            }
            is ComboViewHolder -> {
                val combo = filteredList[position] as Combo
                holder.bind(combo)
            }
        }
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    override fun getItemViewType(position: Int): Int {
        val item = filteredList[position]
        return if (item is Pizza) {
            ITEM_TYPE_PIZZA
        } else if (item is Combo) {
            ITEM_TYPE_COMBO
        } else {
            throw IllegalArgumentException("Invalid item type")
        }
    }

    fun submitList(list: List<Pizza>) {
        pizzaList = list
        filteredList = list + comboList
        notifyDataSetChanged()
    }

    fun filter(query: String) {
        filteredList = if (query.isNotBlank()) {
            val lowercaseQuery = query.toLowerCase()
            pizzaList.filter { pizza ->
                pizza.name.toLowerCase().contains(lowercaseQuery)
            } + comboList.filter { combo ->
                combo.name.toLowerCase().contains(lowercaseQuery)
            }
        } else {
            pizzaList + comboList
        }
        notifyDataSetChanged()
    }

    interface OnPizzaClickListener {
        fun onPizzaClick(pizza: Pizza)
    }

    interface OnComboClickListener {
        fun onComboClick(combo: Combo)
        fun onComboPriceButtonClick(combo: Combo)
    }

    interface OnPriceButtonClickListener {
        fun onPriceButtonClick(pizza: Pizza)
    }

    inner class PizzaViewHolder(private val binding: ItemPizzaBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val pizza = filteredList[adapterPosition] as Pizza
                onPizzaClickListener?.onPizzaClick(pizza)
            }

            binding.price.setOnClickListener {
                val pizza = filteredList[adapterPosition] as Pizza
                onPriceButtonClickListener?.onPriceButtonClick(pizza)
            }
        }

        fun bind(pizza: Pizza) {
            binding.img.setImageResource(pizza.image)
            binding.name.text = pizza.name
            binding.description.text = pizza.description
            binding.price.text = pizza.price.toString()
        }
    }

    inner class ComboViewHolder(private val binding: ItemComboBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val combo = filteredList[adapterPosition] as Combo
                onComboClickListener?.onComboClick(combo)
            }

            binding.price.setOnClickListener {
                val combo = filteredList[adapterPosition] as Combo
                onComboClickListener?.onComboPriceButtonClick(combo)
            }
        }

        fun bind(combo: Combo) {
            binding.img.setImageResource(combo.image)
            binding.name.text = combo.name
            binding.description.text = combo.description
            binding.price.text = combo.price
        }
    }

    companion object {
        private const val ITEM_TYPE_PIZZA = 0
        private const val ITEM_TYPE_COMBO = 1
    }
}