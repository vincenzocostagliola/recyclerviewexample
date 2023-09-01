package co.develhope.recyclerviewexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import co.develhope.recyclerviewexample.data.domain.AnimalItems
import co.develhope.recyclerviewexample.data.domain.AnimalItems.Cat
import co.develhope.recyclerviewexample.data.domain.AnimalItems.CatTitle
import co.develhope.recyclerviewexample.data.domain.AnimalItems.Dog
import co.develhope.recyclerviewexample.data.domain.AnimalItems.DogTitle
import co.develhope.recyclerviewexample.databinding.CatTitleBinding
import co.develhope.recyclerviewexample.databinding.DogTitleBinding
import co.develhope.recyclerviewexample.databinding.ItemAnimalBinding

class AnimalAdapter(val list: List<AnimalItems>, val onClick: (AnimalItems) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        val item = list[position]
        return item.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            1 -> CatViewHolder(ItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            2 -> DogViewHolder(ItemAnimalBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            3 -> CatTitleViewHolder(CatTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            4 -> DogTitleViewHolder(DogTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            else -> throw Exception("Invalid ViewHolder Type")
        }
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        when (holder) {
            is CatViewHolder -> holder.bind(item as Cat, onClick)
            is DogViewHolder -> holder.bind(item as Dog, onClick)
            is CatTitleViewHolder -> holder.bind(item as CatTitle)
            is DogTitleViewHolder -> holder.bind(item as DogTitle)
        }
    }
}


class CatViewHolder(private val binding: ItemAnimalBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Cat, onClick: (AnimalItems) -> Unit) {
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
    fun bind(item: AnimalItems.DogTitle) {

    }
}