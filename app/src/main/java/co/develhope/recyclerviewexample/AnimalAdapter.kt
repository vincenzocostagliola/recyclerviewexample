package co.develhope.recyclerviewexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import co.develhope.recyclerviewexample.data.domain.AnimalItems
import co.develhope.recyclerviewexample.databinding.CatTitleBinding
import co.develhope.recyclerviewexample.databinding.DogTitleBinding
import co.develhope.recyclerviewexample.databinding.ItemAnimalBinding

class AnimalAdapter(val list: List<AnimalItems>, val onClick: (AnimalItems) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return CatViewHolder(ItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        (holder as CatViewHolder).bind(item as AnimalItems, onClick)
    }
}


class CatViewHolder(private val binding: ItemAnimalBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: AnimalItems.Cat, onClick: (AnimalItems) -> Unit) {
        binding.title.text = item.name
        binding.subtitle.text = item.breed
        binding.age.text = item.age.toString()
        binding.root.setOnClickListener {
            onClick(item)
        }
    }
}

class DogViewHolder(private val binding: ItemAnimalBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: AnimalItems.Dog, onClick: (AnimalItems) -> Unit) {
        binding.title.text = item.name
        binding.subtitle.text = item.breed
        binding.age.text = item.age.toString()
        binding.root.setOnClickListener {
            onClick(item)
        }
    }
}

class CatTitleViewHolder(private val binding: CatTitleBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: AnimalItems.CatTitle) {

    }
}

class DogTitleViewHolder(private val binding: DogTitleBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: AnimalItems.CatTitle) {

    }
}