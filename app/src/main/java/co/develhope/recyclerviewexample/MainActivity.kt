package co.develhope.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import co.develhope.recyclerviewexample.data.Data
import co.develhope.recyclerviewexample.data.domain.Animal
import co.develhope.recyclerviewexample.data.domain.Animal.AnimalType.CAT
import co.develhope.recyclerviewexample.data.domain.Animal.AnimalType.DOG
import co.develhope.recyclerviewexample.data.domain.AnimalItems
import co.develhope.recyclerviewexample.data.domain.AnimalItems.CatTitle
import co.develhope.recyclerviewexample.data.domain.AnimalItems.DogTitle
import co.develhope.recyclerviewexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAdapter()
    }

    private fun setupAdapter() {
        val animalList = Data.getAnimalsList()
        val itemsToShow = createItemsList(animalList)

        binding.rv.adapter = AnimalAdapter(list = itemsToShow) { cat ->
            Toast.makeText(this, "Il mio gatto si chiama: ${cat.name}", Toast.LENGTH_LONG).show()
        }
    }

    private fun createItemsList(animalList: List<Animal>): List<AnimalItems> {
        val itemToShow = mutableListOf<AnimalItems>()

        itemToShow.add(CatTitle)
        animalList.forEach { animal ->
            if(animal.type == CAT){
                itemToShow.add(AnimalItems.Cat(
                    name = animal.name,
                    breed = animal.breed,
                    age = animal.age
                ))
            }
        }

        itemToShow.add(DogTitle)
        animalList.forEach { animal ->
            if(animal.type == DOG){
                itemToShow.add(AnimalItems.Dog(
                    name = animal.name,
                    breed = animal.breed,
                    age = animal.age
                ))
            }
        }

        return itemToShow
    }
}